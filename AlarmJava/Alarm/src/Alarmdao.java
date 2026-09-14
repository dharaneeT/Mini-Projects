import java.sql.*;
import java.time.LocalTime;

public class Alarmdao {

	private final String userName = "root";
	private final String url = "jdbc:mysql://localhost:3306/alarmdb";
	private final String pass = "#kumar#123";

	Connection con;

	public void connect() throws SQLException {
		con = DriverManager.getConnection(url, userName, pass);
	}

	public LocalTime getAlarmTime(int id) throws SQLException {
		String query = "SELECT alarm FROM alarm WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			LocalTime time = rs.getTime(1).toLocalTime();
			rs.close();
			ps.close();

			return time;
		} else {
			throw new RuntimeException("No alarm found for id: " + id);
		}
	}
}
