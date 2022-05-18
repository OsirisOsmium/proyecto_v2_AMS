import java.sql.SQLException;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
		String user="alumnoAMS17";
		String password="alumnoAMS17";
		connectionOracle conn=new connectionOracle(url,user,password);
		try {
			conn.prueba(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
