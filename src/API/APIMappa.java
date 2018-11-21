package API;


import Tests.MappaEntity;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
//import Model.Citta;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/APIMappa")
public class APIMappa {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})

    public void getJson() throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.getCurrentSession();

        Transaction tx= session.beginTransaction();

        Query query= session.createQuery("from Tests.MappaEntity");
     //   List<MappaEntity> mappaEntities=query.list();

        query = session.createQuery("select all from MappaEntity where id= 10");
        int result = query.executeUpdate();
        System.out.println("Citta presa ="+result);
        
       // MappaEntity mappaEntity=new MappaEntity();
      //  mappaEntities.add((MappaEntity) mappaEntity.getCities());


        tx.rollback();

        //closing hibernate resources
        sessionFactory.close();


       /* List<MappaEntity> mappaEntities=query.list();
        for (MappaEntity map: mappaEntities){
            System.out.println("nome:"+map.getNome()+", cities"+map.getCities());
        }*/
     //  return "ciao";

    }

}


