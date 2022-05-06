package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class buildWindow extends JFrame {

	private JPanel contentPane;
	private ImageIcon img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new buildWindow();
	}

	/**
	 * Create the frame.
	 */
	public buildWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 519);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuildTrops = new JButton("Build Trops");
		btnBuildTrops.setBounds(161, 324, 150, 45);
		contentPane.add(btnBuildTrops);
		
		JButton btnBuildDefenses = new JButton("Build Defenses");
		btnBuildDefenses.setBounds(374, 324, 150, 45);
		contentPane.add(btnBuildDefenses);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(257, 394, 150, 45);
		contentPane.add(btnBack);
		
		JLabel lblImgTrops = new JLabel("");
		lblImgTrops.setBounds(161, 47, 150, 242);
		ImageIcon imagen= new ImageIcon("");//destino de donde se ha guardado la imagen
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImgTrops.getWidth(),lblImgTrops.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblImgTrops. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblImgTrops);//añadimos el label
		
		JLabel lblImgDefenses = new JLabel("");
		lblImgDefenses.setBounds(374, 47, 150, 242);
		ImageIcon imagen2= new ImageIcon("");//destino de donde se ha guardado la imagen
		ImageIcon icono2= new ImageIcon(imagen2.getImage().getScaledInstance(lblImgDefenses.getWidth(),lblImgDefenses.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblImgTrops. setIcon(icono2);//establece el ImageIcon en el label
		contentPane.add(lblImgDefenses);//añadimos el label		
		
		setVisible(true);
	}

}
