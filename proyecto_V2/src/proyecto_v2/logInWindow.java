package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class logInWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsername, txtPassword;
	private JButton btnLogIn, btnSingIn;
	
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="PLANET_WARS_V2";
	private String password="PLANET_WARS_V2";
	
	Connection conn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new logInWindow();
	}

	/**
	 * Create the frame.
	 */
	public logInWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 519);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 208, 482);
		ImageIcon imagen= new ImageIcon("C:\\Users\\fraci\\Documents\\Ciclo Formativo\\C.F. Aplicaciones Multiplataforma\\PROYECTO_V2\\reoyecto_v2_AMS\\proyecto_V2\\resource\\vertical_space.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tamaño del label
		lblImage. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblImage);//añadimos el label
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogIn.setBounds(290, 406, 115, 35);
		btnLogIn.addActionListener(this);
		contentPane.add(btnLogIn);
		
		btnSingIn = new JButton("Sing In");
		btnSingIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSingIn.setBounds(481, 406, 115, 35);
		btnSingIn.addActionListener(this);
		contentPane.add(btnSingIn);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBounds(290, 153, 320, 35);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(290, 108, 115, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(290, 198, 115, 35);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(290, 243, 320, 35);
		contentPane.add(txtPassword);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnLogIn==e.getSource()) {
			
			String username=txtUsername.getText();
			String pass=txtPassword.getText();
			
			connectionOracle conn=new connectionOracle(url, user, password);
			boolean retorno=conn.LogIn(username, pass);
			if (retorno==true) {
				mainWindow main=new mainWindow();
				this.setVisible(false);
				main.setVisible(true);
			
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR: El usuario o la contraseña son incorrectos");
			}
			
		}
		
		if (btnSingIn==e.getSource()) {
			registerWindow singIn=new registerWindow();
			this.setVisible(false);
			singIn.setVisible(true);
			
		}
		
	}
}
