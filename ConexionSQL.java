
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionSQL {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int id = 1;
        Connection cn = null;

        try {
            // Carga el driver de oracle
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos orcl con el usuario system y la contrase�a password

            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoAMS17", "alumnoAMS17");
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call GET_SHIP (?,?,?,?,?,?,?,?,?,?)}");

            do {
                System.out.println("\nIntroduce el ID de la nave:");
                try {
                    id = Integer.parseInt(entrada.readLine());
                } catch (IOException ex) {
                    System.out.println("Error...");
                }
                
                // Parametro 1 del procedimiento almacenado
                cst.setInt(1, id);
                
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.INTEGER);
                cst.registerOutParameter(4, java.sql.Types.INTEGER);
                cst.registerOutParameter(5, java.sql.Types.INTEGER);
                cst.registerOutParameter(6, java.sql.Types.INTEGER);
                cst.registerOutParameter(7, java.sql.Types.INTEGER);
                cst.registerOutParameter(8, java.sql.Types.INTEGER);
                cst.registerOutParameter(9, java.sql.Types.INTEGER);
                cst.registerOutParameter(10, java.sql.Types.INTEGER);
                
                // Ejecuta el procedimiento almacenado
                cst.execute();

            
                // Se obtienen la salida del procedimineto almacenado
                String P_NAME = cst.getString(2);
                int P_INITIALARMOR = cst.getInt(3);
                Integer P_ARMOR = cst.getInt(4);
                Integer P_BASEDAMAGE = cst.getInt(5);
                Integer P_DEUTERIUM_COST = cst.getInt(6);
                Integer P_METAL_COST = cst.getInt(7);
                Integer P_CRYSTAL_COST = cst.getInt(8);
                Integer P_SPEED = cst.getInt(9);
                Integer P_GENERATE_WASTINGS = cst.getInt(10);
                System.out.println("P_NAME: " + P_NAME);
                System.out.println("P_INITIALARMOR: " + P_INITIALARMOR);
                System.out.println("P_ARMOR: " + P_ARMOR);
                System.out.println("P_BASEDAMAGE: " + P_BASEDAMAGE);
                System.out.println("P_DEUTERIUM_COST: " + P_DEUTERIUM_COST);
                System.out.println("P_METAL_COST: " + P_METAL_COST);
                System.out.println("P_CRYSTAL_COST: " + P_CRYSTAL_COST);
                System.out.println("P_SPEED: " + P_SPEED);
                System.out.println("P_GENERATE_WASTINGS: " + P_GENERATE_WASTINGS);
            } while (id > 0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
