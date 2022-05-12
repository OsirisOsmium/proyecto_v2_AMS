package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class comingWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnBack;
	private JButton  btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain;
	private JLabel lblNewLabel_2;
	
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="PLANET_WARS_V2";
	private String password="PLANET_WARS_V2";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new comingWindow();
	}

	/**
	 * Create the frame.
	 */
	public comingWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 519);
		contentPane = new JPanel();
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
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);//añadimos el label
		contentPane.add(lblNewLabel_2);
		
		////////////////////////////
		
		
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.addActionListener(this);
		btnBack.setBounds(319, 404, 115, 35);
		contentPane.add(btnBack);
		
		JLabel lblTitle = new JLabel("NEW THREAD COMMING");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(153, 14, 612, 66);
		contentPane.add(lblTitle);
		
		JLabel lblShip_1 = new JLabel("Ligth Hunter");
		lblShip_1.setForeground(Color.WHITE);
		lblShip_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1.setBounds(270, 127, 101, 35);
		contentPane.add(lblShip_1);
		
		JLabel lblShip_1_1 = new JLabel("x");
		lblShip_1_1.setForeground(Color.WHITE);
		lblShip_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_1.setBounds(450, 127, 175, 35);
		contentPane.add(lblShip_1_1);
		
		JLabel lblShip_1_2 = new JLabel("Heavy Hunter");
		lblShip_1_2.setForeground(Color.WHITE);
		lblShip_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_2.setBounds(270, 172, 101, 35);
		contentPane.add(lblShip_1_2);
		
		JLabel lblShip_1_1_1 = new JLabel("xx");
		lblShip_1_1_1.setForeground(Color.WHITE);
		lblShip_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_1_1.setBounds(450, 172, 175, 35);
		contentPane.add(lblShip_1_1_1);
		
		JLabel lblShip_1_3 = new JLabel("Battle Ship");
		lblShip_1_3.setForeground(Color.WHITE);
		lblShip_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_3.setBounds(270, 222, 101, 35);
		contentPane.add(lblShip_1_3);
		
		JLabel lblShip_1_1_2 = new JLabel("xxx");
		lblShip_1_1_2.setForeground(Color.WHITE);
		lblShip_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_1_2.setBounds(450, 222, 175, 35);
		contentPane.add(lblShip_1_1_2);
		
		JLabel lblShip_1_4 = new JLabel("Armored Ship");
		lblShip_1_4.setForeground(Color.WHITE);
		lblShip_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_4.setBounds(270, 267, 101, 35);
		contentPane.add(lblShip_1_4);
		
		JLabel lblShip_1_1_3 = new JLabel("xxxx");
		lblShip_1_1_3.setForeground(Color.WHITE);
		lblShip_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShip_1_1_3.setBounds(450, 267, 175, 35);
		contentPane.add(lblShip_1_1_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 809, 482);
		ImageIcon imagen4= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\espacio_fondo.jpeg");
		ImageIcon icono4= new ImageIcon(imagen4.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblNewLabel. setIcon(icono4);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel);//añadimos el label
		
		
		setVisible(true);
	}

	@Override
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
