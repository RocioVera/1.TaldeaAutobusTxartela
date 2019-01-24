package ikuspegia;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Leiho6 extends JFrame {
	private JLabel lblEskerrikAskoMezua1;
	private JLabel lblEskerrikAskoMezua2;

	public Leiho6() {
		setLayout(null);
		this.setBounds(350,50,600,600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		//Eskerrik asko mezua
		lblEskerrikAskoMezua1 = new JLabel("Eskerrik asko Termibus-eko");
		lblEskerrikAskoMezua1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua1.setFont(new Font("MS PMincho", Font.BOLD, 35));
		lblEskerrikAskoMezua1.setBounds(46, 96, 493, 53);
		add(lblEskerrikAskoMezua1);
		
		lblEskerrikAskoMezua2 = new JLabel("makinetan erosteagatik");
		lblEskerrikAskoMezua2.setFont(new Font("MS PMincho", Font.BOLD, 35));
		lblEskerrikAskoMezua2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua2.setBounds(56, 137, 493, 59);
		add(lblEskerrikAskoMezua2);
		
		//FALTA EL TICKET
		
	}


}
