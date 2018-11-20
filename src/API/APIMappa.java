package API;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import Util.Citta;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/APIMappa")
public class APIMappa {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})

    public ArrayList<Citta> getJson() {
        ArrayList<Citta> cittas =new ArrayList();
        for(int i=0;i<10; i++){
            Citta citta =new Citta("Citta" +i, i+5, i*i,"{}");
            cittas.add(citta);
        }
           return cittas;
        }
    }


