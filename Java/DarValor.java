import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DarValor {
	public static void main(String[] args) {
		System.out.println(conseguirValor("DEUTERIUM_BASE_ENEMY_ARMY"));
	}
	public static int conseguirValor(String constante) {
		 BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	     Connection cn = null;
	
	     try {
	         // Carga el driver de oracle
	        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	         
	         // Conecta con la base de datos orcl con el usuario system y la contrase�a password
	
	         cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoAMS17", "alumnoAMS17");
	         
	         // Llamada al procedimiento almacenado
	         CallableStatement cst = cn.prepareCall("{call GET_CONSVAL_BYNAME (?,?)}");
	         cst.setString(1, constante);
	         cst.registerOutParameter(2, java.sql.Types.INTEGER);
	         cst.execute();
	         int valor=cst.getInt(2);
	         return valor;
	     } catch (SQLException ex) {
	         System.out.println("Error: " + ex.getMessage());
	     } finally {
	         try {
	             cn.close();
	         } catch (SQLException ex) {
	             System.out.println("Error: " + ex.getMessage());
	         }
	     }
		return 0;
	}
}
