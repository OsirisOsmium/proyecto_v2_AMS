

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Color;

public class viewWindow extends JFrame implements ActionListener{
	private Planet planet;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private int ides;
	private JPanel contentPane;
	private JButton btnBack, btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain;
	public JLabel lblNewLabel, lblNewLabel_2, lblNumMetal, lblNumDeuterium, lblLvlAtack, lblLvlDefense, lblnumMissile, lblNumIon, lblNumPlasma, lblNumLight, lblNumHeavy, lblNumBattle, lblNumArmored;
	
	private String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
	private String user="alumnoAMS17";
	private String password="alumnoAMS17";
	

	
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		/*Planet planet=new Planet();
		new viewWindow(planet);*/
		/*
		String url="jdbc:oracle:thin:@192.168.40.2:1521:xe";
		String user="alumnoAMS17";
		String password="alumnoAMS17";
		connectionOracle conn=new connectionOracle(url, user, password);
		conn.viewStats(1);
		
	}
	*/
	/**
	 * Create the frame.
	 */
	public viewWindow(Planet planet,ArrayList<MilitaryUnit>[] enemyArmy,int ides) {
		this.planet=planet;
		this.enemyArmy=enemyArmy;
		this.ides=ides;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		////////////////////////////
		
		btnViewPlanetStat = new JButton("View Stats");
		btnViewPlanetStat.addActionListener(this);
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
		ImageIcon imagen= new ImageIcon("vertical_lado.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama�o del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);//a�adimos el label
		
		////////////////////////////
		
		
		
		JLabel lblTitle = new JLabel("VIEW PLANET STATS");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(210, 46, 500, 45);
		lblTitle.setBorder(null);
		contentPane.add(lblTitle);
		
		JLabel lblMetal = new JLabel("Metal");
		lblMetal.setForeground(Color.WHITE);
		lblMetal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMetal.setBounds(140, 358, 80, 20);
		contentPane.add(lblMetal);
		
		JLabel lblDeuterium = new JLabel("Deuterium");
		lblDeuterium.setForeground(Color.WHITE);
		lblDeuterium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeuterium.setBounds(140, 398, 80, 20);
		contentPane.add(lblDeuterium);
		
		JLabel lblTechnology = new JLabel("TECHNOLOGY LEVEL");
		lblTechnology.setForeground(Color.WHITE);
		lblTechnology.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTechnology.setBounds(342, 310, 120, 20);
		contentPane.add(lblTechnology);
		
		JLabel lblDefenses = new JLabel("DEFENSES");
		lblDefenses.setForeground(Color.WHITE);
		lblDefenses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDefenses.setBounds(341, 135, 80, 20);
		contentPane.add(lblDefenses);
		
		JLabel lblMisileLaun = new JLabel("Missili Launcher: ");
		lblMisileLaun.setForeground(Color.WHITE);
		lblMisileLaun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMisileLaun.setBounds(341, 180, 101, 20);
		contentPane.add(lblMisileLaun);
		
		JLabel lblIonCannon = new JLabel("Ion Cannon: ");
		lblIonCannon.setForeground(Color.WHITE);
		lblIonCannon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIonCannon.setBounds(341, 215, 80, 20);
		contentPane.add(lblIonCannon);
		
		JLabel lblPlasmaCannon = new JLabel("Plasma Cannon: ");
		lblPlasmaCannon.setForeground(Color.WHITE);
		lblPlasmaCannon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlasmaCannon.setBounds(341, 256, 108, 20);
		contentPane.add(lblPlasmaCannon);
		
		JLabel lblAttackTech = new JLabel("Attack Technology:");
		lblAttackTech.setForeground(Color.WHITE);
		lblAttackTech.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttackTech.setBounds(342, 359, 109, 20);
		contentPane.add(lblAttackTech);
		
		JLabel lblDefenseTech = new JLabel("Defense Technology: ");
		lblDefenseTech.setForeground(Color.WHITE);
		lblDefenseTech.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDefenseTech.setBounds(342, 398, 120, 20);
		contentPane.add(lblDefenseTech);
		
		JLabel lblFleet = new JLabel("FLEET");
		lblFleet.setForeground(Color.WHITE);
		lblFleet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFleet.setBounds(512, 135, 80, 20);
		contentPane.add(lblFleet);
		
		JLabel lblLigthHuntter = new JLabel("Ligth Huntter: ");
		lblLigthHuntter.setForeground(Color.WHITE);
		lblLigthHuntter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLigthHuntter.setBounds(512, 180, 80, 20);
		contentPane.add(lblLigthHuntter);
		
		JLabel lblHeavyhunter = new JLabel("HeavyHunter: ");
		lblHeavyhunter.setForeground(Color.WHITE);
		lblHeavyhunter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHeavyhunter.setBounds(512, 215, 80, 20);
		contentPane.add(lblHeavyhunter);
		
		JLabel lblArmoredShip = new JLabel("Battle Ship: ");
		lblArmoredShip.setForeground(Color.WHITE);
		lblArmoredShip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArmoredShip.setBounds(512, 256, 80, 20);
		contentPane.add(lblArmoredShip);
		
		
		///////////////////////////////////
			
		///////////////////////////////////
//////////////////////////////////
//DATOS
		lblNumMetal = new JLabel(String.valueOf(this.planet.getMetal()));
		lblNumMetal.setForeground(Color.WHITE);
		lblNumMetal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumMetal.setBounds(252, 362, 80, 20);
		//lblNumMetal.setText("Q_metal");
		contentPane.add(lblNumMetal);
		
		lblNumDeuterium = new JLabel(String.valueOf(this.planet.getDeuterium()));
		lblNumDeuterium.setForeground(Color.WHITE);
		lblNumDeuterium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumDeuterium.setBounds(252, 402, 80, 20);
		//lblNumDeuterium.setText(Q_Deuterium);
		contentPane.add(lblNumDeuterium);
		
		
		lblLvlAtack = new JLabel(String.valueOf(this.planet.getTechnologyAtack()));
		lblLvlAtack.setForeground(Color.WHITE);
		lblLvlAtack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLvlAtack.setBounds(461, 359, 47, 20);
		contentPane.add(lblLvlAtack);
		
		lblLvlDefense = new JLabel(String.valueOf(this.planet.getTechnologyDefense()));
		lblLvlDefense.setForeground(Color.WHITE);
		lblLvlDefense.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLvlDefense.setBounds(466, 398, 47, 20);
		contentPane.add(lblLvlDefense);
		
		lblnumMissile = new JLabel(String.valueOf(this.planet.getArmy()[4].size()));
		lblnumMissile.setForeground(Color.WHITE);
		lblnumMissile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnumMissile.setBounds(452, 180, 47, 20);
		contentPane.add(lblnumMissile);
		
		lblNumIon = new JLabel(String.valueOf(this.planet.getArmy()[5].size()));
		lblNumIon.setForeground(Color.WHITE);
		lblNumIon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumIon.setBounds(452, 219, 47, 20);
		contentPane.add(lblNumIon);
		
		lblNumPlasma = new JLabel(String.valueOf(this.planet.getArmy()[6].size()));
		lblNumPlasma.setForeground(Color.WHITE);
		lblNumPlasma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPlasma.setBounds(452, 260, 47, 20);
		contentPane.add(lblNumPlasma);
		
		lblNumHeavy = new JLabel(String.valueOf(this.planet.getArmy()[1].size()));
		lblNumHeavy.setForeground(Color.WHITE);
		lblNumHeavy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumHeavy.setBounds(623, 219, 47, 20);
		contentPane.add(lblNumHeavy);
		
		lblNumLight = new JLabel(String.valueOf(this.planet.getArmy()[0].size()));
		lblNumLight.setForeground(Color.WHITE);
		lblNumLight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumLight.setBounds(623, 180, 47, 20);
		contentPane.add(lblNumLight);
		
		lblNumBattle = new JLabel(String.valueOf(this.planet.getArmy()[2].size()));
		lblNumBattle.setForeground(Color.WHITE);
		lblNumBattle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumBattle.setBounds(623, 260, 47, 20);
		contentPane.add(lblNumBattle);
		
		lblNumArmored = new JLabel(String.valueOf(this.planet.getArmy()[3].size()));
		lblNumArmored.setForeground(Color.WHITE);
		lblNumArmored.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumArmored.setBounds(623, 298, 47, 20);
		contentPane.add(lblNumArmored);
//////////////////////////////////
		JLabel lblArmoredShip_1 = new JLabel("Armored Ship: ");
		lblArmoredShip_1.setForeground(Color.WHITE);
		lblArmoredShip_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArmoredShip_1.setBounds(512, 294, 80, 20);
		contentPane.add(lblArmoredShip_1);
		
		
		JLabel lblPlaneta = new JLabel("");
		lblPlaneta.setIcon(new ImageIcon("YavinIV.png"));
		lblPlaneta.setBounds(132, 141, 173, 148);
		ImageIcon imagen3= new ImageIcon("YavinIV.png");
		ImageIcon icono3= new ImageIcon(imagen3.getImage().getScaledInstance(lblPlaneta.getWidth(),lblPlaneta.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama�o del label
		lblPlaneta. setIcon(icono3);//establece el ImageIcon en el label
		contentPane.add(lblPlaneta);//a�adimos el label
		
		
		JLabel lbBackGround = new JLabel("");
		lbBackGround.setBackground(SystemColor.activeCaption);
		lbBackGround.setBounds(0, 0, 809, 482);
		lbBackGround.setOpaque(true);
		ImageIcon imagen4= new ImageIcon("espacio_fondo.jpeg");
		ImageIcon icono4= new ImageIcon(imagen4.getImage().getScaledInstance(lbBackGround.getWidth(),lbBackGround.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama�o del label
		lbBackGround. setIcon(icono4);//establece el ImageIcon en el label
		contentPane.add(lbBackGround);//a�adimos el label
		
		
		setVisible(true);
	}
	
	
	
	/*
	public static void update() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="PLANET_WARS_V2";
		String password="PLANET_WARS_V2";
		connectionOracle conn=new connectionOracle(url, user, password);
		conn.viewStats();
	}
	*/
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		connectionOracle conn=new connectionOracle(url, user, password);

		if (btnViewPlanetStat==e.getSource()){
			viewWindow view=new viewWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			//conn.viewStats(1);
			//view.setVisible(true);
		}
		
		if (btnUpgrade==e.getSource()){
			upgradeWindow upgrade=new upgradeWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			//conn.viewUpgrade(1);
			//upgrade.setVisible(true);
		}
		
		if (btnBuild==e.getSource()){
			buildWindow view=new buildWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			view.setVisible(true);
		}
		
		if (btnReports==e.getSource()){
			reportsWindow report=new reportsWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			report.setVisible(true);
		}
		
		if (btnThreadComing==e.getSource()){
			comingWindow coming=new comingWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			coming.setVisible(true);
		}
		if (btnLogOut==e.getSource()) {
			logInWindow logIn=new logInWindow(planet,enemyArmy);
			this.setVisible(false);
			logIn.setVisible(true);
		}
		if (btnMain==e.getSource()) {
			mainWindow main=new mainWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			main.setVisible(true);
		}
		
	}
}
