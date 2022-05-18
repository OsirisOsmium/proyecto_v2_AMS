

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class mainWindow extends JFrame implements ActionListener{
	private Planet planet;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private int ides;
	private JPanel contentPane;
	private JButton btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing, btnLogOut, btnMain;
	private JLabel lblTitle;
	private ImageIcon img;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnLogOut2;
	
	private String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
	private String user="alumnoAMS17";
	private String password="alumnoAMS17";

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		new mainWindow(new Planet());
	}

	/**
	 * Create the frame.
	 */
	public mainWindow(Planet planet,ArrayList<MilitaryUnit>[] enemyArmy,int ides) {
		this.planet=planet;
		this.enemyArmy=enemyArmy;
		this.ides=ides;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
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
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogOut.addActionListener(this);
		btnLogOut.setBounds(10, 406, 92, 33);
		contentPane.add(btnLogOut);
		
		btnMain = new JButton("Main");
		btnMain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMain.setBounds(10, 256, 92, 33);
		btnMain.addActionListener(this);
		contentPane.add(btnMain);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 110, 482);
		ImageIcon imagen= new ImageIcon("vertical_lado.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama�o del label
		lblNewLabel_2. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel_2);//a�adimos el label
		
		////////////////////////////
		
		lblTitle = new JLabel("PLANET WARS");
		lblTitle.setEnabled(false);
		lblTitle.setBorder(null);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(170, 46, 403, 79);
		contentPane.add(lblTitle);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(110, 0, 699, 482);
		contentPane.add(lblBackground);
		ImageIcon imagen2= new ImageIcon("war_star.png");
		ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblBackground.getWidth(),lblBackground.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama�o del label
		lblBackground. setIcon(icono2);//establece el ImageIcon en el label
		contentPane.add(lblBackground);//a�adimos el label		
		connectionOracle conn=new connectionOracle(url, user, password);
		System.out.println("LIGHTHUNTERS EN MAIN "+this.planet.getArmy()[0].size());
		conn.actualizarPlaneta(this.planet);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		connectionOracle conn=new connectionOracle(url, user, password);

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