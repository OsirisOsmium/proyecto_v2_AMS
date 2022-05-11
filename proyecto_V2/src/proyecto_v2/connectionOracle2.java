package proyecto_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class connectionOracle2 extends upgradeWindow{
	
	Connection conn;
	
	public connectionOracle2(String url, String user, String password){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("EXITO: El drver se ha cargado");
			
			try {
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("EXITO: Se ha connectado con SQL");
			}
			catch (SQLException e) {
				System.out.println("ERROR: No se ha connectado con SQL");
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("ERROR: El driver NO se ha cargado");
		}
	}
	
	public void viewUpgrade() {
		try {
			
			String query = "select * from planet where id_planet = 1";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while(rs.next()) {
				int costDefenseUP=rs.getInt("cost_defenseup");
				int CostAttackUP=rs.getInt("cost_attackup");
				
				int LvlAttack=rs.getInt("current_levelattack");
				int LvlDefense=rs.getInt("current_leveldefense");
				
				super.lblCostDefense.setText(String.valueOf(costDefenseUP));
				super.lblCostAttack.setText(String.valueOf(CostAttackUP));				
				super.lblActualAttack.setText(String.valueOf(LvlAttack));
				super.lblActualDefense.setText(String.valueOf(LvlDefense));
				System.out.println("ha devuelto los valores de el update");
			}
		}
		catch(SQLException e) {
			System.out.println("ERROR: Ha havido algun error");
		}
	}
}
