package ikuspegia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JList;

public class Leiho1 extends JPanel {
	private JLabel lblOngietorri;
	private JLabel lblArgazkia;
			
	public Leiho1() {
		setLayout(null);
		this.setSize(new Dimension(600, 600));

		lblOngietorri = new JLabel("Ongi etorri Termibus-eko makinara");
		lblOngietorri.setFont(new Font("Rockwell Condensed", Font.BOLD, 30));
		lblOngietorri.setBackground(Color.WHITE);
		lblOngietorri.setForeground(Color.BLACK);
		lblOngietorri.setBounds(86, 128, 483, 43);
		add(lblOngietorri);
		
		lblArgazkia = new JLabel("");
		lblArgazkia.setIcon(new ImageIcon(".\\Argazkiak\\logo-termibus.png"));
		
		lblArgazkia.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArgazkia.setBackground(Color.WHITE);
		lblArgazkia.setBounds(132, 215, 310, 148);
		add(lblArgazkia);

	}
}
