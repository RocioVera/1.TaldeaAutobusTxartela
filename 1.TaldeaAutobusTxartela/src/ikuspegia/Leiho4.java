package ikuspegia;

import java.awt.*;
import javax.swing.*;

import kontrolatzailea.Metodoak;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leiho4 extends JFrame {
	static JTextField txtPrezioTot = new JTextField();
	private JTextField txtNan;
	private JPasswordField passwordField;
	private JLabel lblPrezioTotala;
	private JButton btnSartu;
	private JLabel lblNan;
	private JLabel lblPasahitza;

	JButton btn_next = new JButton("Hurrengoa");
	JButton btn_prev = new JButton("Atzera");
	JButton restart = new JButton("\u2302");
	
	public Leiho4() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		
		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bostgarrenLeihoa();
				dispose();
			}
		});
		btn_next.setBounds(461, 510, 89, 23);
		getContentPane().add(btn_next);
		
		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.hirugarrenLeihoa();
				dispose();
			}
		});
		btn_prev.setBounds(38, 510, 89, 23);
		getContentPane().add(btn_prev);
		
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(269, 510, 89, 23);
		getContentPane().add(restart);
		
		
		
		lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrezioTotala.setBounds(159, 76, 117, 20);
		add(lblPrezioTotala);

		txtPrezioTot.setEditable(false);
		txtPrezioTot.setColumns(10);
		txtPrezioTot.setBounds(283, 76, 86, 20);
		String guztiraPrezBEZ="";
		//guztiraPrezBEZ = zerrenda.guztiraPrezBEZMetodoa();
		txtPrezioTot.setText(guztiraPrezBEZ + " €");
		add(txtPrezioTot);

		btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNan = new JLabel("NAN:");
				lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblNan.setBounds(199, 223, 61, 20);
				add(lblNan);
				
				txtNan = new JTextField();
				txtNan.setColumns(10);
				txtNan.setBounds(306, 225, 86, 20);
				add(txtNan);
				
				JLabel lblPasahitza = new JLabel("Pasahitza:");
				lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblPasahitza.setBounds(199, 266, 102, 20);
				add(lblPasahitza);
				
				
				passwordField = new JPasswordField();
				passwordField.setEchoChar('*');
				passwordField.setBounds(306, 267, 86, 22);
				add(passwordField);
			
				//al quitar esto no aparece lo demas
	//			Frame.btn_next.setVisible(true);
				
				JButton btnKonektatu = new JButton("Konektatu");
				btnKonektatu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//conectar a la bbdd para la pasahitza
	//					Frame.btn_next.setVisible(true);
					}
				});
				btnKonektatu.setBounds(252, 318, 104, 25);
				add(btnKonektatu);

				
			}
		});
		btnSartu.setBounds(252, 156, 69, 25);
		add(btnSartu);		
		
	}
}
