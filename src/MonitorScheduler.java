import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class MonitorScheduler {

    private int interval;
    private ScheduledFuture<?> executorSchedule;

    public MonitorScheduler(int interval){
        this.interval = interval;
    }

    public void start(){
        // Scheduler will be called every interval, the first call is after interval seconds.
        this.executorSchedule = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> monitoring(), 0, interval, TimeUnit.SECONDS);

    }

    public void stop(){
        this.executorSchedule.cancel(false);
    }

    protected abstract void monitoring();


}
