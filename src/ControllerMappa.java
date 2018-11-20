import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/mappa")
public class ControllerMappa {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getJson() {
        Mappa mappa=new Mappa("Roma", 23.5473905, 10.5267);
            return mappa.builtJson("Europa");
        }
    }


