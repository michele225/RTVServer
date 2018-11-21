package Util;

import Model.Citta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;


public class Hibernate{

    private static SessionFactory sessionFactory;

    private static ServiceRegistry registry;

    public static Session getSession() {
        if (sessionFactory == null) {
            System.out.println("Richiedo la buildSessionJavaConfigFactory");
            sessionFactory = buildSessionJavaConfigFactory();
        } else {
            System.out.println("Factory già presente");
        }
        return sessionFactory.openSession();
    }

    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = new Configuration();
            //Create Properties, can be read from property files too
            Properties props = new Properties();
            props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
            props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/RTV_DB");
            props.put("hibernate.connection.username", "postgres");
            props.put("hibernate.connection.password", "giovanni");
            props.put("hibernate.dialect", "net.sf.hibernate.dialect.PostgreSQLDialect");
            props.put("hibernate.hbm2ddl.auto", "update");
            props.put("hibernate.show_sql", "true");
            props.put("hibernate.format_sql", "true");
            props.put(Environment.C3P0_MIN_SIZE, 5);         //Minimum size of pool
            props.put(Environment.C3P0_MAX_SIZE, 30);        //Maximum size of pool
            props.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);//Number of connections acquired at a time when pool is exhausted
            props.put(Environment.C3P0_TIMEOUT, 1800);       //Connection idle time
            props.put(Environment.C3P0_MAX_STATEMENTS, 150); //PreparedStatement cache size
            props.put(Environment.C3P0_CONFIG_PREFIX + ".initialPoolSize", 5); // i.e. 'hibernate.c3p0.initialPoolSize'
            props.put(Environment.C3P0_IDLE_TEST_PERIOD, 30);

            configuration.setProperties(props);

            configuration.addAnnotatedClass(Citta.class);

            registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Java Config ServiceRegistry created");

            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}