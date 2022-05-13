import java.util.Timer;
import java.util.TimerTask;

public class PruebaTimerTask {
	private static Timer time = new Timer();
	static TimerTask task = new TimerTask() {;
		

	public void schedule(TimerTask task,long delay, long period) {
		run();
	}
        public void run()
        {
            
          System.out.println("Hola mundo");
            
        }
        };
        public static void main(String[] args) {
        	time.schedule(task, 10000, 5000);
		}
}
