package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class reportsWindow extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private JButton btnBack, btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain;
	private JLabel lblNewLabel_2;

	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="PLANET_WARS_V2";
	private String password="PLANET_WARS_V2";
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JComboBox comboBox;
	private JScrollBar scrollBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new reportsWindow();
	}

	/**
	 * Create the frame.
	 */
	public reportsWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 519);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		btnViewPlanetStat = new JButton("View Stats");
		btnViewPlanetStat.addActionListener(this);
		contentPane.setLayout(null);
		btnViewPlanetStat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewPlanetStat.setBounds(10, 46, 92, 33);
		contentPane.add(btnViewPlanetStat);
		
		btnBuild = new JButton("Build");
		btnBuild.addActionListener(this);
		btnBuild.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuild.setBounds(10, 127, 92, 33);
		contentPane.add(btnBuild);
		
		btnUpgrade = new JButton("Upgrade");
		btnUpgrade.addActionListener(this);
		btnUpgrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpgrade.setBounds(10, 84, 92, 33);
		contentPane.add(btnUpgrade);
		
		btnReports = new JButton("Reports");
		btnReports.addActionListener(this);
		btnReports.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReports.setBounds(10, 170, 92, 33);
		contentPane.add(btnReports);
		
		btnThreadComing = new JButton("Coming");
		btnThreadComing.addActionListener(this);
		btnThreadComing.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThreadComing.setBounds(10, 213, 92, 33);
		contentPane.add(btnThreadComing);
		
		btnMain = new JButton("Main");
		btnMain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMain.setBounds(10, 256, 92, 33);
		btnMain.addActionListener(this);
		contentPane.add(btnMain);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogOut.addActionListener(this);
		btnLogOut.setBounds(10, 406, 92, 33);
		contentPane.add(btnLogOut);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_2.setBounds(0, 0, 110, 482);
		lblNewLabel_2.setOpaque(true);
		ImageIcon imagen= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\vertical_space.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);
		
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setEditable(false);
		textArea_1.setBounds(209, 29, 449, 371);
		contentPane.add(textArea_1);
		
		
		JScrollPane sb=new JScrollPane(textArea_1);
        sb.setBounds(298, 27, 487, 433);

        sb.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sb.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(sb);
		
		////////////////////////////
		
		comboBox = new JComboBox();
		comboBox.setBounds(138, 72, 150, 35);
		contentPane.add(comboBox);
		
		String battleRep[]= {"" ,"Battle 1", "Battle 2", "Battle 3" ,"Battle 4"}; //Se ha de modificar para que no s muestre las batallas tin tener en cuanta la cantidad de batallas
		DefaultComboBoxModel comboTrops = new DefaultComboBoxModel(battleRep);
		comboBox.setModel(comboTrops);
		comboBox.addItemListener(this);

		
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 809, 482);
		ImageIcon imagen4= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\espacio_fondo.jpeg");
		ImageIcon icono4= new ImageIcon(imagen4.getImage().getScaledInstance(lblBackground.getWidth(),lblBackground.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblBackground. setIcon(icono4);//establece el ImageIcon en el label
		contentPane.add(lblBackground);		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		connectionOracle conn=new connectionOracle(url, user, password);

		
		if (btnViewPlanetStat==e.getSource()){
			//viewWindow view=new viewWindow();
			this.setVisible(false);
			conn.viewStats(1);
			//view.setVisible(true);
		}
		
		if (btnUpgrade==e.getSource()){
			//upgradeWindow upgrade=new upgradeWindow();
			this.setVisible(false);
			conn.viewUpgrade(1);
			//upgrade.setVisible(true);
		}
		
		if (btnBuild==e.getSource()){
			buildWindow view=new buildWindow();
			this.setVisible(false);
			view.setVisible(true);
		}
		
		if (btnReports==e.getSource()){
			reportsWindow report=new reportsWindow();
			this.setVisible(false);
			//conn.viewStep();
			report.setVisible(true);
		}
		
		if (btnThreadComing==e.getSource()){
			comingWindow coming=new comingWindow();
			this.setVisible(false);
			coming.setVisible(true);
		}
		if (btnLogOut==e.getSource()) {
			logInWindow logIn=new logInWindow();
			this.setVisible(false);
			logIn.setVisible(true);
		}
		if (btnMain==e.getSource()) {
			mainWindow main=new mainWindow();
			this.setVisible(false);
			main.setVisible(true);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		String BattleRep=(String) comboBox.getSelectedItem();
		
		if (BattleRep.equalsIgnoreCase("Battle 1")) {
				/*Estas dos variables id_Batalla y la conexión, se deberian entrar desde fuera*/
				int id_Batalla =1;
				
				
				int 
				/*Costes de las unidades para calcular los costes totales y perdidas SE EXTRAE metal_Cost y Deuterium_Cost Where name = 'LightHunter'*/
				metal_LightHunter, metal_HeavyHunter, metal_BattleShip, metal_ArmoredShip,
				metal_MissileLauncher, metal_IonCannon, metal_PlasmaCannon,
				deuterium_LightHunter, deuterium_HeavyHunter, deuterium_BattleShip, deuterium_ArmoredShip,
				deuterium_MissileLauncher, deuterium_IonCannon, deuterium_PlasmaCannon,
				/*Unidades iniciales Planeta SE EXTRAE UI_LightHunter, UI_HeavyHunter etc*/
				planet_LightHunters, planet_HeavyHunters, 
				planet_BattleShips, planet_ArmoredShips, 
				planet_MissileLauncher, planet_IonCannon, 
				planet_PlasmaCannon,
				/*Unidades iniciales enemigo EI_LightHunter, EI_HeavyHunter etc*/
				enemy_LightHunters, enemy_HeavyHunters,
				enemy_BattleShips, enemy_ArmoredShips,
				/*Unidades finales Planeta SE EXTRAE UF_LightHunter, UF_HeavyHunter etc*/
				planet_LightHunters_F, planet_HeavyHunters_F, 
				planet_BattleShips_F, planet_ArmoredShips_F, 
				planet_MissileLauncher_F, planet_IonCannon_F, 
				planet_PlasmaCannon_F,
				/*Unidades finales enemigo SE EXTRAE EF_LightHunter, EF_HeavyHunter etc*/
				enemy_LightHunters_F, enemy_HeavyHunters_F,
				enemy_BattleShips_F, enemy_ArmoredShips_F,
				/*Los costes de los ejercitos del planeta y del enemigo SE CALCULAN*/
				cost_Metal_Planet, cost_Deuterium_Planet, 
				cost_Metal_Enemy, cost_Deuterium_Enemy,
				/*Las perdidas en recursos del planeta y del enemigo*/
				losses_Metal_Planet, losses_Deuterium_Planet, losses_Weighted_Planet,
				losses_Metal_Enemy, losses_Deuterium_Enemy, losses_Weighted_Enemy,
				/*Residuos generades SE EXTRAE waste_Metal, waste_Deuterium*/
				waste_Metal, waste_Deuterium;
				
				/*Quien ha ganado y perdido, o winner 1 o enemy 1*/
				int winner_Planet, winner_Enemy; 
				
				String respuesta;
				boolean view_Battle;
				
				/*Mensaje que saldra segun gane el planeta/jugador o el enemigo*/
				String message_Winner;
				
				String full_Report;
				
				
				/*BBDD*/metal_LightHunter= 3000;
				/*BBDD*/metal_HeavyHunter= 6500;
				/*BBDD*/metal_BattleShip= 45000;
				/*BBDD*/metal_ArmoredShip= 30000;
				/*BBDD*/metal_MissileLauncher= 2000;
				/*BBDD*/metal_IonCannon= 4000;
				/*BBDD*/metal_PlasmaCannon= 50000;
				/*BBDD*/deuterium_LightHunter= 50;
				/*BBDD*/deuterium_HeavyHunter= 50;
				/*BBDD*/deuterium_BattleShip= 7000;
				/*BBDD*/deuterium_ArmoredShip= 15000;
				/*BBDD*/deuterium_MissileLauncher= 0;
				/*BBDD*/deuterium_IonCannon= 500;
				/*BBDD*/deuterium_PlasmaCannon= 5000;
				
				/*BBDD*/planet_LightHunters= 11; 
				/*BBDD*/planet_HeavyHunters= 3; 
				/*BBDD*/planet_BattleShips= 1; 
				/*BBDD*/planet_ArmoredShips= 1;
				/*BBDD*/planet_MissileLauncher= 11; 
				/*BBDD*/planet_IonCannon= 1;
				/*BBDD*/planet_PlasmaCannon= 1;
				
				/*BBDD*/enemy_LightHunters= 19; 
				/*BBDD*/enemy_HeavyHunters= 7;
				/*BBDD*/enemy_BattleShips= 1;
				/*BBDD*/enemy_ArmoredShips= 1;
				
				/*BBDD*/planet_LightHunters_F= 3; 
				/*BBDD*/planet_HeavyHunters_F= 2; 
				/*BBDD*/planet_BattleShips_F= 1; 
				/*BBDD*/planet_ArmoredShips_F= 1;
				/*BBDD*/planet_MissileLauncher_F= 2; 
				/*BBDD*/planet_IonCannon_F= 0;
				/*BBDD*/planet_PlasmaCannon_F= 1;
				
				/*BBDD*/enemy_LightHunters_F= 2; 
				/*BBDD*/enemy_HeavyHunters_F= 2;
				/*BBDD*/enemy_BattleShips_F= 0;
				/*BBDD*/enemy_ArmoredShips_F= 1;
				
				cost_Metal_Planet= (
						(metal_LightHunter*  planet_LightHunters) +
						(metal_HeavyHunter * planet_HeavyHunters) +
						(metal_BattleShip * planet_BattleShips) +
						(metal_ArmoredShip * planet_ArmoredShips) +
						(metal_MissileLauncher * planet_MissileLauncher) +
						(metal_IonCannon * planet_IonCannon) +
						(metal_PlasmaCannon * planet_PlasmaCannon)
						); 
				cost_Deuterium_Planet= (
						(deuterium_LightHunter*  planet_LightHunters) +
						(deuterium_HeavyHunter * planet_HeavyHunters) +
						(deuterium_BattleShip * planet_BattleShips) +
						(deuterium_ArmoredShip * planet_ArmoredShips) +
						(deuterium_MissileLauncher * planet_MissileLauncher) +
						(deuterium_IonCannon * planet_IonCannon) +
						(deuterium_PlasmaCannon * planet_PlasmaCannon)
						); 
				cost_Metal_Enemy= (
						(metal_LightHunter*  enemy_LightHunters) +
						(metal_HeavyHunter * enemy_HeavyHunters) +
						(metal_BattleShip * enemy_BattleShips) +
						(metal_ArmoredShip * enemy_ArmoredShips) 
						);
				cost_Deuterium_Enemy= (
						(deuterium_LightHunter*  enemy_LightHunters) +
						(deuterium_HeavyHunter * enemy_HeavyHunters) +
						(deuterium_BattleShip * enemy_BattleShips) +
						(deuterium_ArmoredShip * enemy_ArmoredShips) 
						);
				
				losses_Metal_Planet= (
						(metal_LightHunter*  (planet_LightHunters -planet_LightHunters_F)) +
						(metal_HeavyHunter * (planet_HeavyHunters -planet_HeavyHunters_F)) +
						(metal_BattleShip * (planet_BattleShips -planet_BattleShips_F)) +
						(metal_ArmoredShip * (planet_ArmoredShips -planet_ArmoredShips_F)) +
						(metal_MissileLauncher * (planet_MissileLauncher -planet_MissileLauncher_F)) +
						(metal_IonCannon * (planet_IonCannon -planet_IonCannon_F)) +
						(metal_PlasmaCannon * (planet_PlasmaCannon -planet_PlasmaCannon_F))
						);
				losses_Deuterium_Planet= (
						(deuterium_LightHunter* (planet_LightHunters -planet_LightHunters_F)) +
						(deuterium_HeavyHunter * (planet_HeavyHunters -planet_HeavyHunters_F)) +
						(deuterium_BattleShip * (planet_BattleShips -planet_BattleShips_F)) +
						(deuterium_ArmoredShip * (planet_ArmoredShips -planet_ArmoredShips_F)) +
						(deuterium_MissileLauncher * (planet_MissileLauncher -planet_MissileLauncher_F)) +
						(deuterium_IonCannon * (planet_IonCannon -planet_IonCannon_F)) +
						(deuterium_PlasmaCannon * (planet_PlasmaCannon -planet_PlasmaCannon_F))
						);
				losses_Weighted_Planet= (losses_Metal_Planet + (losses_Deuterium_Planet*5));
				losses_Metal_Enemy= (
						(metal_LightHunter*  (enemy_LightHunters -enemy_LightHunters_F)) +
						(metal_HeavyHunter * (enemy_HeavyHunters - enemy_HeavyHunters_F)) +
						(metal_BattleShip * (enemy_BattleShips - enemy_BattleShips_F)) +
						(metal_ArmoredShip * (enemy_ArmoredShips - enemy_ArmoredShips_F)) 
						);
				losses_Deuterium_Enemy= (
						(deuterium_LightHunter*  (enemy_LightHunters -enemy_LightHunters_F)) +
						(deuterium_HeavyHunter * (enemy_HeavyHunters -enemy_HeavyHunters_F)) +
						(deuterium_BattleShip * (enemy_BattleShips - enemy_BattleShips_F)) +
						(deuterium_ArmoredShip * (enemy_ArmoredShips -enemy_ArmoredShips_F)) 
						);
				losses_Weighted_Enemy= (losses_Metal_Enemy + (losses_Deuterium_Enemy*5));

				/*BBDD*/waste_Metal= 52150; 
				/*BBDD*/waste_Deuterium= 910;
				
				/*BBDD*/winner_Planet= 1;
				/*BBDD*/winner_Enemy= 0;
				
				if(winner_Planet == 1) {
					message_Winner = "Battle Winned by Planet, We Collect Rubble";
				}else if(winner_Enemy ==1){
					message_Winner = "Battle Winned by enemy, He Takes the Planet";
				}else {
					message_Winner = "";
				}
						
				full_Report = "BATTLE NUMBER: "+id_Batalla+
						"\nBATTLE STATISTICS"
						+ "\n" +
						"\nArmy planet"+("         ")+"Units"+("        ")+"Drops"+("        ")+"Initial Army Enemy"+("        ")+"Units"+("         ")+"Drops"+
						"\nLight Hunter"+("        ")+planet_LightHunters+("            ")+(planet_LightHunters - planet_LightHunters_F)+("            ")+"Light Hunter"+("              ")+enemy_LightHunters+("             ")+(enemy_LightHunters - enemy_LightHunters_F)+
						"\nHeavy Hunter"+("        ")+planet_HeavyHunters+("            ")+(planet_HeavyHunters - planet_HeavyHunters_F)+("            ")+"Heavy Hunter"+("              ")+enemy_HeavyHunters+("             ")+(enemy_HeavyHunters - enemy_HeavyHunters_F)+
						"\nBattle Ship"+("         ")+planet_BattleShips+("            ")+(planet_BattleShips - planet_BattleShips_F)+("            ")+"Battle Ship"+("               ")+enemy_BattleShips+("             ")+(enemy_BattleShips - enemy_BattleShips_F)+
						"\nArmored Ship"+("        ")+planet_ArmoredShips+("            ")+(planet_ArmoredShips - planet_ArmoredShips_F)+("            ")+"ArmoredShips"+("              ")+enemy_ArmoredShips+("             ")+(enemy_ArmoredShips - enemy_ArmoredShips_F)+
						"\nMissile Launcher"+("    ")+planet_MissileLauncher+("            ")+(planet_MissileLauncher - planet_MissileLauncher_F)+("             ")+
						"\nIon Cannon"+("          ")+planet_IonCannon+("            ")+(planet_IonCannon - planet_IonCannon)+("            ")+
						"\nPlasma Cannon"+("       ")+planet_PlasmaCannon+("            ")+(planet_PlasmaCannon - planet_PlasmaCannon)+("             ")+
						"\n"+
						"\n**************************************************************************************"+
						"\nCost Army Planet"+("                ")+"Cost Army Enemy"+
						"\nMetal:"+("  ")+cost_Metal_Planet+("                     ")+"Metal:"+("  ")+cost_Metal_Enemy+
						"\nDeuterium:"+("  ")+cost_Deuterium_Planet+("                 ")+"Metal:"+("  ")+cost_Deuterium_Enemy+
						"\n"+
						"\n**************************************************************************************"+
						"\nLosses Army Planet"+("           ")+"Losses Army Enemy"+
						"\nMetal:"+("  ")+losses_Metal_Planet+("                  ")+"Metal:"+("  ")+losses_Metal_Enemy+
						"\nDeuterium:"+("  ")+losses_Deuterium_Planet+("              ")+"Metal:"+("  ")+losses_Deuterium_Enemy+
						"\nWeighted:"+("  ")+losses_Weighted_Planet+("               ")+"Metal:"+("  ")+losses_Weighted_Enemy+
						"\n"+
						"\n**************************************************************************************"+
						"\nWaste Generated:"+
						"\nMetal"+("  ")+waste_Metal+
						"\nDeuterium"+("  ")+waste_Deuterium+
						"\n"+
						"\n"+message_Winner+
						"\n"+
						"\n######################################################################################"+
						"\nView Battle Development?(S/N)"
						;

				
				
				
				
			
			textArea_1.setText(full_Report);
			System.out.println("Battle 1 seleccionado");
		}
		
	}
}
