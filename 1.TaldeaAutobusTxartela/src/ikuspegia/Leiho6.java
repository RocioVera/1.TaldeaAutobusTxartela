package ikuspegia;

import java.awt.*;
import javax.swing.*;
import kontrolatzailea.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Leiho6 extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JLabel lblEskerrikAskoMezua1, lblEskerrikAskoMezua2;
	private JButton btnTiketaImprimatu;
	private JTextArea txtTiket;

	/**
	 * Tiketa imprimatzen duen panela sortu
	 * 
	 * @param hartutakoLinea
	 * @param autobusa
	 * @param ibilbideZbk
	 * @param hasierakoGeltokiaKod
	 * @param amaierakoGeltokiaKod
	 * @author talde1
	 * @param txartela
	 * @param arrayGeltokia
	 */
	public Leiho6(String hartutakoLinea, Autobusak autobusa, int ibilbideZbk, int hasierakoGeltokiaKod,
			int amaierakoGeltokiaKod, Txartelak txartela) {
		// panelaren propietateak
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		// Eskerrik asko mezua
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

		txtTiket = new JTextArea();
		txtTiket.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtTiket.setText(" Ibilbidearen datuak:  \n" + "   -Hartutako linea:  " + txartela.getkodLinea() + "\n  "
				+ " -Hasierako geltokia:  " + txartela.getkodGeltokiHasiera() + "\n  " + " -Amaierako geltokia:  "
				+ txartela.getkodGeltokiAmaiera() + "\n  " + " -Zure autobusaren kodigoa:  " + txartela.getkodBus()
				+ "\n\n" + " Bezeroaren datuak: \n" + "   -NAN: " + txartela.getNan() + "\n\n"
				+ " Erosketaren datuak: \n" + "   -Bidaiaren prezioa:  " + txartela.getPrezioa() + "€");
		txtTiket.setEditable(false);
		txtTiket.setBackground(Color.LIGHT_GRAY);
		txtTiket.setBounds(92, 220, 411, 262);
		getContentPane().add(txtTiket);

		btnTiketaImprimatu = new JButton("Tiketa imprimatu eta bukatu erosketa");
		btnTiketaImprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodoak.Leiho_segunduak();
				dispose();
			}
		});
		btnTiketaImprimatu.setBounds(130, 169, 306, 25);
		getContentPane().add(btnTiketaImprimatu);

		// FALTA EL TICKET

	}
}
