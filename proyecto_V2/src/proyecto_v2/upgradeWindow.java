package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class upgradeWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnUpDef, btnUpAtack, btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new upgradeWindow();
	}

	/**
	 * Create the frame.
	 */
	public upgradeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 519);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPGRADE TECHNOLOGY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(81, 46, 550, 61);
		contentPane.add(lblNewLabel);
		
		btnUpDef = new JButton(" UPDATE DEFENSE");
		btnUpDef.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpDef.addActionListener(this);
		btnUpDef.setBounds(481, 177, 168, 45);
		contentPane.add(btnUpDef);
		
		btnUpAtack = new JButton("UPDATE ATTACK");
		btnUpAtack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpAtack.addActionListener(this);
		btnUpAtack.setBounds(481, 230, 168, 45);
		contentPane.add(btnUpAtack);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.addActionListener(this);
		btnBack.setBounds(499, 376, 150, 45);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Update Defense Technology.      Cost: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(81, 177, 261, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Update Attack Technology.      Cost: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(81, 230, 261, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("x");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(377, 177, 80, 45);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("xx");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(377, 230, 80, 45);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Actual Defense Technology");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(81, 323, 197, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Actual Attack Technology");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(81, 376, 197, 45);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblActDefTech = new JLabel("xxx");
		lblActDefTech.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActDefTech.setBounds(288, 323, 80, 45);
		contentPane.add(lblActDefTech);
		
		JLabel lblActAtaTech = new JLabel("xxxx");
		lblActAtaTech.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActAtaTech.setBounds(288, 376, 80, 45);
		contentPane.add(lblActAtaTech);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnUpDef==e.getSource()) {
			
		}
		if (btnUpAtack==e.getSource()) {
			
		}
		if (btnBack==e.getSource()) {
			mainWindow main=new mainWindow();
			this.setVisible(false);
			main.setVisible(true);
		}
		
	}

}
