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

public class Leiho2 extends JFrame {
	private JTextField txtErabakiLinea;
	private JButton btnKaka;
	private JRadioButton L1;
	private JRadioButton L2;
	private JRadioButton L3;
	private JRadioButton L4;
	private ButtonGroup group;
	
	private JButton btn_next = new JButton("Hurrengoa");
	private JButton restart = new JButton("\u2302");
	
	public Leiho2() {
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		Font font;
		font = new Font("Verdana", Font.PLAIN, 16);
		  
		//botoiak

		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.hirugarrenLeihoa();
				dispose();
			}
		});
		btn_next.setBounds(350, 500, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		getContentPane().add(btn_next);
			
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(125, 500, 72, 32);	
		getContentPane().add(restart);
		
		// NEW
		ArrayList<Lineak> lineak = new ArrayList<>();
		lineak = Kontsultak.lineakDatuak();

		L1 = new JRadioButton(lineak.get(0).getKodLinea() + "        " + lineak.get(0).getIzena());
		L2 = new JRadioButton(lineak.get(1).getKodLinea() + "        " + lineak.get(1).getIzena());
		L3 = new JRadioButton(lineak.get(2).getKodLinea() + "        " + lineak.get(2).getIzena());
		L4 = new JRadioButton(lineak.get(3).getKodLinea() + "        " + lineak.get(3).getIzena());
		group = new ButtonGroup();
		txtErabakiLinea = new JTextField();

		String linea = "";
		if (L1.isEnabled()) {
			linea = lineak.get(0).getKodLinea();
		} else if (L2.isEnabled()) {
			linea = lineak.get(1).getKodLinea();
		} else if (L3.isEnabled()) {
			linea = lineak.get(2).getKodLinea();
		} else if (L4.isEnabled()) {
			linea = lineak.get(3).getKodLinea(); 
		}

		// non dagoen label bakoitza
		L1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Frame.hartuErabakitakoLinea("L1");	
			}
		});
		L1.setBounds(47, 85, 530, 85);
		L1.setFont(font);
		getContentPane().add(L1);

		L2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			Frame.btn_next.setVisible(true);
//				Frame.hartuErabakitakoLinea("L2");
			}
		});
		L2.setBounds(47, 187, 530, 85);
		L2.setFont(font);
		getContentPane().add(L2);

		L3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			Frame.btn_next.setVisible(true);
	//			Frame.hartuErabakitakoLinea("L3");
			}
		});
		L3.setBounds(47, 288, 530, 85);
		L3.setFont(font);
		getContentPane().add(L3);

		L4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			Frame.btn_next.setVisible(true);
		//		Frame.hartuErabakitakoLinea("L4");
			}
		});
		L4.setBounds(47, 380, 530, 85);
		L4.setFont(font);
		getContentPane().add(L4);

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
		getContentPane().add(txtErabakiLinea);

		

	}
}