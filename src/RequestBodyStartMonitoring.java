import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBodyStartMonitoring {
    @XmlElement int interval;
    @XmlElement String url;

}
