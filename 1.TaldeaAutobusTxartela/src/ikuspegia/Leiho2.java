package ikuspegia;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import java.util.ArrayList;

import eredua.*;
import kontrolatzailea.*;
import eredua.Kontsultak;

public class Leiho2 extends JPanel {
	private JTextField txtErabakiLinea;
	private JRadioButton L1;
	private JRadioButton L2;
	private JRadioButton L3;
	private JRadioButton L4;
	private ButtonGroup group;
	
	public Leiho2() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));
		Font font;
		font = new Font("Verdana", Font.PLAIN, 16);

		// NEW
		ArrayList<Lineak> lineak = new ArrayList<>();
		lineak = Kontsultak.lineakDatuak();

		L1 = new JRadioButton(lineak.get(0).getKodLinea() + "        " + lineak.get(0).getIzena());
		L2 = new JRadioButton(lineak.get(1).getKodLinea() + "        " + lineak.get(1).getIzena());
		L3 = new JRadioButton(lineak.get(2).getKodLinea() + "        " + lineak.get(2).getIzena());
		L4 = new JRadioButton(lineak.get(3).getKodLinea() + "        " + lineak.get(3).getIzena());
		group = new ButtonGroup();
		txtErabakiLinea = new JTextField();

		// non dagoen label bakoitza
		L1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.btn_next.setVisible(true);
				Frame.hartuErabakitakoLinea("L1");	
			}
		});
		L1.setBounds(47, 85, 530, 85);
		L1.setFont(font);
		add(L1);

		L2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.btn_next.setVisible(true);
				Frame.hartuErabakitakoLinea("L2");
			}
		});
		L2.setBounds(47, 187, 530, 85);
		L2.setFont(font);
		add(L2);

		L3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.btn_next.setVisible(true);
				Frame.hartuErabakitakoLinea("L3");
			}
		});
		L3.setBounds(47, 288, 530, 85);
		L3.setFont(font);
		add(L3);

		L4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.btn_next.setVisible(true);
				Frame.hartuErabakitakoLinea("L4");
			}
		});
		L4.setBounds(47, 380, 530, 85);
		L4.setFont(font);
		add(L4);

		group.add(L1);
		group.add(L2);
		group.add(L3);
		group.add(L4);

		txtErabakiLinea.setText("Klikatu nahi duzun linearen gainean");
		txtErabakiLinea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtErabakiLinea.setHorizontalAlignment(SwingConstants.CENTER);
		txtErabakiLinea.setForeground(Color.LIGHT_GRAY);
		txtErabakiLinea.setBackground(Color.RED);
		txtErabakiLinea.setEditable(false);
		txtErabakiLinea.setBounds(0, 24, 600, 50);
		add(txtErabakiLinea);

	}
}