

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class buildWindow extends JFrame implements ActionListener, ItemListener{
	private Planet planet;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private int ides;
	private JPanel contentPane;
	private ImageIcon img;
	private JButton btnBack;
	private JLabel lblImage, lblNewLabel_2;
	private JTextField txtNumAnadir;
	private JButton  btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain, btnBuildDefenses, btnBuildTrops, btnAdd;
	private JComboBox comboBox;
	
	private String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
	private String user="alumnoAMS17";
	private String password="alumnoAMS17";
	private JTextArea txtDescription;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		new buildWindow(new Planet());
	}

	/**
	 * Create the frame.
	 */
	public buildWindow(Planet planet,ArrayList<MilitaryUnit>[] enemyArmy,int ides) {
		this.planet=planet;
		this.enemyArmy=enemyArmy;
		this.ides=ides;
		connectionOracle conn=new connectionOracle(url, user, password);
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
		ImageIcon imagen= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\vertical_lado.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);//anadimos el label
		
		////////////////////////////
		
		
		lblImage = new JLabel("");
		lblImage.setBounds(139, 29, 282, 174);
		contentPane.add(lblImage);
		
		btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(198, 361, 150, 35);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		comboBox = new JComboBox();
		comboBox.setBounds(163, 267, 150, 35);
		contentPane.add(comboBox);
		
		
		JLabel lblUnit = new JLabel("Unidades a a\u00F1adir: ");
		lblUnit.setForeground(Color.WHITE);
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnit.setBounds(163, 313, 150, 35);
		contentPane.add(lblUnit);
		
		txtNumAnadir = new JTextField();
		txtNumAnadir.setBounds(312, 315, 100, 35);
		contentPane.add(txtNumAnadir);
		txtNumAnadir.setColumns(10);
		
		btnBuildTrops = new JButton("Build Trops");
		btnBuildTrops.setBounds(163, 233, 110, 23);
		btnBuildTrops.addActionListener(this);
		contentPane.add(btnBuildTrops);
		
		btnBuildDefenses = new JButton("Build Defenses");
		btnBuildDefenses.setBounds(290, 233, 110, 23);
		btnBuildDefenses.addActionListener(this);
		contentPane.add(btnBuildDefenses);
		
		txtDescription = new JTextArea("");
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDescription.setBounds(468, 29, 282, 174);
		txtDescription.setColumns(10);
		txtDescription.setRows(5);
		contentPane.add(txtDescription);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 809, 482);
		ImageIcon imagen4= new ImageIcon("espacio_fondo.jpeg");
		ImageIcon icono4= new ImageIcon(imagen4.getImage().getScaledInstance(lblBackground.getWidth(),lblBackground.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
		lblBackground. setIcon(icono4);//establece el ImageIcon en el label
		contentPane.add(lblBackground);//anadimos el label
		
		
		//setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		connectionOracle conn=new connectionOracle(url, user, password);
		if (btnBuildTrops==e.getSource()) {
			String Ship[]= {"" ,"Light Hunter", "Heavy Hunter", "Battle Ship" ,"Armored Ship"};
			DefaultComboBoxModel comboTrops = new DefaultComboBoxModel(Ship);
			comboBox.setModel(comboTrops);
			comboBox.addItemListener(this);

		}
		if(btnBuildDefenses==e.getSource()) {			
			String Defense[]= {"" ,"Missile Launcher", "Ion Cannon", "Plasma Cannon"};
			DefaultComboBoxModel comboDefense = new DefaultComboBoxModel(Defense);
			comboBox.setModel(comboDefense);
			comboBox.addItemListener(this);

		}
		
//////////////////////////
		
//en cada se ha de anadir una accion para que modifique las interfaces
		
		
		if (btnAdd==e.getSource()) {
			String Trops=(String) comboBox.getSelectedItem();
			if (Trops.equalsIgnoreCase("Light Hunter")) {
				System.out.println("Accion de add del TROPS con Light Hunter");
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newLigthHunter(cant);
				System.out.println("LIGHTHUNTERS: "+planet.getArmy()[0].size());
				//conn.addTrops("Light Hunter", cant, 0, 0);
				
			}
			if (Trops.equalsIgnoreCase("Heavy Hunter")) {
				System.out.println("Accion de add del TROPS con Heavy Hunter");
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newHeavyHunter(cant);
				//conn.addTrops("Heavy Hunter", cant, 0, 0);
			}
			if (Trops.equalsIgnoreCase("Battle Ship")) {
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newBattleShip(cant);
				//conn.addTrops("Battle Ship", cant, 0, 0);
			}
			if (Trops.equalsIgnoreCase("Armored Ship")) {
				System.out.println("Accion de add del TROPS con Armored Ship");
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newArmoredShip(cant);
				//conn.addTrops("Armored Ship", cant, 0, 0);
			}
			
			
			if (Trops.equalsIgnoreCase("Missile Launcher")) {
				System.out.println("Accion de add del DEFENSE con Missile Launcher");
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newMissileLauncher(cant);
				//conn.addTrops("Missile Launcher", cant, 0, 0);
			}
			if (Trops.equalsIgnoreCase("Ion Cannon")) {
				System.out.println("Accion de add del DEFENSE con Ion Cannon");
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newHeavyHunter(cant);
				//conn.addTrops("Ion Cannon", cant, 0, 0);
			}
			if (Trops.equalsIgnoreCase("PLasma Cannon")) {
				System.out.println("Accion de add del DEFENSE con PLasma Cannon");
				int cant=0;
				try {
					cant=Integer.parseInt(txtNumAnadir.getText());
				}
				catch(Exception ex){
					System.out.println("Se ha de introducir un numero");
				}
				planet.newPlasmaCannon(cant);
				//conn.addTrops("Plasma Cannon", cant, 0, 0);
			}
		}
//////////////////////////
		
		

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

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		String Trops=(String) comboBox.getSelectedItem(); //si el combo box seleccionado (item 1, 2, 3, 4, ...) ==x num haz eso
		
		if (Trops.equalsIgnoreCase("Light Hunter")) {
			ImageIcon imagen2= new ImageIcon("cazaLigero.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			
			txtDescription.setText(conn.get_ship(1));
			System.out.println("Light Hunter");
		}
		if (Trops.equalsIgnoreCase("Heavy Hunter")) {
			ImageIcon imagen2= new ImageIcon("cazaPesado.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			txtDescription.setText(conn.get_ship(2));
			
			System.out.println("Heavy Hunter");
		}
		if (Trops.equalsIgnoreCase("Battle Ship")) {
			ImageIcon imagen2= new ImageIcon("battleShip.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			txtDescription.setText(conn.get_ship(3));
			
			System.out.println("Battle Ship");
		}
		if (Trops.equalsIgnoreCase("Armored Ship")) {
			ImageIcon imagen2= new ImageIcon("acorazado.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			txtDescription.setText(conn.get_ship(4));
			
			System.out.println("Armored Ship");
		}
		
		if (Trops.equalsIgnoreCase("Missile Launcher")) {
			ImageIcon imagen2= new ImageIcon("misil.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			txtDescription.setText(conn.get_defense(1));
		}
		if (Trops.equalsIgnoreCase("Ion Cannon")) {
			ImageIcon imagen2= new ImageIcon("canonIon.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			txtDescription.setText(conn.get_defense(2));
		}
		if (Trops.equalsIgnoreCase("PLasma Cannon")) {
			ImageIcon imagen2= new ImageIcon("plasmaCannon.jpg");
			ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamano del label
			lblImage. setIcon(icono2);//establece el ImageIcon en el label
			
			connectionOracle conn=new connectionOracle(url, user, password);
			txtDescription.setText(conn.get_defense(3));
		}
		
	}
}