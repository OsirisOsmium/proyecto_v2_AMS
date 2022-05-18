import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
	public Connection conexion() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	    Connection cn = null;
	
	    try {
	        // Carga el driver de oracle
	       DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	        
	        // Conecta con la base de datos orcl con el usuario system y la contrase�a password
	
	        cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoAMS17", "alumnoAMS17");
	
	    } catch (SQLException ex) {
	        System.out.println("Error: " + ex.getMessage());
	    } 
	    return cn;
	}
	public void cerrar(Connection cn) {
		try {
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
	}
}
