package ikuspegia;
import java.awt.*;
import javax.swing.*;

import kontrolatzailea.Autobusak;
import kontrolatzailea.Geltokiak;
import kontrolatzailea.Metodoak;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Leiho6 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblEskerrikAskoMezua1, lblEskerrikAskoMezua2;
	private JButton btnTiketaImprimatu;
	private JTextField txtSegundenMezua;

	public Leiho6(String hartutakoLinea, Autobusak autobusa, int ibilbideZbk, int hasierakoGeltokiaKod, int amaierakoGeltokiaKod) {
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		//Eskerrik asko mezua
		lblEskerrikAskoMezua1 = new JLabel("Eskerrik asko Termibus-eko");
		lblEskerrikAskoMezua1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua1.setFont(new Font("MS PMincho", Font.BOLD, 35));
		lblEskerrikAskoMezua1.setBounds(43, 29, 493, 53);
		getContentPane().add(lblEskerrikAskoMezua1);
		
		lblEskerrikAskoMezua2 = new JLabel("makinetan erosteagatik");
		lblEskerrikAskoMezua2.setFont(new Font("MS PMincho", Font.BOLD, 35));
		lblEskerrikAskoMezua2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua2.setBounds(53, 84, 493, 59);
		getContentPane().add(lblEskerrikAskoMezua2);
		
		
		txtSegundenMezua = new JTextField("Tiketa");
		txtSegundenMezua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSegundenMezua.setHorizontalAlignment(SwingConstants.CENTER);
		txtSegundenMezua.setBackground(Color.LIGHT_GRAY);
		txtSegundenMezua.setBounds(99, 230, 389, 216);
		getContentPane().add(txtSegundenMezua);

		//lblPasahitza = new JLabel("Pasahitza:");
	//	lblNan.setVisible(false);
		
		btnTiketaImprimatu = new JButton("Tiketa imprimatu eta bukatu erosketa");
		btnTiketaImprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodoak.Leiho_segunduak();
				dispose();
			}
		});
		btnTiketaImprimatu.setBounds(130, 169, 306, 25);
		getContentPane().add(btnTiketaImprimatu);
		
		
		//FALTA EL TICKET
		
	}
}
