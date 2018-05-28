import java.util.concurrent.TimeUnit;

public class test_monitor {
    public static void main(String args[]) throws InterruptedException {
        Monitor test_monitor = new Monitor(10, "www.google.com/");
        test_monitor.start();
        TimeUnit.MINUTES.sleep(1);
        test_monitor.stop();
        System.out.print(test_monitor.toString());


    }
}
