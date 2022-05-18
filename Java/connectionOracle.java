

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
	int ides;
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
	public void prueba(int num) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select count(*) from planet where id_planet="+num);
		rs.next();
		System.out.println(rs.getInt(1));
		rs.close();
	}
	public boolean LogIn(String username, String password) {
		String txt="";
		boolean action=true;
			try {
				CallableStatement cst = conn.prepareCall("{call GETPLAYER (?,?,?,?,?)}");
				//int id = -1;
				System.out.println("llama al procedimiento get_user_");
				//do {
		            cst.setString(1, username);
		            
		            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		            cst.registerOutParameter(4, java.sql.Types.INTEGER);
		            cst.registerOutParameter(5, java.sql.Types.VARCHAR);

		            
	
		            cst.execute();
		            String us=cst.getString(2);
		            String pas=cst.getString(3);
		            this.ides=cst.getInt(4);
		            String date=cst.getString(5);
		            
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
	public int getIdes() {
		return this.ides;
	}
	public void setIdes(int ides) {
		this.ides=ides;
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
			//viewWindow view=new viewWindow(new Planet(),new ArrayList<MilitaryUnit>[4]);
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
	            
	           /* view.lblNumMetal.setText(String.valueOf(numMetal));
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
			Planet planet=new Planet();
			//upgradeWindow up=new upgradeWindow(planet);
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
	            
	            /*up.lblCostDefense.setText(String.valueOf(costDefenseUP));
				up.lblCostAttack.setText(String.valueOf(CostAttackUP));				
				up.lblActualAttack.setText(String.valueOf(LvlAttack));
				up.lblActualDefense.setText(String.valueOf(LvlDefense));*/
				System.out.println("ha devuelto los valores de el update");        
	            
	        }while (id>0);
		}
		catch (SQLException ex) {
			System.out.println("ERROR: ha havido algun error");
            System.out.println("Error: " + ex.getMessage());
        }
	}
	public void insertarPlaneta(Planet planet) {
		try { 
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from planet where id_planet="+ides);
			rs.next();
			int planetaEx=rs.getInt(1);
			rs.close();
			if (planetaEx==0) {
				CallableStatement cst = conn.prepareCall("{call INSERT_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		         
		         // Parametro 1 del procedimiento almacenado
		         
		         // Definimos los tipos de los parametros de salida del procedimiento almacenado
		         cst.setInt(1, ides);
		         cst.setString(2, "Planeta");
		         cst.setInt(3, planet.getMetal());
		         cst.setInt(4, 0);
		         cst.setInt(5, planet.getDeuterium());
		         cst.setInt(6, planet.getArmy()[0].size());
		         cst.setInt(7, planet.getArmy()[1].size());
		         cst.setInt(8, planet.getArmy()[2].size());
		         cst.setInt(9, planet.getArmy()[3].size());
		         cst.setInt(10, planet.getArmy()[4].size());
		         cst.setInt(11, planet.getArmy()[5].size());
		         cst.setInt(12, planet.getArmy()[6].size());
		         cst.setInt(13, planet.getTechnologyDefense());
		         cst.setInt(14,planet.getUpgradeDefenseTechnologyDeuteriumCost());
		         cst.setInt(15, planet.getTechnologyAtack());
		         cst.setInt(16,planet.getUpgradeAttackTechnologyDeuteriumCost());
		         
		         // Ejecuta el procedimiento almacenado
		         cst.execute();
	
	     
			}
			else if(planetaEx>0) {
				CallableStatement cst=conn.prepareCall("{call SET_PLANET (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				Statement stm=conn.createStatement();
				ResultSet rst=st.executeQuery("select * from planet where player_id_player="+ides);
				rs.next();
				int id_planeta=rs.getInt(0);
				rs.close();
				 cst.setInt(1, ides);
				 cst.setInt(2, id_planeta);
		         cst.setString(3, "Planeta");
		         cst.setInt(4, planet.getMetal());
		         cst.setInt(5, 0);
		         cst.setInt(6, planet.getDeuterium());
		         cst.setInt(7, planet.getArmy()[0].size());
		         cst.setInt(8, planet.getArmy()[1].size());
		         cst.setInt(9, planet.getArmy()[2].size());
		         cst.setInt(10, planet.getArmy()[3].size());
		         cst.setInt(11, planet.getArmy()[4].size());
		         cst.setInt(12, planet.getArmy()[5].size());
		         cst.setInt(13, planet.getArmy()[6].size());
		         cst.setInt(14, planet.getTechnologyDefense());
		         cst.setInt(15,planet.getUpgradeDefenseTechnologyDeuteriumCost());
		         cst.setInt(16, planet.getTechnologyAtack());
		         cst.setInt(17,planet.getUpgradeAttackTechnologyDeuteriumCost());
		         
		         // Ejecuta el procedimiento almacenado
		         cst.execute();
			}
		 } catch (SQLException ex) {
		     System.out.println("Error: " + ex.getMessage());
		     ex.printStackTrace();
		 } 
	}
	
	public Planet recibirPlaneta() {
		Planet planet=new Planet();
		try {
			CallableStatement cst = conn.prepareCall("{call GET_PLANET_BYUSER (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            // Parametro 1 del procedimiento almacenado
			System.out.println("IDES "+ides);
	            cst.setInt(1, ides);
	            
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
	            cst.registerOutParameter(11, java.sql.Types.INTEGER);
	            cst.registerOutParameter(12, java.sql.Types.INTEGER);
	            cst.registerOutParameter(13, java.sql.Types.INTEGER);
	            cst.registerOutParameter(14, java.sql.Types.INTEGER);
	            cst.registerOutParameter(15, java.sql.Types.INTEGER);
	            cst.registerOutParameter(16, java.sql.Types.INTEGER);
	            
	            // Ejecuta el procedimiento almacenado
	            cst.execute();
	            int lh=cst.getInt(6);
	            int hh=cst.getInt(7);
	            int bs=cst.getInt(8);
	            int as=cst.getInt(9);
	            int ml=cst.getInt(10);
	            int ic=cst.getInt(11);
	            int pc=cst.getInt(12);
	            int totalMetal=cst.getInt(3)+Variables.METAL_COST_LIGTHHUNTER*lh
	            +Variables.METAL_COST_HEAVYHUNTER*hh+Variables.METAL_COST_BATTLESHIP*bs
	            +Variables.METAL_COST_ARMOREDSHIP*as+Variables.METAL_COST_MISSILELAUNCHER*ml+
	            Variables.METAL_COST_IONCANNON*ic+Variables.METAL_COST_PLASMACANNON*pc;
	            int totalDeuterio=cst.getInt(5)+Variables.DEUTERIUM_COST_LIGTHHUNTER*lh
	    	            +Variables.DEUTERIUM_COST_HEAVYHUNTER*hh+Variables.DEUTERIUM_COST_BATTLESHIP*bs
	    	            +Variables.DEUTERIUM_COST_ARMOREDSHIP*as+Variables.DEUTERIUM_COST_MISSILELAUNCHER*ml+
	    	            Variables.DEUTERIUM_COST_IONCANNON*ic+Variables.DEUTERIUM_COST_PLASMACANNON*pc;
	            if (cst.getString(2)!=null) {
		            planet=new Planet(totalMetal,totalDeuterio);
		            int costDefenseUP=cst.getInt(14);
		            int CostAttackUP=cst.getInt(16);
		            int LvlAttack=cst.getInt(15);
		            int LvlDefense=cst.getInt(13);
		            planet.setTechnologyAtack(LvlAttack);
		            planet.setTechnologyDefense(LvlDefense);
		            planet.setUpgradeAttackTechnologyDeuteriumCost(CostAttackUP);
		            planet.setUpgradeDefenseTechnologyDeuteriumCost(costDefenseUP);
		            planet.newLigthHunter(lh);
		            planet.newHeavyHunter(hh);
		            planet.newBattleShip(bs);
		            planet.newArmoredShip(as);
		            planet.newMissileLauncher(ml);
		            planet.newIonCannon(ic);
		            planet.newPlasmaCannon(pc);
	            }
			}
	        catch (SQLException ex) {
	    			System.out.println("ERROR: ha havido algun error");
	                System.out.println("Error: " + ex.getMessage());
	           }
		return planet;
	}
	
	public void insertarEnemigo(ArrayList<MilitaryUnit>[] enemyArmy,int metalInicial,int deuterioInicial) {
		try { 
			CallableStatement cst = conn.prepareCall("{call INSERT_ENEMY (?,?,?,?,?,?,?,?,?,?)}");
	         
	         
	         // Parametro 1 del procedimiento almacenado
	         
	         // Definimos los tipos de los parametros de salida del procedimiento almacenado
	         cst.setString(1, "Ejercito enemigo");
	         cst.setInt(2, metalInicial);
	         cst.setInt(3, 0);
	         cst.setInt(4, deuterioInicial);
	         cst.setInt(5, enemyArmy[0].size());
	         cst.setInt(6, enemyArmy[1].size());
	         cst.setInt(7, enemyArmy[2].size());
	         cst.setInt(8, enemyArmy[3].size());
	         cst.setInt(9, 0);
	         cst.setInt(10, 0);
	         
	         // Ejecuta el procedimiento almacenado
	         cst.execute();
	
	     
	
		 } catch (SQLException ex) {
		     System.out.println("Error: " + ex.getMessage());
		 } 
	}

	public void insertarBattle(Battle battle) {
		try { 
			CallableStatement cst = conn.prepareCall("{call INSERT_BATTLE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	         
	         Statement st=conn.createStatement();
	         ResultSet rs=st.executeQuery("select max(id_enemy) from enemy");
	         rs.next();
	         int idEnemigo=rs.getInt(1);
	         rs.close();
	         // Parametro 1 del procedimiento almacenado
	         
	         // Definimos los tipos de los parametros de salida del procedimiento almacenado
	         cst.setInt(1, ides);
	         cst.setInt(2, idEnemigo);
	         cst.setInt(3, ides);
	         /*cst.setInt(4, deuterioInicial);
	         cst.setInt(5, enemyArmy[0].size());
	         cst.setInt(6, enemyArmy[1].size());
	         cst.setInt(7, enemyArmy[2].size());
	         cst.setInt(8, enemyArmy[3].size());
	         cst.setInt(9, 0);
	         cst.setInt(10, 0);*/
	         
	         // Ejecuta el procedimiento almacenado
	         cst.execute();
	
	     
	
		 } catch (SQLException ex) {
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
		       String sqlactualizar="UPDATE planet SET "+tipo+"="+cant;
		       PreparedStatement psta=conn.prepareStatement(sqlactualizar);
		       psta.execute();
		       JOptionPane.showMessageDialog(null, "A�adido correctamente");
		    }catch (Exception e){
		        System.out.println(e.getCause());

		    }
	}
	
	
}
