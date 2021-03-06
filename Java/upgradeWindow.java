

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class upgradeWindow extends JFrame implements ActionListener{
	private Planet planet;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private int ides;
	private JPanel contentPane;
	private JButton btnUpDef, btnUpAtack, btnBack;
	private JButton  btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain;
	public JLabel lblNewLabel_2, lblBackground, lblCostDefense, lblCostAttack, lblActualDefense, lblActualAttack;
	
	private String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
	private String user="alumnoAMS17";
	private String password="alumnoAMS17";
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		Planet planet=new Planet();
		new upgradeWindow(planet);
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="PLANET_WARS_V2";
		String password="PLANET_WARS_V2";
		connectionOracle conn=new connectionOracle(url, user, password);
		//conn.viewUpgrade(1);
		
		
	}

	/**
	 * Create the frame.
	 */
	public upgradeWindow(Planet planet,ArrayList<MilitaryUnit>[] enemyArmy,int ides) {
		this.planet=planet;
		this.enemyArmy=enemyArmy;
		this.ides=ides;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 519);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama???o del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);//a???adimos el label
		
		////////////////////////////
		
		
		
		JLabel lblNewLabel = new JLabel("UPGRADE TECHNOLOGY");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(185, 46, 550, 61);
		contentPane.add(lblNewLabel);
		
		btnUpDef = new JButton(" UPDATE DEFENSE");
		btnUpDef.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpDef.addActionListener(this);
		btnUpDef.setBounds(493, 181, 168, 45);
		contentPane.add(btnUpDef);
		
		btnUpAtack = new JButton("UPDATE ATTACK");
		btnUpAtack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpAtack.addActionListener(this);
		btnUpAtack.setBounds(493, 236, 168, 45);
		contentPane.add(btnUpAtack);
		
		JLabel lblNewLabel_1 = new JLabel("Update Defense Technology.      Cost: ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(138, 183, 261, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Update Attack Technology.      Cost: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(138, 236, 261, 45);
		contentPane.add(lblNewLabel_2);
		
		lblCostDefense = new JLabel(String.valueOf(planet.getUpgradeDefenseTechnologyDeuteriumCost()));
		lblCostDefense.setForeground(Color.WHITE);
		lblCostDefense.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostDefense.setBounds(434, 183, 80, 45);
		contentPane.add(lblCostDefense);
		
		lblCostAttack = new JLabel(String.valueOf(planet.getUpgradeAttackTechnologyDeuteriumCost()));
		lblCostAttack.setForeground(Color.WHITE);
		lblCostAttack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostAttack.setBounds(434, 236, 80, 45);
		contentPane.add(lblCostAttack);
		
		JLabel lblNewLabel_1_1 = new JLabel("Actual Defense Technology");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(144, 322, 197, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Actual Attack Technology");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(144, 375, 197, 45);
		contentPane.add(lblNewLabel_2_1);
		
		lblActualDefense = new JLabel(String.valueOf(planet.getTechnologyDefense()));
		lblActualDefense.setForeground(Color.WHITE);
		lblActualDefense.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActualDefense.setBounds(351, 322, 80, 45);
		contentPane.add(lblActualDefense);
		
		lblActualAttack = new JLabel(String.valueOf(planet.getTechnologyAtack()));
		lblActualAttack.setForeground(Color.WHITE);
		lblActualAttack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActualAttack.setBounds(351, 375, 80, 45);
		contentPane.add(lblActualAttack);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 811, 480);
		ImageIcon imagen4= new ImageIcon("espacio_fondo.jpeg");
		ImageIcon icono4= new ImageIcon(imagen4.getImage().getScaledInstance(lblBackground.getWidth(),lblBackground.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama???o del label
		lblBackground. setIcon(icono4);//establece el ImageIcon en el label
		contentPane.add(lblBackground);//a???adimos el label
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		connectionOracle conn=new connectionOracle(url, user, password);
		if (btnUpDef==e.getSource()) {
			//connectionOracle conn=new connectionOracle(url, user, password);
			planet.upgradeTechnologyDefense();
		}
		if (btnUpAtack==e.getSource()) {
			//connectionOracle conn=new connectionOracle(url, user, password);
			planet.upgradeTechnologyAttack();
		}
		if (btnViewPlanetStat==e.getSource()){
			viewWindow view=new viewWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			//conn.viewStats(1);
			view.setVisible(true);
		}
		
		if (btnUpgrade==e.getSource()){
			upgradeWindow upgrade=new upgradeWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			//conn.viewUpgrade(1);
			upgrade.setVisible(true);
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