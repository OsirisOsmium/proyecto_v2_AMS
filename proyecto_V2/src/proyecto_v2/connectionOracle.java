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

public class connectionOracle {
	
	Connection conn;
	
	public connectionOracle(String url, String user, String password){
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
	
	public void SingIn(String username, String password, String date) {
		try {
			String query = "SELECT max(user_id)+1 FROM users";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			
			int user_id=rs.getInt(1);
			//falla aqui con 
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO user values(id_user, username, password, to_Date(birth_date,'DD-MM-YYYY')) VALUES (?,?,?,?,?)");
			pstm.setInt(1, user_id);
			pstm.setString(2, "'"+username+"'");
			pstm.setString(4, "'"+password+"'");
			pstm.setString(3, "'"+date+"'");
			
			pstm.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR: El uruario ya existe");
			System.out.println("ERROR GENERAL: Ha havido algun error");
		}
	}
	
	
	
	
	
	
	
	
	
	public String viewStatPlanet() {
		String txt="";
			
		return txt;
	}
	
	
	
	public String viewDefense(String nom) {
		String texto="";
		try {
			String query = "select * from defense where name ='"+nom+"'";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while (rs.next()){
				texto=texto+"Nombre: "+rs.getString(2)+"\nMetal Cost: "+rs.getInt(3)
				+"\nCrystal Cost: "+rs.getInt(4)+"\nDeuterium Cost: "+rs.getInt(5)
				+"\nInitial Armor: "+rs.getInt(6)+"\nArmor: "+rs.getInt(7)
				+"\nBase Damage: "+rs.getInt(8)+"\nSpeed: "+rs.getInt(9)
				+"\nGenerate Warnings: "+rs.getInt(10);
			}
			
			System.out.println("EXITO: El registro existe");
		} catch (SQLException e) {
			System.out.println("ERROR: El granjero no existe");
		}
		return texto;
	}
	public String viewTrops(String nom) {
		String texto="";
		try {
			String query = "select * from ship where name ='"+nom+"'";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while (rs.next()){
				texto=texto+"Nombre: "+rs.getString(2)+"\nMetal Cost: "+rs.getInt(3)
				+"\nCrystal Cost: "+rs.getInt(4)+"\nDeuterium Cost: "+rs.getInt(5)
				+"\nInitial Armor: "+rs.getInt(6)+"\nArmor: "+rs.getInt(7)
				+"\nBase Damage: "+rs.getInt(8)+"\nSpeed: "+rs.getInt(9)
				+"\nGenerate Warnings: "+rs.getInt(10);
			}
			
			System.out.println("EXITO: El ship existe");
		} catch (SQLException e) {
			System.out.println("ERROR: El ship no existe");
		}
		return texto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String get_ship(int id) {
		String text="";
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			CallableStatement cst = conn.prepareCall("{call  (?,?,?,?,?,?,?,?,?,?)}");
			do {
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
	            String nom=cst.getString(2);
	            int metal_cost=cst.getInt(3);
	            int deuterium_cost=cst.getInt(4);
	            int crystal_cost=cst.getInt(5);
	            int initialArmor=cst.getInt(6);
	            int armor=cst.getInt(7);
	            int baseDamage=cst.getInt(8);
	            int speed=cst.getInt(9);
	            int generateWasting=cst.getInt(10);
	            text=text+
	            		"Name: "+nom+
	            		"Cost Metal: "+metal_cost+
	            		"Cost Deuterium: "+deuterium_cost+
	            		"Cost Crystal: "+crystal_cost+
	            		"Initial Armor: "+initialArmor+
	            		"Armor: "+armor+
	            		"Base Damage: "+baseDamage+
	            		"Speed: "+speed+
	            		"Wasting: "+generateWasting;
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
		return text;
	}

}
