package ikuspegia;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leiho5 extends JPanel {
	//new
	static JTextField txtPrezioTot = new JTextField();
	static JTextField txtDiruFalta = new JTextField();
	static JTextField txtBueltak = new JTextField();
	static JTextArea txtrTxtareatxanponbueltak = new JTextArea();

	int kont = 0;
	static String guztiraPrezBEZ;
	static String txanponTot="";

	double diruFalta;

	/**
	 * Create the panel.
	 */
	public Leiho5() {
		setToolTipText("");
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		/* Prezio totala */
		JLabel lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrezioTotala.setBounds(176, 29, 117, 20);
		add(lblPrezioTotala);

		txtPrezioTot.setEditable(false);
		txtPrezioTot.setColumns(10);
		txtPrezioTot.setBounds(300, 29, 86, 20);
		//guztiraPrezBEZ = zerrenda.guztiraPrezBEZMetodoa();
		txtPrezioTot.setText(guztiraPrezBEZ + " €");
		add(txtPrezioTot);

		/* ZenbatDiru sartu nahi */
		JLabel lblZenbatDiru = new JLabel("Zenbat diru sartu nahi duzu?");
		lblZenbatDiru.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZenbatDiru.setBounds(164, 72, 304, 20);
		add(lblZenbatDiru);

		JLabel lblEuro;
		lblEuro = new JLabel("Euroak");
		lblEuro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEuro.setBounds(115, 119, 56, 20);
		add(lblEuro);

		JLabel lblZentimo;
		lblZentimo = new JLabel("Zentimoak");
		lblZentimo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZentimo.setBounds(411, 119, 134, 20);
		add(lblZentimo);

		JButton btn_200Euro = new JButton("200\u20AC");
		btn_200Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 1;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_200Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_200Euro.setBackground(Color.WHITE);
		btn_200Euro.setBounds(36, 150, 89, 23);
		add(btn_200Euro);

		JButton btn_100Euro = new JButton("100\u20AC");
		btn_100Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 2;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_100Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_100Euro.setBackground(Color.WHITE);
		btn_100Euro.setBounds(36, 184, 89, 23);
		add(btn_100Euro);

		JButton btn_50Euro = new JButton("50\u20AC");
		btn_50Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 3;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_50Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_50Euro.setBackground(Color.WHITE);
		btn_50Euro.setBounds(36, 218, 89, 23);
		add(btn_50Euro);

		JButton btn_20Euro = new JButton("20\u20AC");
		btn_20Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 4;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_20Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_20Euro.setForeground(Color.BLACK);
		btn_20Euro.setBackground(Color.WHITE);
		btn_20Euro.setBounds(36, 252, 89, 23);
		add(btn_20Euro);

		JButton btn_10Euro = new JButton("10\u20AC");
		btn_10Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 5;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_10Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_10Euro.setBackground(Color.WHITE);
		btn_10Euro.setBounds(164, 150, 89, 23);
		add(btn_10Euro);

		JButton btn_5Euro = new JButton("5\u20AC");
		btn_5Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 6;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_5Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_5Euro.setBackground(Color.WHITE);
		btn_5Euro.setBounds(164, 184, 89, 23);
		add(btn_5Euro);

		JButton btn_2Euro = new JButton("2\u20AC");
		btn_2Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 7;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_2Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_2Euro.setBackground(Color.WHITE);
		btn_2Euro.setBounds(164, 218, 89, 23);
		add(btn_2Euro);

		JButton btn_1Euro = new JButton("1\u20AC");
		btn_1Euro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 8;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_1Euro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_1Euro.setBackground(Color.WHITE);
		btn_1Euro.setBounds(164, 252, 89, 23);
		add(btn_1Euro);

		JButton btn_50Zent = new JButton("50 zent");
		btn_50Zent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 9;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_50Zent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_50Zent.setBackground(Color.WHITE);
		btn_50Zent.setBounds(341, 150, 89, 23);
		add(btn_50Zent);

		JButton btn_20Zent = new JButton("20 zent");
		btn_20Zent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 10;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_20Zent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_20Zent.setBackground(Color.WHITE);
		btn_20Zent.setBounds(341, 184, 89, 23);
		add(btn_20Zent);

		JButton btn_10Zent = new JButton("10 zent");
		btn_10Zent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 11;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_10Zent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_10Zent.setBackground(Color.WHITE);
		btn_10Zent.setBounds(341, 218, 89, 23);
		add(btn_10Zent);

		JButton btn_5Zent = new JButton("5 zent");
		btn_5Zent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 12;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_5Zent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_5Zent.setBackground(Color.WHITE);
		btn_5Zent.setBounds(469, 150, 89, 23);
		add(btn_5Zent);

		JButton btn_2Zent = new JButton("2 zent");
		btn_2Zent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 13;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_2Zent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_2Zent.setBackground(Color.WHITE);
		btn_2Zent.setBounds(469, 184, 89, 23);
		add(btn_2Zent);

		JButton btn_1Zent = new JButton("1 zent");
		btn_1Zent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 14;
				//String.valueOf(zerrenda.diruaSartu(kont));
			}
		});
		btn_1Zent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_1Zent.setBackground(Color.WHITE);
		btn_1Zent.setBounds(469, 218, 89, 23);
		add(btn_1Zent);

		// Diru falta
		txtDiruFalta = new JTextField();
		txtDiruFalta.setForeground(Color.RED);
		txtDiruFalta.setEditable(false);
		txtDiruFalta.setColumns(10);
		txtDiruFalta.setBounds(206, 415, 86, 20);
		txtDiruFalta.setText(guztiraPrezBEZ + " €");
		add(txtDiruFalta);

		txtBueltak = new JTextField();
		// Zenbat bueltak eman behar
		txtBueltak.setForeground(Color.BLUE);
		txtBueltak.setEditable(false);
		txtBueltak.setColumns(10);
		txtBueltak.setBounds(206, 461, 86, 20);
		txtBueltak.setText("0.00€");
		add(txtBueltak);

		/* Erosi */
		JButton btnErosi = new JButton("Erosi");
		btnErosi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//diruFalta = zerrenda.diruFaltaBueltakMetodoa();
				String diruFaltaString = String.valueOf(diruFalta);

				if (diruFalta > 0) {
					// Diru falta
					txtDiruFalta.setText(diruFaltaString + " €");
					txtBueltak.setText("0.00 €");
				} else if (diruFalta < 0) {
					diruFaltaString = String.valueOf(-diruFalta);
					txtBueltak.setText(diruFaltaString + " €");
					txtDiruFalta.setText("0.00 €");
					//txanponTot
					//txanponTot=zerrenda.bueltakZerrenda();
					txtrTxtareatxanponbueltak.setText(txanponTot);
					Frame.btn_next.setVisible(true);
												
				} else {
					Frame.btn_next.setVisible(true);
					txtDiruFalta.setText("0.00 €");
					txtBueltak.setText("0.00 €");
				}
			}

		});
		btnErosi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnErosi.setBackground(Color.WHITE);
		btnErosi.setForeground(new Color(0, 0, 0));
		btnErosi.setBounds(152, 350, 90, 38);
		add(btnErosi);

		// Diru falta
		JLabel lblDiruFalta = new JLabel("Diru falta:");
		lblDiruFalta.setForeground(Color.RED);
		lblDiruFalta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiruFalta.setBounds(96, 415, 95, 20);
		add(lblDiruFalta);

		// Zenbat bueltak eman behar
		JLabel lblBueltak = new JLabel("Bueltak:");
		lblBueltak.setForeground(Color.BLUE);
		lblBueltak.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBueltak.setBounds(96, 461, 86, 20);
		add(lblBueltak);
		
		//Bueltak zerrenda
		txtrTxtareatxanponbueltak.setBackground(Color.LIGHT_GRAY);
		txtrTxtareatxanponbueltak.setText("Emaiozu botoiari");
		txtrTxtareatxanponbueltak.setBounds(313, 350, 277, 219);
		add(txtrTxtareatxanponbueltak);
		

	}
}
