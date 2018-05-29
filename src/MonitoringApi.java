import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/MonitoringApi")
public class MonitoringApi {
    private static Map<String,Monitor> urlBeingMonitored = new HashMap<>();

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String start(RequestBodyStartMonitoring request_body){
        String message = "Start monitoring " + request_body.url + " URL, with "+ request_body.interval + " interval";
        Monitor monitor = new Monitor(request_body.interval,request_body.url);
        this.urlBeingMonitored.put(request_body.url, monitor);
        monitor.start();
        return message;

    }

    @POST
    @Path("/stop")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String stop(RequestBodyStopMonitoring request_body){
        if (this.urlBeingMonitored.containsKey(request_body.url)){
            Monitor monitor = this.urlBeingMonitored.get(request_body.url);
            monitor.stop();
            return "Stop monitoring " + request_body.url + " URL";
        }
        return request_body.url +" has not been monitoring before.";
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

