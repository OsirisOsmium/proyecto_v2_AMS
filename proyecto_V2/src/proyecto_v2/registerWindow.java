package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JTextField txtUsername, txtDate, txtPassword;
	private JButton btnBack, btnSingIn;
	
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="PLANET_WARS_V2";
	private String password="PLANET_WARS_V2";

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
		setBounds(100, 100, 825, 519);
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
		lblUsername.setBounds(299, 64, 109, 35);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(299, 98, 297, 35);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblBirthDate = new JLabel("Birthn Date (DD-MM-YYYY)");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthDate.setBounds(299, 143, 214, 35);
		contentPane.add(lblBirthDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(299, 177, 297, 35);
		contentPane.add(txtDate);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(299, 222, 109, 35);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("");
		txtPassword.setColumns(10);
		txtPassword.setBounds(299, 256, 297, 35);
		contentPane.add(txtPassword);
		
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
			connectionOracle conn=new connectionOracle(url, user, password);

			String username=txtUsername.getText();
			
			String password=txtPassword.getText();

			String date=txtDate.getText();
			
			
			if (conn.SignIn(username, password, date) == true) {
				JOptionPane.showMessageDialog(null, "EXITO: Se ha registrado el usuario  "+username);
				
				logInWindow logIn=new logInWindow();
				this.setVisible(false);
				logIn.setVisible(true);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR: No se ha podido registrar el usuario "+username);
			}			
		}
		
	}

}
