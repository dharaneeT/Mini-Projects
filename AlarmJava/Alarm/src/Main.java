import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Alarmdao alarmDao = new Alarmdao();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter index for Setting the Alarm:");
			System.out.println("1 for 12:00:00\n2 for 11:00:00\n3 for 10:30:00\n4 for 01:00:00\n5 for 02:00:00");

			int id = sc.nextInt();

			alarmDao.connect();
			LocalTime alarmTime = alarmDao.getAlarmTime(id);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

			System.out.println("Alarm set for " + alarmTime.format(formatter));

			AlarmClock alarmClock = new AlarmClock(alarmTime);
			Thread alarmThread = new Thread(alarmClock);
			alarmThread.start();
			alarmThread.join();
		} catch (SQLException | InterruptedException e) {
			System.out.println("Database error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
