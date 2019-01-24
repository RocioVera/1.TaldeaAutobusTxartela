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
	private JLabel lblEtorria;
	private JLabel lblDataEtorria;
	private JLabel lblDataJoan;
	private JLabel lblOrduaJoan;
	private JLabel lblOrduaEtorria;
	private JSpinner etorriaOrdua;
	private JSpinner etorriaMinutu;
	private JMenuBar geltoki;
	private JMenu hasierakoGeltokia;
	private JMenu amaierakoGeltokia;
	private JMenu joanEtorri;
	private JCheckBoxMenuItem Joan;
	private CheckboxGroup hasierakoGeltokiaGroup;
	private CheckboxGroup amaierakoGeltokiaGroup;
	private CheckboxGroup joanEtorriGroup;
	private ArrayList<Geltokiak> arrayparada;
	private JDateChooser dateJoan;
	private JSpinner joanOrdua;
	private JSpinner joanMinutu;
	private JDateChooser dateEtorria;
	private JCheckBoxMenuItem amaierakoGeltItem_1;
	private JCheckBoxMenuItem amaierakoGeltItem_2;
	private JCheckBoxMenuItem amaierakoGeltItem_3;
	private JCheckBoxMenuItem amaierakoGeltItem_4;
	private JCheckBoxMenuItem amaierakoGeltItem_5;
	private JCheckBoxMenuItem amaierakoGeltItem_6;
	private JCheckBoxMenuItem amaierakoGeltItem_7;
	private JCheckBoxMenuItem hasierakoGeltItem_1;
	private JCheckBoxMenuItem hasierakoGeltItem_2;
	private JCheckBoxMenuItem hasierakoGeltItem_3;
	private JCheckBoxMenuItem hasierakoGeltItem_4;
	private JCheckBoxMenuItem hasierakoGeltItem_5;
	private JCheckBoxMenuItem hasierakoGeltItem_6;
	private JCheckBoxMenuItem hasierakoGeltItem_7;

	JButton btn_next = new JButton("Hurrengoa");
	JButton btn_prev = new JButton("Atzera");
	JButton restart = new JButton("\u2302");

	public Leiho3() {
		getContentPane().setLayout(null);
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
		JCheckBoxMenuItem joanEtorria = new JCheckBoxMenuItem("Joan/Etorria");
		joanEtorria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Frame.btn_next.setVisible(true);
				lblEtorria = new JLabel("Etorria");
				lblEtorria.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblEtorria.setBounds(28, 170, 89, 21);
				getContentPane().add(lblEtorria);

				lblDataEtorria = new JLabel("Data");
				lblDataEtorria.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblDataEtorria.setBounds(71, 204, 46, 21);
				getContentPane().add(lblDataEtorria);

				lblOrduaEtorria = new JLabel("Ordua");
				lblOrduaEtorria.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblOrduaEtorria.setBounds(71, 244, 46, 14);
				getContentPane().add(lblOrduaEtorria);

				dateEtorria = new JDateChooser();
				dateEtorria.setDateFormatString("dd-MM-yyyy");
				dateEtorria.setBounds(127, 204, 127, 20);
				getContentPane().add(dateEtorria);

				etorriaOrdua = new JSpinner();
				etorriaOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
				etorriaOrdua.setBounds(127, 243, 51, 20);
				getContentPane().add(etorriaOrdua);

				etorriaMinutu = new JSpinner();
				etorriaMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
				etorriaMinutu.setBounds(203, 243, 51, 20);
				getContentPane().add(etorriaMinutu);
			}
		});
		Joan = new JCheckBoxMenuItem("Joan");
		Joan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Frame.btn_next.setVisible(true);
			}
		});
		joanEtorri.setEnabled(false);

		hasierakoGeltokiaGroup = new CheckboxGroup();
		amaierakoGeltokiaGroup = new CheckboxGroup();
		joanEtorriGroup = new CheckboxGroup();

		arrayparada = new ArrayList<Geltokiak>();
		arrayparada = Kontsultak.geltokiakAtera(("L2"));

		for (int i = 0; i <= arrayparada.size(); i++) {
			if (i == 1) {
				hasierakoGeltItem_1 = new JCheckBoxMenuItem(arrayparada.get(0).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_1);
				hasierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}

			if (i == 2) {
				hasierakoGeltItem_2 = new JCheckBoxMenuItem(arrayparada.get(1).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_2);
				hasierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}

			if (i == 3) {
				hasierakoGeltItem_3 = new JCheckBoxMenuItem(arrayparada.get(2).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_3);
				hasierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}

			if (i == 4) {
				hasierakoGeltItem_4 = new JCheckBoxMenuItem(arrayparada.get(3).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_4);
				hasierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}

			if (i == 5) {
				hasierakoGeltItem_5 = new JCheckBoxMenuItem(arrayparada.get(4).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_5);
				hasierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}
			if (i == 6) {
				hasierakoGeltItem_6 = new JCheckBoxMenuItem(arrayparada.get(5).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_6);
				hasierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}

			if (i == 7) {
				hasierakoGeltItem_7 = new JCheckBoxMenuItem(arrayparada.get(6).getIzena());
				hasierakoGeltokia.add(hasierakoGeltItem_7);
				hasierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
					}
				});
			}
		}

		// amaierako geltokia
		for (int i = 0; i <= arrayparada.size(); i++) {
			if (i == 1) {

				amaierakoGeltItem_1 = new JCheckBoxMenuItem(arrayparada.get(0).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_1);
				amaierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
					}
				});
			}

			if (i == 2) {
				amaierakoGeltItem_2 = new JCheckBoxMenuItem(arrayparada.get(1).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_2);
				amaierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
					}
				});
			}

			if (i == 3) {
				amaierakoGeltItem_3 = new JCheckBoxMenuItem(arrayparada.get(2).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_3);
				amaierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
					}
				});
			}

			if (i == 4) {
				amaierakoGeltItem_4 = new JCheckBoxMenuItem(arrayparada.get(3).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_4);
				amaierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);

					}
				});
			}

			if (i == 5) {
				amaierakoGeltItem_5 = new JCheckBoxMenuItem(arrayparada.get(4).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_5);
				amaierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);

					}
				});
			}

			if (i == 6) {
				amaierakoGeltItem_6 = new JCheckBoxMenuItem(arrayparada.get(5).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_6);
				amaierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
					}
				});
			}

			if (i == 7) {
				amaierakoGeltItem_7 = new JCheckBoxMenuItem(arrayparada.get(6).getIzena());
				amaierakoGeltokia.add(amaierakoGeltItem_7);
				amaierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorri.setEnabled(true);
					}
				});
			}
		}

		geltoki.setBounds(0, 0, 600, 21);
		getContentPane().add(geltoki);

		geltoki.add(hasierakoGeltokia);
		geltoki.add(amaierakoGeltokia);

		geltoki.add(joanEtorri);
		joanEtorri.add(joanEtorria);
		joanEtorri.add(Joan);

		JLabel lblJoan = new JLabel("Joan");
		lblJoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoan.setBounds(28, 61, 89, 21);
		getContentPane().add(lblJoan);

		JLabel lblData;
		lblDataJoan = new JLabel("Data");
		lblDataJoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataJoan.setBounds(71, 86, 46, 21);
		getContentPane().add(lblDataJoan);

		JLabel lblOrdua_1;
		lblOrduaJoan = new JLabel("Ordua");
		lblOrduaJoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrduaJoan.setBounds(71, 123, 46, 14);
		getContentPane().add(lblOrduaJoan);

		dateJoan = new JDateChooser();
		dateJoan.setDateFormatString("dd-MM-yyyy");
		dateJoan.setBounds(127, 87, 127, 20);
		getContentPane().add(dateJoan);

		joanOrdua = new JSpinner();
		joanOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		joanOrdua.setBounds(127, 120, 51, 20);
		getContentPane().add(joanOrdua);

		joanMinutu = new JSpinner();
		joanMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		joanMinutu.setBounds(203, 120, 51, 20);
		getContentPane().add(joanMinutu);
	}
}