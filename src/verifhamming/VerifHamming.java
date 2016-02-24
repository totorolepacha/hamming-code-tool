/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifhamming;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Yohann Bacha <y.bacha@live.fr>
 */
public class VerifHamming extends JFrame {
	
	public JTextField code;
	private DisplayPane dp;
	
	public VerifHamming() {
		this.setTitle("Générateur Hamming");
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5,3,5,3);
		this.add(new JLabel("Entrez le mot concerné :"), gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 1.;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.code = new JTextField(18);
		this.add(this.code, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10,3,5,3);
		this.add(new JButton(new GenerateCode()), gbc);
		
		gbc.gridx = 1;
		this.add(new JButton(new VerifyCode()), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		this.dp = new DisplayPane();
		this.add(this.dp, gbc);
		
		pack();
		this.setLocation(420, 420);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class GenerateCode extends AbstractAction {
		public GenerateCode() {
			super("Générer mot");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dp.refreshPane();
		}
	}
	
	public class VerifyCode extends AbstractAction {
		public VerifyCode() {
			super("Vérifier mot");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dp.refreshPane();
		}
	}
	
	public static void main(String[] args) {
		new VerifHamming();
	}
	
}
