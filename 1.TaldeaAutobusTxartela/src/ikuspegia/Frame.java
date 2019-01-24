package ikuspegia;

import java.awt.*;
import javax.swing.*;
import kontrolatzailea.*;

import ikuspegia.*;
import ikuspegia.Frame;
import kontrolatzailea.*;

import java.awt.event.*;
import java.util.ArrayList;

import ikuspegia.*;

public class Frame extends JFrame {

	ArrayList<Integer> arrayGeltokiak = new ArrayList<Integer>();

	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints config = new GridBagConstraints();
	// JPanel 6 objetu sortzen ditugu

	static Leiho1 Leiho1 = new Leiho1();
	static Leiho2 Leiho2 = new Leiho2();
	static Leiho3 Leiho3 = new Leiho3();
	static Leiho4 Leiho4 = new Leiho4();
	static Leiho5 Leiho5 = new Leiho5();
	static Leiho6 Leiho6 = new Leiho6();

	// JPanel batetik bestera joateko botoiak
	static JButton btn_next = new JButton("Hurrengoa");
	static JButton btn_prev = new JButton("Atzera");
	JButton restart = new JButton("\u2302");

	public Frame() {
		setTitle("Autobus txartelen salmenta");

		// Frame neurketa
		this.setSize(new Dimension(600, 600));
		this.setResizable(false); // neurketak ez aldatzeko
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(layout);

		//
		config.gridx = 0;
		config.gridy = 0;
		config.gridwidth = 3;
		config.gridheight = 1;
		config.weightx = 1.0;
		config.weighty = 1.0;
		config.anchor = GridBagConstraints.CENTER;
		config.fill = GridBagConstraints.BOTH;

		//
		this.add(Leiho1, config);
		this.add(Leiho2, config);
		this.add(Leiho3, config);
		this.add(Leiho4, config);
		this.add(Leiho5, config);
		this.add(Leiho6, config);


		// aurreko leihora joateko botoiaren konfigurazioa
		config.gridx = 1;
		config.gridy = 1;
		config.gridwidth = 1;
		config.gridheight = 1;
		config.ipadx = 100;
		config.ipady = 10;
		config.weighty = 0.0;
		config.anchor = GridBagConstraints.CENTER;
		config.fill = GridBagConstraints.CENTER;
		this.add(btn_prev, config);

		// hurrengo leihora joateko botoiaren konfigurazioa
		config.gridx = 2;
		config.gridy = 1;
		config.gridwidth = 1;
		config.gridheight = 1;
		config.ipadx = 100;
		config.ipady = 10;
		config.weighty = 0.0;
		config.anchor = GridBagConstraints.CENTER;
		config.fill = GridBagConstraints.CENTER;
		this.add(btn_next, config);

		// Lehenengo leihora joateko botoiaren konfigurazioa
		config.gridx = 0;
		config.gridy = 1;
		config.gridwidth = 1;
		config.gridheight = 1;
		config.ipadx = 10;
		config.ipady = 10;
		config.weighty = 0.0;
		config.anchor = GridBagConstraints.CENTER;
		config.fill = GridBagConstraints.CENTER;
		this.add(restart, config);

		// Lehenengo leihoa ikusteko
		Leiho1.setVisible(true);
		Leiho2.setVisible(false);
		Leiho3.setVisible(false);
		Leiho4.setVisible(false);
		Leiho5.setVisible(false);
		Leiho6.setVisible(false);
		btn_next.setVisible(false);
		btn_prev.setVisible(false);
		restart.setVisible(false);

		// edozein lekuan leiho 1 aurrera joan
		Leiho1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Leiho1.isVisible()) {
					btn_next.setVisible(false);
					restart.setVisible(true);
					Leiho2.setVisible(true);
					Leiho3.setVisible(false);
					Leiho4.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					Leiho1.setVisible(false);
					validate();
				}
			}
		});

		// aurreko botoia
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn_prev.setVisible(true);
				if (Leiho2.isVisible()) {
					btn_next.setVisible(false);
					Leiho3.setVisible(true);
					Leiho4.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					Leiho1.setVisible(false);
					Leiho2.setVisible(false);
					validate();

				} else if (Leiho3.isVisible()) {
					btn_next.setVisible(false);
					Leiho4.setVisible(true);
					Leiho3.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					Leiho1.setVisible(false);
					Leiho2.setVisible(false);
					validate();

				} else if (Leiho4.isVisible()) {
					btn_next.setVisible(false);
					Leiho5.setVisible(true);
					Leiho6.setVisible(false);
					Leiho1.setVisible(false);
					Leiho2.setVisible(false);
					Leiho3.setVisible(false);
					Leiho4.setVisible(false);
					validate();

				} else if (Leiho5.isVisible()) {
					btn_next.setVisible(false);
					btn_prev.setVisible(false);
					restart.setVisible(false);
					Leiho6.setVisible(true);
					Leiho5.setVisible(false);
					Leiho1.setVisible(false);
					Leiho2.setVisible(false);
					Leiho3.setVisible(false);
					Leiho4.setVisible(false);
					validate();
					// segunduak pasa ondoren lehenengo panelera joatea
					Leiho_segunduak Leiho_segunduak = new Leiho_segunduak();
					//Leiho_segunduak.start();
					// hasieratzeko guztia
					Metodoak.hasieratuMetodoa();
				}
			}
		});

		// atzeko leihora joan
		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Leiho2.isVisible()) {
					btn_prev.setVisible(false);
					Leiho1.setVisible(true);
					Leiho3.setVisible(false);
					Leiho4.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					Leiho2.setVisible(false);
					validate();

				} else if (Leiho3.isVisible()) {
					btn_prev.setVisible(false);
					Leiho2.setVisible(true);
					Leiho3.setVisible(false);
					Leiho4.setVisible(false);
					Leiho1.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					validate();

				} else if (Leiho4.isVisible()) {
					Leiho3.setVisible(true);
					Leiho2.setVisible(false);
					Leiho4.setVisible(false);
					Leiho1.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					validate();
				} else if (Leiho5.isVisible()) {
					btn_prev.setVisible(true);
					Leiho4.setVisible(true);
					Leiho2.setVisible(false);
					Leiho3.setVisible(false);
					Leiho1.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					validate();
				}
			}
		});

		// lehengo leihora joateko botoia
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// eredua.hasieratuMetodoa();
				Leiho1.setVisible(true);
				Leiho3.setVisible(false);
				Leiho4.setVisible(false);
				Leiho5.setVisible(false);
				Leiho6.setVisible(false);
				Leiho2.setVisible(false);
				if (Leiho1.isVisible()) {
					// btn_next.setVisible(false);
					btn_prev.setVisible(false);
					restart.setVisible(false);
				}
				validate();
			}

		});
	}
	public static void hartuErabakitakoLinea(String linea) {
		System.out.println(linea);
	}
}