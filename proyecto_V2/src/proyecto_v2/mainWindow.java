package proyecto_v2;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class mainWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnBuild, btnViewPlanetStat, btnUpgrade, btnReports, btnThreadComing;
	private JLabel lblTitle, lblNewLabel;
	private ImageIcon img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new mainWindow();
	}

	/**
	 * Create the frame.
	 */
	public mainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		btnViewPlanetStat = new JButton("View Stats");
		btnViewPlanetStat.addActionListener(this);
		btnViewPlanetStat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewPlanetStat.setBounds(170, 234, 140, 45);
		contentPane.add(btnViewPlanetStat);
		
		btnBuild = new JButton("Build");
		btnBuild.addActionListener(this);
		btnBuild.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuild.setBounds(318, 294, 140, 45);
		contentPane.add(btnBuild);
		
		btnUpgrade = new JButton("Upgrade");
		btnUpgrade.addActionListener(this);
		btnUpgrade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpgrade.setBounds(170, 343, 140, 45);
		contentPane.add(btnUpgrade);
		
		btnReports = new JButton("Reports");
		btnReports.addActionListener(this);
		btnReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReports.setBounds(452, 234, 140, 45);
		contentPane.add(btnReports);
		
		btnThreadComing = new JButton("Coming");
		btnThreadComing.addActionListener(this);
		btnThreadComing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThreadComing.setBounds(452, 343, 140, 45);
		contentPane.add(btnThreadComing);
		
		lblTitle = new JLabel("PLANET WARS");
		lblTitle.setEnabled(false);
		lblTitle.setBorder(null);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(170, 46, 403, 79);
		contentPane.add(lblTitle);
		
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(583, 0, 110, 482);
		ImageIcon imagen= new ImageIcon("\\resource\\fondo.jpg");//destino de donde se ha guardado la imagen
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblNewLabel. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblNewLabel);//añadimos el label
		
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
		
	}
}
