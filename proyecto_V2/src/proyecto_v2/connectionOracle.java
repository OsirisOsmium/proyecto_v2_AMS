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
	/*
	public boolean LogIn(String username, String password) {
		boolean validar=false;
		String txt="";
		try {			
			String query = "select * from usr where username='"+username+"'";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while (rs.next()) { 
				String uss=rs.getString("username");
				String pas=rs.getString("password");
				
//////////////////////se ha cambiado la validacion para deje asar falta revisar
				
				if (username!=uss && password!=pas) {
					txt=txt+
							"username: "+uss+
							"\npassword: "+pas;
					validar=false;
					System.out.println("else false");
				}
				else {
					txt=txt+
							"username: "+uss+
							"\npassword: "+pas;
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
		//return txt;
		return validar;
	}
	*/
	
	public boolean LogIn(String username, String password) {
		String txt="";
		boolean action=true;
			try {
				CallableStatement cst = conn.prepareCall("{call GET_USER_ (?,?,?,?)}");
				//int id = -1;
				System.out.println("llama al procedimiento get_user_");
				//do {
		            cst.setString(1, username);
		            
		            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		            cst.registerOutParameter(4, java.sql.Types.INTEGER);
	
		            cst.execute();
		            String us=cst.getString(2);
		            String pas=cst.getString(3);
		            String ides=cst.getString(4);
		            
		            /*if (username!="null" || username!="null"){
		            	txt=txt+"nada insertado";
		            	System.out.println("null");
		            }*/
		            
		            
		            if (username.equals(us) && password.equals(pas)) {
		            	txt=txt+
								"username: "+us+
								"\npassword: "+pas+
								"\nId: "+ides;
		            	action=true;
		            	System.out.println("Correcto usuario");
		            	System.out.println(action);

		            }
		            else {
		            	txt=txt+
								"username: "+us+
								"\npassword: "+pas;
		            	action=false;
		            	System.out.println("Mal usuario");
		            	System.out.println(action);

		            }
				//}while (id>0);

			}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
            action=false;
        }
		//return txt;
		return action;
	}
	
	public boolean SignIn(String username, String password, String date) {
		boolean action=false;
		
		try {
			CallableStatement cst = conn.prepareCall("{call INSERT_USER (?,?,?,?)}");
			
			System.out.println("llama al procedimiento insert_user");
			cst.setString(1, "(select max(id_user) from usr)");
            cst.setString(2,username);
            cst.setString(3, password);
            cst.setString(4, date); 
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            
            action=true;
		
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
            action=false;
        }
		
		return action;
	}
	
	
	
	
	
	
	public String get_ship(int ids) {
		String text="";
		//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			CallableStatement cst = conn.prepareCall("{call GET_SHIP (?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento");
			do {
	            // Parametro 1 del procedimiento almacenado
	            cst.setInt(1, ids);
	            
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
	            		"\nCost Metal: "+metal_cost+
	            		"\nCost Deuterium: "+deuterium_cost+
	            		"\nCost Crystal: "+crystal_cost+
	            		"\nInitial Armor: "+initialArmor+
	            		"\nArmor: "+armor+
	            		"\nBase Damage: "+baseDamage+
	            		"\nSpeed: "+speed+
	            		"\nWasting: "+generateWasting;
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
		return text;
	}
	
	public String get_defense(int ids) {
		String text="";
		//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			CallableStatement cst = conn.prepareCall("{call GET_DEFENSE (?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento");
			do {
	            // Parametro 1 del procedimiento almacenado
	            cst.setInt(1, ids);
	            
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
	            		"\nCost Metal: "+metal_cost+
	            		"\nCost Deuterium: "+deuterium_cost+
	            		"\nCost Crystal: "+crystal_cost+
	            		"\nInitial Armor: "+initialArmor+
	            		"\nArmor: "+armor+
	            		"\nBase Damage: "+baseDamage+
	            		"\nSpeed: "+speed+
	            		"\nWasting: "+generateWasting;
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
		return text;
	}

	public void viewStats(int ids) {
		try {
			viewWindow view=new viewWindow();
			CallableStatement cst = conn.prepareCall("{call GET_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento");
			do {
	            // Parametro 1 del procedimiento almacenado
	            cst.setInt(1, ids);
	            
	            // Definimos los tipos de los parametros de salida del procedimiento almacenado
	            cst.registerOutParameter(2, java.sql.Types.INTEGER);
	            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
	            cst.registerOutParameter(4, java.sql.Types.INTEGER);
	            cst.registerOutParameter(5, java.sql.Types.INTEGER);
	            cst.registerOutParameter(6, java.sql.Types.INTEGER);
	            cst.registerOutParameter(7, java.sql.Types.INTEGER);
	            cst.registerOutParameter(8, java.sql.Types.INTEGER);
	            cst.registerOutParameter(9, java.sql.Types.INTEGER);
	            cst.registerOutParameter(10, java.sql.Types.INTEGER);
	            cst.registerOutParameter(11, java.sql.Types.INTEGER);
	            cst.registerOutParameter(12, java.sql.Types.INTEGER);
	            cst.registerOutParameter(13, java.sql.Types.INTEGER);
	            cst.registerOutParameter(14, java.sql.Types.INTEGER);
	            cst.registerOutParameter(15, java.sql.Types.INTEGER);
	            cst.registerOutParameter(16, java.sql.Types.INTEGER);
	            cst.registerOutParameter(17, java.sql.Types.INTEGER);
	            
	            // Ejecuta el procedimiento almacenado
	            cst.execute();
	            String numMetal=cst.getString(4);
	            String numDeuterium=cst.getString(6);
	            
	            String lvlAttack=cst.getString(16);
	            String lvlDefense=cst.getString(14);
	            
	            String numLight=cst.getString(7);
	            String numHeavy=cst.getString(8);
	            String numBattle=cst.getString(9);
	            String numArmored=cst.getString(10);
	            
	            String numMissile=cst.getString(11);
	            String numIon=cst.getString(12);
	            String numPlasma=cst.getString(13);
	            
	            view.lblNumMetal.setText(String.valueOf(numMetal));
				view.lblNumDeuterium.setText(String.valueOf(numDeuterium));
				
				view.lblLvlAtack.setText(String.valueOf(lvlAttack));
				view.lblLvlDefense.setText(String.valueOf(lvlDefense));
				
				view.lblNumLight.setText(String.valueOf(numLight));
				view.lblNumHeavy.setText(String.valueOf(numHeavy));
				view.lblNumBattle.setText(String.valueOf(numBattle));
				view.lblNumArmored.setText(String.valueOf(numArmored));
				
				view.lblnumMissile.setText(String.valueOf(numMissile));
				view.lblNumIon.setText(String.valueOf(numIon));
				view.lblNumPlasma.setText(String.valueOf(numPlasma));         
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
	}
	
	public void viewUpgrade(int ids) {
		try {
			upgradeWindow up=new upgradeWindow();
			CallableStatement cst = conn.prepareCall("{call GET_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento get_upgrade");
			do {
	            // Parametro 1 del procedimiento almacenado
	            cst.setInt(1, ids);
	            
	            // Definimos los tipos de los parametros de salida del procedimiento almacenado
	            cst.registerOutParameter(2, java.sql.Types.INTEGER);
	            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
	            cst.registerOutParameter(4, java.sql.Types.INTEGER);
	            cst.registerOutParameter(5, java.sql.Types.INTEGER);
	            cst.registerOutParameter(6, java.sql.Types.INTEGER);
	            cst.registerOutParameter(7, java.sql.Types.INTEGER);
	            cst.registerOutParameter(8, java.sql.Types.INTEGER);
	            cst.registerOutParameter(9, java.sql.Types.INTEGER);
	            cst.registerOutParameter(10, java.sql.Types.INTEGER);
	            cst.registerOutParameter(11, java.sql.Types.INTEGER);
	            cst.registerOutParameter(12, java.sql.Types.INTEGER);
	            cst.registerOutParameter(13, java.sql.Types.INTEGER);
	            cst.registerOutParameter(14, java.sql.Types.INTEGER);
	            cst.registerOutParameter(15, java.sql.Types.INTEGER);
	            cst.registerOutParameter(16, java.sql.Types.INTEGER);
	            cst.registerOutParameter(17, java.sql.Types.INTEGER);
	            
	            // Ejecuta el procedimiento almacenado
	            cst.execute();
	            String costDefenseUP=cst.getString(15);
	            String CostAttackUP=cst.getString(17);
	            String LvlAttack=cst.getString(16);
	            String LvlDefense=cst.getString(14);
	            
	            up.lblCostDefense.setText(String.valueOf(costDefenseUP));
				up.lblCostAttack.setText(String.valueOf(CostAttackUP));				
				up.lblActualAttack.setText(String.valueOf(LvlAttack));
				up.lblActualDefense.setText(String.valueOf(LvlDefense));
				System.out.println("ha devuelto los valores de el update");        
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
	}
	
	
	public void addTrops(String tipo, int cant, int numMetal, int numDeuterium) {
		
		if (tipo=="Light Hunter") {
			tipo="NUM_LIGHTHUNTER";
		}
		else if(tipo=="Heavy Hunter") {
			tipo="NUM_HEAVYHUNTER";
		}
		else if (tipo=="Battle Ship") {
			tipo="NUM_BATTLESHIP";
		}
		else if (tipo=="Armored Ship") {
			tipo="NUM_ARMOREDSHIP";
		}
		else if (tipo=="Missile Launcher") {
			tipo="NUM_MISSILELAUNCHER";
		}
		else if (tipo=="Ion Cannon") {
			tipo="NUM_IONCANNON";
		}
		else if (tipo=="PLasma Cannon") {
			tipo="NUM_PLASMACANNON";
		}
		try {
		       String sqlactualizar="UPDATE planet SET NUM_LIGHTHUNTER="+cant;
		       PreparedStatement psta=conn.prepareStatement(sqlactualizar);
		       psta.execute();
		       JOptionPane.showMessageDialog(null, "Añadido correctamente");
		    }catch (Exception e){
		        System.out.println(e.getCause());

		    }
	}
}
