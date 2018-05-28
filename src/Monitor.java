import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Monitor extends MonitorScheduler {

    private String url;
    private Map<String, String> report;

    public Monitor(int interval, String url){
        super(interval);
        this.url = "http://" + url;
        this.report = new HashMap<>();
    }

    /**
     * Check the status of the 'url' server
     */
    @Override
    protected void monitoring(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        HttpURLConnection httpConn = null;
        try {
            URL url = new URL(this.url);
            httpConn = (HttpURLConnection)url.openConnection();
            httpConn.setInstanceFollowRedirects( false );
            httpConn.setRequestMethod( "HEAD" );
            httpConn.connect();
            report.put(dateFormat.format(date), Integer.toString(httpConn.getResponseCode()));
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (ProtocolException e) {
            e.printStackTrace();
        } catch(java.net.ConnectException e){
            report.put(dateFormat.format(date), "SERVER WAS DOWN...");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.url + " Monitor{" +
                "report=" + report +
                '}';
    }
}
