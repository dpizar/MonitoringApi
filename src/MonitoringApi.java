import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/MonitoringApi")
public class MonitoringApi {
    private static Map<String,Monitor> urlBeingMonitored = new HashMap<>();

    @GET
    @Path("/start/{interval}/{url}")
    @Produces(MediaType.TEXT_PLAIN)
    public String start(@PathParam("interval") Integer interval, @PathParam("url") String url){
        String message = "Start monitoring " + url + " URL, with "+ interval + " interval";
        Monitor monitor = new Monitor(interval,url);
        this.urlBeingMonitored.put(url, monitor);
        monitor.start();
        return message;

    }

    @GET
    @Path("/stop/{url}")
    @Produces(MediaType.TEXT_PLAIN)
    public String stop(@PathParam("url") String url){
        if (this.urlBeingMonitored.containsKey(url)){
            Monitor monitor = this.urlBeingMonitored.get(url);
            monitor.stop();
            return "Stop monitoring " + url + " URL";
        }
        return url +" has not been monitoring before.";
    }

    @GET
    @Path("/result")
    @Produces(MediaType.TEXT_PLAIN)
    public String result(){
        String result = "";

        for (String url : this.urlBeingMonitored.keySet()){
            result= result.concat(this.urlBeingMonitored.get(url).toString());
        }
        return result;
    }

}

