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
	
	
	public boolean LogIn(String username, String password) {
		boolean validar=false;
		try {			
			String query = "select * from usr where username='"+username+"'";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while (rs.next()) { 
				String uss=rs.getString("username");
				String pas=rs.getString("password");
				
//////////////////////se ha cambiado la validacion para deje asar falta revisar
				
				if (username==uss && password==pas) {
					validar=false;
					System.out.println("else false");
				}
				else {
					validar=true;
					System.out.println("else true");
				}
			}	
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("ERROR: El usuario no existe");
			System.out.println("ERROR GENERAL: Ha havido algun error");
		}
		return validar;
	}
	
	public void SingIn(String username, String password, String date) {
		try {	
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO usr values((select max(id_user)+1 from usr), username, password, to_Date(birth_date,'DD-MM-YYYY')) VALUES ((select max(id_user)+1 from usr),?,?,?)");

			pstm.setString(1, "'"+username+"'");
			pstm.setString(2, "'"+password+"'");
			pstm.setString(3, "'"+date+"'");
			
			pstm.executeUpdate();	
		}
			
		
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR: El uruario ya existe");
			System.out.println("ERROR GENERAL: Ha havido algun error");
		}
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
	
	
	
	
	
	
	
	
	public void viewStats() {
		try {
			System.out.println("Conexion correcta");
			String query = "select * from planet where id_planet = 1";
			PreparedStatement consulta = conn.prepareStatement(query);
			//consulta.setString(1, reciboPalabraUsuario);
			ResultSet resultado = consulta.executeQuery();
			
			while(resultado.next()) {
				int Quantity_metal=resultado.getInt("quantity_metal");
				int Quantity_deuterium=resultado.getInt("quantity_deuterium");
				
				int LvlTechnology=resultado.getInt("current_leveldefense");
				int LvlDefense=resultado.getInt("current_leveldefense");
				
				
				int LightH=resultado.getInt("num_lighthunter");
				int HeavyH=resultado.getInt("num_heavyhunter");
				int BattleShip=resultado.getInt("num_battleship");
				int ArmoredShip=resultado.getInt("num_armoredship");
				
				int MissileLauncher=resultado.getInt("num_missilelauncher");
				int IonCannon=resultado.getInt("num_ioncannon");
				int PlasmaCannon=resultado.getInt("num_plasmacannon");				
			}
		}
		catch(SQLException e) {
		System.out.println("ERROR: Ha havido algun error");
		}	
	}
	
	
	public void addTrops(String tipo, int cant, int numMetal, int numDeuterium) {
		String texto="";
		try {
			String query = "update planet values("+tipo+", quantity_metal, quantity_deuterium) values (?,?,?) where id_planet = 1";
			PreparedStatement pstmnt=conn.prepareStatement(query);
			ResultSet rs=pstmnt.executeQuery(query);
			while (rs.next()){
				pstmnt
				
			}
			
			System.out.println("EXITO: El ship existe");
		} catch (SQLException e) {
			System.out.println("ERROR: El ship no existe");
		}
		return texto;
		
	}
	 
}
