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
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void iniciar() {
		try {
			CallableStatement cst=conn.prepareCall("");
			
			cst.execute();
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
	}
	
	
	public ArrayList<Integer> extraeId() {
        ArrayList<Integer> ides = new ArrayList<Integer>();
        try {
			String query = "select * from battle";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while (rs.next()){
				ides.add(rs.getInt(1));
			}
			System.out.println("Guardado");
		}catch(SQLException e) {
			System.out.println("Ha habido algun error");
			e.getStackTrace();
		}
        
        
		return (ides);
	}
	
	
	public boolean LogIn(String username, String password) {
		String txt="";
		boolean action=true;
			try {
				CallableStatement cst = conn.prepareCall("{call GET_PLAYER_ (?,?,?,?,?)}");
				//int id = -1;
				System.out.println("llama al procedimiento GET_PLAYER_");
				//do {
		            cst.setString(1, username);
		            
		            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		            cst.registerOutParameter(4, java.sql.Types.INTEGER);
		            cst.registerOutParameter(5, java.sql.Types.VARCHAR);

		            cst.execute();
		            String us=cst.getString(2);
		            String pas=cst.getString(3);
		            String ides=cst.getString(4);
		            String date=cst.getString(5);

		            if (username.equals(us) && password.equals(pas)) {
		            	txt=txt+
								"username: "+us+
								"\npassword: "+pas+
								"\nId: "+ides;
		            	action=true;
		            	System.out.println("Correcto usuario, "+us+" "+pas+" "+ides+" "+date);
		            	System.out.println(action);

		            }
		            else {
		            	txt=txt+
								"username: "+us+
								"\npassword: "+pas;
		            	action=false;
		            	System.out.println("Mal usuario, "+us+" "+pas+" "+ides+" "+date);
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
			CallableStatement cst = conn.prepareCall("{call INSERT_PLAYER (?,?,?)}");
			
			System.out.println("llama al procedimiento insert_user");
            cst.setString(1,username);
            cst.setString(2, password); 
            cst.setString(3, date);
                        
            // Ejecuta el procedimiento almacenado
            cst.execute();
            
            action=true;
            System.out.println(username+" "+password+" "+date);
            System.out.println(action);
		
		}
		catch (SQLException ex) {
            action=false;
            
            System.out.println(username+" "+password+" "+date);
            System.out.println(action);

			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
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
	
	public ArrayList<Integer> Stats(int ids) {
		ArrayList<Integer> stat = new ArrayList<Integer>();
		try {
			CallableStatement cst = conn.prepareCall("{call GET_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento");
			do {
	            cst.setInt(1, ids);
	            
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
	            
	            cst.execute();
	            int numMetal, numDeuterium, lvlAttack, lvlDefense, numLight, numHeavy, numBattle, numArmored, numMissile, numIon, numPlasma;
	            stat.add(numMetal=cst.getInt(4));
	            stat.add(numDeuterium=cst.getInt(6));
	            
	            stat.add(lvlAttack=cst.getInt(16));
	            stat.add(lvlDefense=cst.getInt(14));
	            
	            stat.add(numLight=cst.getInt(7));
	            stat.add(numHeavy=cst.getInt(8));
	            stat.add(numBattle=cst.getInt(9));
	            stat.add(numArmored=cst.getInt(10));
	            
	            stat.add(numMissile=cst.getInt(11));
	            stat.add(numIon=cst.getInt(12));
	            stat.add(numPlasma=cst.getInt(13));
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
		return stat;
	}
	
	
	
	
	
	public ArrayList<Integer> viewEnemy(int ids){
		ArrayList<Integer> ene = new ArrayList<Integer>();
		try {
			CallableStatement cst = conn.prepareCall("{call GET_ENEMY (?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento get_enemy");
			do {
	            cst.setInt(1, ids);
	            
	            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
	            cst.registerOutParameter(3, java.sql.Types.INTEGER);
	            cst.registerOutParameter(4, java.sql.Types.INTEGER);
	            cst.registerOutParameter(5, java.sql.Types.INTEGER);
	            cst.registerOutParameter(6, java.sql.Types.INTEGER);
	            cst.registerOutParameter(7, java.sql.Types.INTEGER);
	            cst.registerOutParameter(8, java.sql.Types.INTEGER);
	            cst.registerOutParameter(9, java.sql.Types.INTEGER);
	            
	            
	            cst.execute();
	            int numMetal, numCristal, numDeuterium, numLight, numHeavy, numBattle, numArmored;
	            ene.add(numMetal=cst.getInt(4));
	            ene.add(numDeuterium=cst.getInt(6));
	
	            ene.add(numLight=cst.getInt(7));
	            ene.add(numHeavy=cst.getInt(8));
	            ene.add(numBattle=cst.getInt(9));
	            ene.add(numArmored=cst.getInt(10));
        
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
		
		return ene;
	}
	
	public ArrayList<Integer> viewWasteMaterial(int ids){
		ArrayList<Integer> mat = new ArrayList<Integer>();
		try {
			CallableStatement cst = conn.prepareCall("{call GET_BATTLE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento GET_GATTLE");
			do {
	            cst.setInt(1, ids);
	            
	            cst.registerOutParameter(2, java.sql.Types.INTEGER);
	            cst.registerOutParameter(3, java.sql.Types.INTEGER);
	            cst.registerOutParameter(4, java.sql.Types.INTEGER);
	            cst.registerOutParameter(5, java.sql.Types.INTEGER);
	            cst.registerOutParameter(6, java.sql.Types.INTEGER);
	            
	            //waste_material
	            cst.registerOutParameter(7, java.sql.Types.INTEGER);
	            cst.registerOutParameter(8, java.sql.Types.INTEGER);
	            
	            //unit_in
	            cst.registerOutParameter(9, java.sql.Types.INTEGER);
	            cst.registerOutParameter(10, java.sql.Types.INTEGER);
	            cst.registerOutParameter(11, java.sql.Types.INTEGER);
	            cst.registerOutParameter(12, java.sql.Types.INTEGER);
	            cst.registerOutParameter(13, java.sql.Types.INTEGER);
	            cst.registerOutParameter(14, java.sql.Types.INTEGER);
	            cst.registerOutParameter(15, java.sql.Types.INTEGER);
	            //unit_fall
	            cst.registerOutParameter(16, java.sql.Types.INTEGER);
	            cst.registerOutParameter(17, java.sql.Types.INTEGER);
	            cst.registerOutParameter(18, java.sql.Types.INTEGER);
	            cst.registerOutParameter(19, java.sql.Types.INTEGER);
	            cst.registerOutParameter(20, java.sql.Types.INTEGER);
	            cst.registerOutParameter(21, java.sql.Types.INTEGER);
	            cst.registerOutParameter(22, java.sql.Types.INTEGER);
	            
	            
	            //enemy_in
	            cst.registerOutParameter(23, java.sql.Types.INTEGER);
	            cst.registerOutParameter(24, java.sql.Types.INTEGER);
	            cst.registerOutParameter(25, java.sql.Types.INTEGER);
	            cst.registerOutParameter(26, java.sql.Types.INTEGER);
	            //enemy_fall
	            cst.registerOutParameter(27, java.sql.Types.INTEGER);
	            cst.registerOutParameter(28, java.sql.Types.INTEGER);
	            cst.registerOutParameter(29, java.sql.Types.INTEGER);
	            cst.registerOutParameter(30, java.sql.Types.INTEGER);
	            
	            cst.execute();
	            
	            int wasteMetal, wasteDeuterium, lightU, heavyU, battleU, armoredU, missileU, ionU, plasmaU, lightF, heavyF, battleF, armoredF, 
	            missileF, ionF, plasmaF,lightE, heavyE, battleE, armoredE, lightEF, heavyEF, battleEF, armoredEF;
	            
	            mat.add(wasteMetal=cst.getInt(7));
	            mat.add(wasteDeuterium=cst.getInt(8));
	            
	            mat.add(lightU=cst.getInt(9));
	            mat.add(heavyU=cst.getInt(10));
	            mat.add(battleU=cst.getInt(11));
	            mat.add(armoredU=cst.getInt(12));
	            mat.add(missileU=cst.getInt(13));
	            mat.add(ionU=cst.getInt(14));
	            mat.add(plasmaU=cst.getInt(15));

	            mat.add(lightF=cst.getInt(16));
	            mat.add(heavyF=cst.getInt(17));
	            mat.add(battleF=cst.getInt(18));
	            mat.add(armoredF=cst.getInt(19));
	            mat.add(missileF=cst.getInt(20));
	            mat.add(ionF=cst.getInt(21));
	            mat.add(plasmaF=cst.getInt(22));
	            
	            mat.add(lightE=cst.getInt(23));
	            mat.add(heavyE=cst.getInt(24));
	            mat.add(battleE=cst.getInt(25));
	            mat.add(armoredE=cst.getInt(26));
	            
	            mat.add(lightEF=cst.getInt(27));
	            mat.add(heavyEF=cst.getInt(28));
	            mat.add(battleEF=cst.getInt(29));
	            mat.add(armoredEF=cst.getInt(30));

	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: gENERAL");
            System.out.println("Error: " + ex.getMessage());
        }
		
		return mat;
	}
	
	public void updateResource(int ids, int metal, int cristal, int deuterium) {
		try {
			CallableStatement cst = conn.prepareCall("{call GET_ENEMY (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int id = -1;
			System.out.println("llama al procedimiento get_enemy");
			do {
	            cst.setInt(1, ids);
	            
	            cst.setInt(3, metal);
	            cst.setInt(4, cristal);
	            cst.setInt(5, deuterium);
	            
	            
	            cst.execute();
	            
        
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
	
	public String viewStep() {
		String text="";
		try {
			String query = "select * from step";
			Statement stmnt=conn.createStatement();
			ResultSet rs=stmnt.executeQuery(query);
			while (rs.next()){
				text=text+"Id_Step: "+rs.getInt(1)+" Battle_id_battle: "+rs.getInt(2)+" OrderPosition: "+rs.getInt(3)+" Descripcion: "+rs.getString(4);

			}
			System.out.println("stemp seteado en el lbl del replay");
		}catch(SQLException e) {
			System.out.println("Ha habido algun error");
			e.getStackTrace();
		}
		return text;
	}
	
	
	
	
	
	
	
	public void addTrops(int id_user, int id_planet, String nom_planet, String tipo, int cant, int numMetal, int numDeuterium) {
		try {
			CallableStatement cst = conn.prepareCall("{call SET_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("llama al procedimiento setPlanet");

				cst.setInt(1, id_user);//id_user
	            cst.setInt(2, id_planet);//i_planet
	            cst.setString(3, nom_planet);//nom_planet
	            if (tipo.equals("Light Hunter")) {
	    			tipo="NUM_LIGHTHUNTER";
	    			cst.setInt(7, cant);
	    		}
	    		else if(tipo.equals("Heavy Hunter")) {
	    			tipo="NUM_HEAVYHUNTER";
	    			cst.setInt(8, cant);
	    		}
	    		else if (tipo.equals("Battle Ship")) {
	    			tipo="NUM_BATTLESHIP";
	    			cst.setInt(9, cant);
	    		}
	    		else if (tipo.equals("Armored Ship")) {
	    			tipo="NUM_ARMOREDSHIP";
	    			cst.setInt(10, cant);
	    		}
	    		else if (tipo.equals("Missile Launcher")) {
	    			tipo="NUM_MISSILELAUNCHER";
	    			cst.setInt(11, cant);
	    		}
	    		else if (tipo.equals("Ion Cannon")) {
	    			tipo="NUM_IONCANNON";
	    			cst.setInt(12, cant);
	    		}
	    		else if (tipo.equals("PLasma Cannon")) {
	    			tipo="NUM_PLASMACANNON";
	    			cst.setInt(13, cant);
	    		}	          
	            
	            cst.execute();				
	            
	              
	            
	         
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
	        System.out.println("Error: " + ex.getMessage());
	    }
	}
	
}