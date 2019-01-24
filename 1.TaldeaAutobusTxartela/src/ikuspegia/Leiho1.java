package ikuspegia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import kontrolatzailea.Metodoak;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Leiho1 extends JFrame {
	private JLabel lblOngietorri;
	private JLabel lblArgazkia;
			
	public Leiho1() {
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		JButton aurreraBtn = new JButton("");
		aurreraBtn.setIcon(new ImageIcon(".\\Argazkiak\\logo-termibus.png"));
		aurreraBtn.setBounds(0, 0, 600, 600);
		getContentPane().add(aurreraBtn);
		aurreraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodoak.bigarrenLeihoa();
				dispose();
			}
		});
		
	}		
}
