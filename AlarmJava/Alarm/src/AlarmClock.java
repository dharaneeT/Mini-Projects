import javax.tools.Tool;
import java.awt.*;
import java.time.LocalTime;

public class AlarmClock implements Runnable {

	private final LocalTime alarmTime;

	AlarmClock(LocalTime alarmTime) {
		this.alarmTime = alarmTime;
	}

	@Override
	public void run() {
		while (LocalTime.now().isBefore(alarmTime)) {
			try {
				Thread.sleep(1000);
				int hour = LocalTime.now().getHour();
				int min = LocalTime.now().getMinute();
				int sec = LocalTime.now().getSecond();
				System.out.printf("\r%02d:%02d:%02d", hour, min, sec);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
        Toolkit.getDefaultToolkit().beep();
	}
}
