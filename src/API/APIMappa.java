package API;

import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import Model.Citta;
import Util.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/APIMappa")
public class APIMappa {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})


    public String getJson() {
        Session session= Hibernate.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("From Citta");
        Citta citta = (Citta) ((org.hibernate.query.Query) query).uniqueResult();
        System.out.println(citta.toString());


       /* ArrayList<Citta> cittas =new ArrayList();
        for(int i=0;i<10; i++){
            Citta citta =new Citta(i,"Citta " +i, "");
            cittas.add(citta);
        }
           return cittas;*/
       return "ciao";

    }

}


