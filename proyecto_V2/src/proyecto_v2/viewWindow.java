package proyecto_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class viewWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new viewWindow();
	}

	/**
	 * Create the frame.
	 */
	public viewWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(65, 404, 115, 45);
		contentPane.add(btnBack);
		
		JLabel lblTitle = new JLabel("VIEW PLANET STATS");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(140, 50, 500, 45);
		lblTitle.setBorder(null);
		contentPane.add(lblTitle);
		
		JLabel lblMetal = new JLabel("Metal");
		lblMetal.setBounds(240, 378, 80, 20);
		contentPane.add(lblMetal);
		
		JLabel lblDeuterium = new JLabel("Deuterium");
		lblDeuterium.setBounds(240, 418, 80, 20);
		contentPane.add(lblDeuterium);
		
		JLabel lblNewLabel_1_1 = new JLabel("x");
		lblNewLabel_1_1.setBounds(352, 382, 80, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("xx");
		lblNewLabel_1_1_1.setBounds(352, 422, 80, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblTechnology = new JLabel("TECHNOLOGY");
		lblTechnology.setBounds(65, 129, 80, 20);
		contentPane.add(lblTechnology);
		
		JLabel lblDefenses = new JLabel("DEFENSES");
		lblDefenses.setBounds(240, 129, 80, 20);
		contentPane.add(lblDefenses);
		
		JLabel lblMisileLaun = new JLabel("Missili Launcher: ");
		lblMisileLaun.setBounds(240, 174, 80, 20);
		contentPane.add(lblMisileLaun);
		
		JLabel lblIonCannon = new JLabel("Ion Cannon: ");
		lblIonCannon.setBounds(240, 209, 80, 20);
		contentPane.add(lblIonCannon);
		
		JLabel lblPlasmaCannon = new JLabel("Plasma Cannon: ");
		lblPlasmaCannon.setBounds(240, 250, 80, 20);
		contentPane.add(lblPlasmaCannon);
		
		JLabel lblAttackTech = new JLabel("Attack Technology:");
		lblAttackTech.setBounds(65, 178, 99, 20);
		contentPane.add(lblAttackTech);
		
		JLabel lblDefenseTech = new JLabel("Defense Technology: ");
		lblDefenseTech.setBounds(65, 217, 99, 20);
		contentPane.add(lblDefenseTech);
		
		JLabel lblAttack = new JLabel("x");
		lblAttack.setBounds(184, 178, 80, 20);
		contentPane.add(lblAttack);
		
		JLabel lblDefense = new JLabel("xx");
		lblDefense.setBounds(184, 217, 80, 20);
		contentPane.add(lblDefense);
		
		JLabel lblMisile = new JLabel("x");
		lblMisile.setBounds(351, 174, 80, 20);
		contentPane.add(lblMisile);
		
		JLabel lblIon = new JLabel("xx");
		lblIon.setBounds(351, 213, 80, 20);
		contentPane.add(lblIon);
		
		JLabel lblPlasma = new JLabel("xxx");
		lblPlasma.setBounds(351, 254, 80, 20);
		contentPane.add(lblPlasma);
		
		JLabel lblFleet = new JLabel("FLEET");
		lblFleet.setBounds(411, 129, 80, 20);
		contentPane.add(lblFleet);
		
		JLabel lblLigthHuntter = new JLabel("Ligth Huntter: ");
		lblLigthHuntter.setBounds(411, 174, 80, 20);
		contentPane.add(lblLigthHuntter);
		
		JLabel lblHeavyhunter = new JLabel("HeavyHunter: ");
		lblHeavyhunter.setBounds(411, 209, 80, 20);
		contentPane.add(lblHeavyhunter);
		
		JLabel lblArmoredShip = new JLabel("Battle Ship: ");
		lblArmoredShip.setBounds(411, 250, 80, 20);
		contentPane.add(lblArmoredShip);
		
		JLabel lblIon_1 = new JLabel("xx");
		lblIon_1.setBounds(522, 213, 80, 20);
		contentPane.add(lblIon_1);
		
		JLabel lblMisile_1 = new JLabel("x");
		lblMisile_1.setBounds(522, 174, 80, 20);
		contentPane.add(lblMisile_1);
		
		JLabel lblPlasma_1 = new JLabel("xxx");
		lblPlasma_1.setBounds(522, 254, 80, 20);
		contentPane.add(lblPlasma_1);
		
		JLabel lblArmoredShip_1 = new JLabel("Armored Ship: ");
		lblArmoredShip_1.setBounds(411, 288, 80, 20);
		contentPane.add(lblArmoredShip_1);
		
		JLabel lblPlasma_1_1 = new JLabel("xxxx");
		lblPlasma_1_1.setBounds(522, 292, 80, 20);
		contentPane.add(lblPlasma_1_1);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnBack==e.getSource()) {
			mainWindow main=new mainWindow();
			this.setVisible(false);
			main.setVisible(true);
		}
		
	}

}
