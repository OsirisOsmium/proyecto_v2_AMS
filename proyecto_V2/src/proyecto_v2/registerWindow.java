package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsername, txtDate, txtPassword, txtRPassword;
	private JButton btnBack, btnSingIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new registerWindow();
	}

	/**
	 * Create the frame.
	 */
	public registerWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 519);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 196, 482);
		ImageIcon imagen= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\vertical_space.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblImage. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblImage);//añadimos el label
		contentPane.add(lblImage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(301, 26, 109, 35);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(301, 60, 297, 35);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblBirthDate = new JLabel("Birthn Date");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthDate.setBounds(301, 105, 109, 35);
		contentPane.add(lblBirthDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(301, 139, 297, 35);
		contentPane.add(txtDate);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(301, 184, 109, 35);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(301, 218, 297, 35);
		contentPane.add(txtPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRepeatPassword.setBounds(301, 263, 134, 35);
		contentPane.add(lblRepeatPassword);
		
		txtRPassword = new JTextField();
		txtRPassword.setColumns(10);
		txtRPassword.setBounds(301, 297, 297, 35);
		contentPane.add(txtRPassword);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(301, 382, 115, 35);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);
		
		btnSingIn = new JButton("Sing In");
		btnSingIn.setBounds(481, 382, 115, 35);
		btnSingIn.addActionListener(this);
		contentPane.add(btnSingIn);
		
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBack==e.getSource()) {
			logInWindow logIn=new logInWindow();
			this.setVisible(false);
			logIn.setVisible(true);
		}
		if (btnSingIn==e.getSource()) {
			logInWindow logIn=new logInWindow();
			this.setVisible(false);
			logIn.setVisible(true);
		}
		
	}

}
