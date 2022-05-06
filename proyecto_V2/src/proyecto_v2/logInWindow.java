package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logInWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2;
	private JButton btnLogIn, btnSingIn;
	

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
		setBounds(100, 100, 720, 519);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(290, 110, 320, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(290, 65, 115, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(290, 155, 115, 35);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(290, 200, 320, 35);
		contentPane.add(textField_1);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRepeatPassword.setBounds(290, 245, 115, 35);
		contentPane.add(lblRepeatPassword);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(290, 290, 320, 35);
		contentPane.add(textField_2);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnLogIn==e.getSource()) {
			mainWindow main=new mainWindow();
			this.setVisible(false);
			main.setVisible(true);
		}
		if (btnSingIn==e.getSource()) {
			registerWindow singIn=new registerWindow();
			this.setVisible(false);
			singIn.setVisible(true);
			
		}
		
	}
}
