package ikuspegia;

import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import com.toedter.calendar.*;

import eredua.Kontsultak;
import kontrolatzailea.Geltokiak;
import kontrolatzailea.Metodoak;

import java.awt.Font;

public class Leiho3 extends JFrame {
	private JMenuBar geltoki;
	private JMenu hasierakoGeltokia;
	private JMenu amaierakoGeltokia;
	private JMenu joanEtorri; 
	private ButtonGroup hasierakoGeltokiaGroup;
	private ButtonGroup amaierakoGeltokiaGroup;
	private ButtonGroup joanEtorriGroup;
	private ArrayList <Geltokiak> arrayparada;
	private JSpinner etorriaOrdua;
	private JSpinner etorriaMinutu;
	private JSpinner joanOrdua;
	private	JSpinner joanMinutu;
	private JLabel lblEtorria;
	private JLabel lblDataEtorria;
	private JLabel lblDataJoan;
	private JLabel lblOrduaJoan;
	private JLabel lblOrduaEtorria;
	private JLabel lblJoan;
	private JDateChooser dateEtorria;
	private JDateChooser dateJoan;
	private JRadioButton amaierakoGeltItem_1;
	private JRadioButton amaierakoGeltItem_2;
	private JRadioButton amaierakoGeltItem_3;
	private JRadioButton amaierakoGeltItem_4;
	private JRadioButton amaierakoGeltItem_5;
	private JRadioButton amaierakoGeltItem_6;
	private JRadioButton amaierakoGeltItem_7;	
	private JRadioButton hasierakoGeltItem_1;
	private JRadioButton hasierakoGeltItem_2;
	private JRadioButton hasierakoGeltItem_3;
	private JRadioButton hasierakoGeltItem_4;
	private JRadioButton hasierakoGeltItem_5;
	private JRadioButton hasierakoGeltItem_6;
	private JRadioButton hasierakoGeltItem_7;
	private JRadioButton Joan;
	private JRadioButton joanEtorria;

	JButton btn_next = new JButton("Hurrengoa");
	JButton btn_prev = new JButton("Atzera");
	JButton restart = new JButton("\u2302");

	public Leiho3() {
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.laugarrenLeihoa();
				dispose();
			}
		});
		btn_next.setBounds(461, 510, 89, 23);
		getContentPane().add(btn_next);
		
		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bigarrenLeihoa();
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

		geltoki = new JMenuBar();

		hasierakoGeltokia = new JMenu("Hasierako geltokia");
		amaierakoGeltokia = new JMenu("Amaierako geltokia");
		amaierakoGeltokia.setEnabled(false);

		joanEtorri = new JMenu("Joan/Etorria");
		joanEtorria = new JRadioButton("Joan/Etorria");
		Joan = new JRadioButton("Joan");
				
		hasierakoGeltokiaGroup = new ButtonGroup();
		amaierakoGeltokiaGroup = new ButtonGroup();
		joanEtorriGroup = new ButtonGroup();
		
		joanEtorriGroup.add(Joan);
		joanEtorriGroup.add(joanEtorria);
		
		arrayparada = new ArrayList<Geltokiak>();
		arrayparada = Kontsultak.geltokiakAtera(("L2"));

		for (int i = 0; i <= arrayparada.size(); i++) {
			if (i == 1) {
				hasierakoGeltItem_1 = new JRadioButton(arrayparada.get(0).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_1);
				hasierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_1);
						amaierakoGeltItem_1.setEnabled(false);
		//				Metodoak.geltokiakMarkatu(JRadioButton );
					}
				});
			}
			
			if (i == 2) {
				hasierakoGeltItem_2 = new JRadioButton(arrayparada.get(1).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_2);
				hasierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_2);
						amaierakoGeltItem_2.setEnabled(false);
					}
				});
			}

			if (i == 3) {
				hasierakoGeltItem_3 = new JRadioButton(arrayparada.get(2).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_3);
				hasierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_3);
						amaierakoGeltItem_3.setEnabled(false);
					}
				});
			}

			if (i == 4) {
				hasierakoGeltItem_4 = new JRadioButton(arrayparada.get(3).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_4);
				hasierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_4);
						amaierakoGeltItem_4.setEnabled(false);
					}
				});
			}

			if (i == 5) {
				hasierakoGeltItem_5 = new JRadioButton(arrayparada.get(4).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_5);
				hasierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_5);
						amaierakoGeltItem_5.setEnabled(false);
					}
				});
			}
			if (i == 6) {
				hasierakoGeltItem_6 = new JRadioButton(arrayparada.get(5).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_6);
				hasierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_6);
						amaierakoGeltItem_6.setEnabled(false);
					}
				});
			}
			
			if (i == 7) {
				hasierakoGeltItem_7 = new JRadioButton(arrayparada.get(6).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_7);
				hasierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_7);
						amaierakoGeltItem_7.setEnabled(false);
					}
				});
			}
		}

		// amaierako geltokia
		for (int i = 0; i <= arrayparada.size(); i++) {
			if (i == 1) {
				
				amaierakoGeltItem_1 = new JRadioButton(arrayparada.get(0).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_1);
				amaierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_1);
					}
				});
			}
			
			if (i == 2) {
				amaierakoGeltItem_2 = new JRadioButton(arrayparada.get(1).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_2);
				amaierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_2);
					}
				});
			}

			if (i == 3) {
				amaierakoGeltItem_3 = new JRadioButton(arrayparada.get(2).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_3);
				amaierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_3);
					}
				});
			}

			if (i == 4) {
				amaierakoGeltItem_4 = new JRadioButton(arrayparada.get(3).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_4);
				amaierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_4);
					}
				});
			}

			if (i == 5) {
				amaierakoGeltItem_5 = new JRadioButton(arrayparada.get(4).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_5);
				amaierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_5);

					}
				});
			}
			
			if (i == 6) {
				amaierakoGeltItem_6 = new JRadioButton(arrayparada.get(5).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_6);
				amaierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_6);
					}
				});
			}
			
			if (i == 7) {
				amaierakoGeltItem_7 = new JRadioButton(arrayparada.get(6).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_7);
				amaierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_7);
					}
				});
			}
		}

		geltoki.setBounds(0, 0, 600, 21);
		add(geltoki);

		geltoki.add(hasierakoGeltokia);
		geltoki.add(amaierakoGeltokia);

		geltoki.add(joanEtorri);
		joanEtorri.add(joanEtorria);
		joanEtorri.add(Joan);

		lblJoan = new JLabel("Joan");
		lblJoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoan.setBounds(28, 61, 89, 21);
		add(lblJoan);

		lblDataJoan = new JLabel("Data");
		lblDataJoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataJoan.setBounds(71, 86, 46, 21);
		add(lblDataJoan);

		lblOrduaJoan = new JLabel("Ordua");
		lblOrduaJoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrduaJoan.setBounds(71, 123, 46, 14);
		add(lblOrduaJoan);

		dateJoan = new JDateChooser();
		dateJoan.setDateFormatString("dd-MM-yyyy");
		dateJoan.setBounds(127, 87, 127, 20);
		add(dateJoan);

		joanMinutu = new JSpinner();
		joanMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		joanMinutu.setBounds(203, 120, 51, 20);
		add(joanMinutu);
		
		lblEtorria = new JLabel("Etorria");
		lblEtorria.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEtorria.setBounds(28, 170, 89, 21);
		add(lblEtorria);
	}
}