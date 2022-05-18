

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
import java.util.ArrayList;

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
	private Planet planet;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private int ides;
	private JPanel contentPane;
	private JTextField txtUsername, txtPassword;
	private JButton btnLogIn, btnSingIn;
	
	private String url="jdbc:oracle:thin:@192.168.40.2:1521:orcl";
	private String user="alumnoAMS17";
	private String password="alumnoAMS17";
	
	Connection conn;
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		new logInWindow(new Planet());
	}

	/**
	 * Create the frame.
	 */
	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	public int getIdes() {
		return this.ides;
	}
	
	public logInWindow(Planet planet,ArrayList<MilitaryUnit>[] enemyArmy) {
		this.planet=planet;
		this.enemyArmy=enemyArmy;
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
		ImageIcon imagen= new ImageIcon("vertical_space.jpg");
		ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(),Image.SCALE_DEFAULT));//auto escala la imagen al tama�o del label
		lblImage. setIcon(icono);//establece el ImageIcon en el label
		contentPane.add(lblImage);//a�adimos el label
		
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
			//System.out.println(conn.LogIn(username, pass));
			boolean retorno=conn.LogIn(username, pass);
			this.ides=conn.getIdes();
			if (retorno==true) {
				this.planet=conn.recibirPlaneta();
				mainWindow main=new mainWindow(planet,enemyArmy,ides);
				this.setVisible(false);
				main.setVisible(true);
			
			}
			else {
				JOptionPane.showMessageDialog(null, "ERROR: El usuario o la contrase�a son incorrectos");
			}
			
		}
		
		if (btnSingIn==e.getSource()) {
			registerWindow singIn=new registerWindow(planet,enemyArmy,ides);
			this.setVisible(false);
			singIn.setVisible(true);
			
		}
		
	}

}
