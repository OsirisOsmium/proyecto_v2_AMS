package proyecto_v2;

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

import javax.swing.JLabel;

public class viewWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnBack, btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new viewWindow();
	}

	/**
	 * Create the frame.
	 */
	public viewWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 519);
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
		ImageIcon imagen= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\vertical_lado.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);//añadimos el label
		
		////////////////////////////
		
		
		/*
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(65, 404, 115, 45);
		contentPane.add(btnBack);
		*/
		JLabel lblTitle = new JLabel("VIEW PLANET STATS");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(140, 50, 500, 45);
		lblTitle.setBorder(null);
		contentPane.add(lblTitle);
		
		JLabel lblMetal = new JLabel("Metal");
		lblMetal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMetal.setBounds(231, 392, 80, 20);
		contentPane.add(lblMetal);
		
		JLabel lblDeuterium = new JLabel("Deuterium");
		lblDeuterium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeuterium.setBounds(231, 432, 80, 20);
		contentPane.add(lblDeuterium);
		
		JLabel lblNewLabel_1_1 = new JLabel("x");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(343, 396, 80, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("xx");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(343, 436, 80, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblTechnology = new JLabel("TECHNOLOGY");
		lblTechnology.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTechnology.setBounds(140, 151, 80, 20);
		contentPane.add(lblTechnology);
		
		JLabel lblDefenses = new JLabel("DEFENSES");
		lblDefenses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDefenses.setBounds(315, 151, 80, 20);
		contentPane.add(lblDefenses);
		
		JLabel lblMisileLaun = new JLabel("Missili Launcher: ");
		lblMisileLaun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMisileLaun.setBounds(315, 196, 101, 20);
		contentPane.add(lblMisileLaun);
		
		JLabel lblIonCannon = new JLabel("Ion Cannon: ");
		lblIonCannon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIonCannon.setBounds(315, 231, 80, 20);
		contentPane.add(lblIonCannon);
		
		JLabel lblPlasmaCannon = new JLabel("Plasma Cannon: ");
		lblPlasmaCannon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlasmaCannon.setBounds(315, 272, 108, 20);
		contentPane.add(lblPlasmaCannon);
		
		JLabel lblAttackTech = new JLabel("Attack Technology:");
		lblAttackTech.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttackTech.setBounds(140, 200, 109, 20);
		contentPane.add(lblAttackTech);
		
		JLabel lblDefenseTech = new JLabel("Defense Technology: ");
		lblDefenseTech.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDefenseTech.setBounds(140, 239, 120, 20);
		contentPane.add(lblDefenseTech);
		
		JLabel lblAttack = new JLabel("x");
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttack.setBounds(259, 200, 47, 20);
		contentPane.add(lblAttack);
		
		JLabel lblDefense = new JLabel("xx");
		lblDefense.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDefense.setBounds(264, 239, 47, 20);
		contentPane.add(lblDefense);
		
		JLabel lblMisile = new JLabel("x");
		lblMisile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMisile.setBounds(426, 196, 47, 20);
		contentPane.add(lblMisile);
		
		JLabel lblIon = new JLabel("xx");
		lblIon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIon.setBounds(426, 235, 47, 20);
		contentPane.add(lblIon);
		
		JLabel lblPlasma = new JLabel("xxx");
		lblPlasma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlasma.setBounds(426, 276, 47, 20);
		contentPane.add(lblPlasma);
		
		JLabel lblFleet = new JLabel("FLEET");
		lblFleet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFleet.setBounds(486, 151, 80, 20);
		contentPane.add(lblFleet);
		
		JLabel lblLigthHuntter = new JLabel("Ligth Huntter: ");
		lblLigthHuntter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLigthHuntter.setBounds(486, 196, 80, 20);
		contentPane.add(lblLigthHuntter);
		
		JLabel lblHeavyhunter = new JLabel("HeavyHunter: ");
		lblHeavyhunter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHeavyhunter.setBounds(486, 231, 80, 20);
		contentPane.add(lblHeavyhunter);
		
		JLabel lblArmoredShip = new JLabel("Battle Ship: ");
		lblArmoredShip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArmoredShip.setBounds(486, 272, 80, 20);
		contentPane.add(lblArmoredShip);
		
		JLabel lblIon_1 = new JLabel("xx");
		lblIon_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIon_1.setBounds(597, 235, 47, 20);
		contentPane.add(lblIon_1);
		
		JLabel lblMisile_1 = new JLabel("x");
		lblMisile_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMisile_1.setBounds(597, 196, 47, 20);
		contentPane.add(lblMisile_1);
		
		JLabel lblPlasma_1 = new JLabel("xxx");
		lblPlasma_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlasma_1.setBounds(597, 276, 47, 20);
		contentPane.add(lblPlasma_1);
		
		JLabel lblArmoredShip_1 = new JLabel("Armored Ship: ");
		lblArmoredShip_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArmoredShip_1.setBounds(486, 310, 80, 20);
		contentPane.add(lblArmoredShip_1);
		
		JLabel lblPlasma_1_1 = new JLabel("xxxx");
		lblPlasma_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlasma_1_1.setBounds(597, 314, 47, 20);
		contentPane.add(lblPlasma_1_1);
		
		JLabel lbBackGround = new JLabel("");
		lbBackGround.setBackground(SystemColor.activeCaption);
		lbBackGround.setBounds(0, 0, 706, 482);
		lbBackGround.setOpaque(true);
		contentPane.add(lbBackGround);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnViewPlanetStat==e.getSource()){
			viewWindow view=new viewWindow();
			this.setVisible(false);
			view.setVisible(true);
		}
		
		if (btnUpgrade==e.getSource()){
			upgradeWindow upgrade=new upgradeWindow();
			this.setVisible(false);
			upgrade.setVisible(true);
		}
		
		if (btnBuild==e.getSource()){
			buildWindow view=new buildWindow();
			this.setVisible(false);
			view.setVisible(true);
		}
		
		if (btnReports==e.getSource()){
			reportsWindow report=new reportsWindow();
			this.setVisible(false);
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

}
