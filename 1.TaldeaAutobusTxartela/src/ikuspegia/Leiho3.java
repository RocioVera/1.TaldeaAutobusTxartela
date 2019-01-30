package ikuspegia;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.*;

import eredua.*;
import kontrolatzailea.*;

public class Leiho3 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar geltoki;
	private JMenu hasierakoGeltokia, amaierakoGeltokia, joanEtorriaMenua;
	private ButtonGroup hasierakoGeltokiaGroup,amaierakoGeltokiaGroup, joanEtorriGroup;
	private JTextFieldDateEditor editor;
	private JFormattedTextField spinnerEditatu;

	private JSpinner etorriaOrdua, etorriaMinutu, joanOrdua, joanMinutu;
	private JLabel lblEtorria, lblJoan, lblDataEtorria, lblDataJoan, lblOrduaJoan, lblOrduaEtorria;
	private JDateChooser dateEtorria = new JDateChooser("yyyy-MM-dd","####/##/##",'_');
	private JDateChooser dateJoan = new JDateChooser("yyyy-MM-dd","####/##/##",'_');

	private JRadioButton amaierakoGeltItem_1, amaierakoGeltItem_2, amaierakoGeltItem_3, amaierakoGeltItem_4, amaierakoGeltItem_5, amaierakoGeltItem_6, amaierakoGeltItem_7;
	private JRadioButton hasierakoGeltItem_1, hasierakoGeltItem_2, hasierakoGeltItem_3, hasierakoGeltItem_4, hasierakoGeltItem_5, hasierakoGeltItem_6, hasierakoGeltItem_7;
	private JRadioButton joan, joanEtorria;

	private JButton btn_next = new JButton("Hurrengoa");
	private JButton btn_prev = new JButton("Atzera");
	private JButton restart = new JButton("\u2302");

	public Leiho3(ArrayList<Geltokiak> arrayGeltokia, String hartutakoLinea) {
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.laugarrenLeihoa(hartutakoLinea);
				dispose();
			}
		});
		btn_next.setBounds(423, 500, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		btn_next.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btn_next);
		btn_next.setVisible(false);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bigarrenLeihoa();
				dispose();
			}
		});
		btn_prev.setBounds(38, 500, 99, 32);
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btn_prev);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(245, 500, 72, 32);
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);

		// pantaila
		geltoki = new JMenuBar();

		hasierakoGeltokia = new JMenu("    Hasierako geltokia    ");
		hasierakoGeltokia.setFont(new Font("Verdana", Font.PLAIN, 16));
		amaierakoGeltokia = new JMenu("     Amaierako geltokia    ");
		amaierakoGeltokia.setFont(new Font("Verdana", Font.PLAIN, 16));
		amaierakoGeltokia.setEnabled(false);

		joanEtorriaMenua = new JMenu("     Joan/Etorria     ");
		joanEtorriaMenua.setEnabled(false);
		joanEtorriaMenua.setFont(new Font("Verdana", Font.PLAIN, 16));

		joanEtorria = new JRadioButton("Joan/Etorria");
		joanEtorria.setFont(new Font("Verdana", Font.BOLD, 12));
		joanEtorriaMenua.add(joanEtorria);

		joan = new JRadioButton("Joan");
		joan.setFont(new Font("Verdana", Font.BOLD, 12));
		joanEtorriaMenua.add(joan);

		hasierakoGeltokiaGroup = new ButtonGroup();
		amaierakoGeltokiaGroup = new ButtonGroup();
		joanEtorriGroup = new ButtonGroup();

		// ArrayList <Geltokiak> arrayparada = new ArrayList<Geltokiak>();
		arrayGeltokia = Kontsultak.geltokiakAtera((hartutakoLinea));
		int luzera=arrayGeltokia.size();
		for (int i = 0; i <= luzera-1; i++) {
			if (i == 1) {
				hasierakoGeltItem_1 = new JRadioButton(arrayGeltokia.get(0).getIzena());
				hasierakoGeltItem_1.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_1);
				hasierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_1);
						amaierakoGeltItem_1.setEnabled(false);
						if (luzera==2)
							amaierakoGeltItem_2.setEnabled(true);
						else if (luzera==3) {
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							}
						else if (luzera==4){
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							}
						else if (luzera==5){
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
						}
						else if (luzera==6){
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						}
						else if (luzera==7){
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
					}
				});
			}

			if (i == 2) {
				hasierakoGeltItem_2 = new JRadioButton(arrayGeltokia.get(1).getIzena());
				hasierakoGeltItem_2.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_2);
				hasierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_2);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						if (luzera==3) {
							amaierakoGeltItem_3.setEnabled(true);
							}
						else if (luzera==4){
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							}
						else if (luzera==5){
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
						}
						else if (luzera==6){
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						}
						else if (luzera==7){
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
					}
				});
			}

			if (i == 3) {
				hasierakoGeltItem_3 = new JRadioButton(arrayGeltokia.get(2).getIzena());
				hasierakoGeltItem_3.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_3);
				hasierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_3);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						if (luzera==4){
							amaierakoGeltItem_4.setEnabled(true);
							}
						else if (luzera==5){
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
						}
						else if (luzera==6){
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						}
						else if (luzera==7){
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
					}
				});
			}

			if (i == 4) {
				hasierakoGeltItem_4 = new JRadioButton(arrayGeltokia.get(3).getIzena());
				hasierakoGeltItem_4.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_4);
				hasierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_4);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						amaierakoGeltItem_4.setEnabled(false);
						if (luzera==5){
							amaierakoGeltItem_5.setEnabled(true);
						}
						else if (luzera==6){
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						}
						else if (luzera==7){
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
					}
				});
			}

			if (i == 5) {
				hasierakoGeltItem_5 = new JRadioButton(arrayGeltokia.get(4).getIzena());
				hasierakoGeltItem_5.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_5);
				hasierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_5);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						amaierakoGeltItem_4.setEnabled(false);
						amaierakoGeltItem_5.setEnabled(false);
						if (luzera==6){
							amaierakoGeltItem_6.setEnabled(true);
						}
						else if (luzera==7){
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
					}
				});
			}
			if (i == 6) {
				hasierakoGeltItem_6 = new JRadioButton(arrayGeltokia.get(5).getIzena());
				hasierakoGeltItem_6.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_6);
				hasierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_6);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						amaierakoGeltItem_4.setEnabled(false);
						amaierakoGeltItem_5.setEnabled(false);
						amaierakoGeltItem_6.setEnabled(false);
						if (luzera==7)
							amaierakoGeltItem_7.setEnabled(true);
					}
				});
			}

			if (i == 7) {
				hasierakoGeltItem_7 = new JRadioButton(arrayGeltokia.get(6).getIzena());
				hasierakoGeltItem_7.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_7);
				hasierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_7);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						amaierakoGeltItem_4.setEnabled(false);
						amaierakoGeltItem_5.setEnabled(false);
						amaierakoGeltItem_6.setEnabled(false);
						amaierakoGeltItem_7.setEnabled(false);
					}
				});
			}
		}

		// amaierako geltokia
		for (int i = 0; i <= arrayGeltokia.size(); i++) {
			if (i == 1) {
				amaierakoGeltItem_1 = new JRadioButton(arrayGeltokia.get(0).getIzena());
				amaierakoGeltItem_1.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_1);
				amaierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_1);
					}
				});
			}

			if (i == 2) {
				amaierakoGeltItem_2 = new JRadioButton(arrayGeltokia.get(1).getIzena());
				amaierakoGeltItem_2.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_2);
				amaierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_2);
					}
				});
			}

			if (i == 3) {
				amaierakoGeltItem_3 = new JRadioButton(arrayGeltokia.get(2).getIzena());
				amaierakoGeltItem_3.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_3);
				amaierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_3);
					}
				});
			}

			if (i == 4) {
				amaierakoGeltItem_4 = new JRadioButton(arrayGeltokia.get(3).getIzena());
				amaierakoGeltItem_4.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_4);
				amaierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_4);
					}
				});
			}

			if (i == 5) {
				amaierakoGeltItem_5 = new JRadioButton(arrayGeltokia.get(4).getIzena());
				amaierakoGeltItem_5.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_5);
				amaierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_5);

					}
				});
			}

			if (i == 6) {
				amaierakoGeltItem_6 = new JRadioButton(arrayGeltokia.get(5).getIzena());
				amaierakoGeltItem_6.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_6);
				amaierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_6);
					}
				});
			}

			if (i == 7) {
				amaierakoGeltItem_7 = new JRadioButton(arrayGeltokia.get(6).getIzena());
				amaierakoGeltItem_7.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_7);
				amaierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(hasierakoGeltItem_7);
					}
				});
			}
		}

		geltoki.setBounds(0, 0, 600, 30);
		getContentPane().add(geltoki);

		geltoki.add(hasierakoGeltokia);
		geltoki.add(amaierakoGeltokia);
		geltoki.add(joanEtorriaMenua);

		joanEtorriGroup.add(joan);
		joanEtorriGroup.add(joanEtorria);

		joan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblJoan.setVisible(true);
				lblDataJoan.setVisible(true);
				lblOrduaJoan.setVisible(true);
				dateJoan.setVisible(true);
				joanMinutu.setVisible(true);
				joanOrdua.setVisible(true);

				lblEtorria.setVisible(false);
				lblDataEtorria.setVisible(false);
				lblOrduaEtorria.setVisible(false);
				dateEtorria.setVisible(false);
				etorriaMinutu.setVisible(false);
				etorriaOrdua.setVisible(false);

				etorriaMinutu.setValue(0);
				etorriaOrdua.setValue(0);
			}
		});

		// bakarrik joan
		lblJoan = new JLabel("Joan");
		lblJoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJoan.setBounds(71, 108, 51, 21);
		lblJoan.setVisible(false);
		getContentPane().add(lblJoan);

		lblDataJoan = new JLabel("Data");
		lblDataJoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataJoan.setBounds(134, 142, 46, 21);

		lblDataJoan.setVisible(false);
		getContentPane().add(lblDataJoan);

		lblOrduaJoan = new JLabel("Ordua");
		lblOrduaJoan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrduaJoan.setBounds(134, 176, 46, 14);
		lblOrduaJoan.setVisible(false);
		getContentPane().add(lblOrduaJoan);
		
		dateJoan.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_next.setVisible(true);
			}
		});
		dateJoan.setDateFormatString("yyyy-MM-dd");
		dateJoan.setBounds(190, 142, 127, 20);
		dateJoan.setVisible(false);
		getContentPane().add(dateJoan);

		joanMinutu = new JSpinner();
		joanMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		joanMinutu.setBounds(258, 176, 51, 20);
		spinnerEditatu = ((JSpinner.DefaultEditor) joanMinutu.getEditor()).getTextField();
		spinnerEditatu.setEditable(false);
		joanMinutu.setVisible(false);
		getContentPane().add(joanMinutu);

		joanOrdua = new JSpinner();
		joanOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		joanOrdua.setBounds(192, 176, 51, 20);
		spinnerEditatu = ((JSpinner.DefaultEditor) joanOrdua.getEditor()).getTextField();
		spinnerEditatu.setEditable(false);
		joanOrdua.setVisible(false);
		getContentPane().add(joanOrdua);

		joanEtorria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblJoan.setVisible(true);
				lblDataJoan.setVisible(true);
				lblOrduaJoan.setVisible(true);
				dateJoan.setVisible(true);
				joanMinutu.setVisible(true);
				joanOrdua.setVisible(true);

				lblEtorria.setVisible(true);
				lblDataEtorria.setVisible(true);
				lblOrduaEtorria.setVisible(true);
				dateEtorria.setVisible(true);
				etorriaMinutu.setVisible(true);
				etorriaOrdua.setVisible(true);

			}
		});

		// joan etorria klik egitean aktibatzeko
		lblEtorria = new JLabel("Etorria");
		lblEtorria.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEtorria.setBounds(71, 222, 89, 21);
		lblEtorria.setVisible(false);
		getContentPane().add(lblEtorria);

		lblDataEtorria = new JLabel("Data");
		lblDataEtorria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataEtorria.setBounds(134, 265, 46, 21);
		lblDataEtorria.setVisible(false);
		getContentPane().add(lblDataEtorria);

		lblOrduaEtorria = new JLabel("Ordua");
		lblOrduaEtorria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrduaEtorria.setBounds(134, 300, 46, 21);
		lblOrduaEtorria.setVisible(false);
		getContentPane().add(lblOrduaEtorria);

		dateEtorria.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_next.setVisible(true);
			}
		});
		dateEtorria.setDateFormatString("yyyy-MM-dd");
		dateEtorria.setBounds(190, 265, 127, 20);
		dateEtorria.setVisible(false);
		getContentPane().add(dateEtorria);

		etorriaMinutu = new JSpinner();
		etorriaMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		etorriaMinutu.setBounds(266, 300, 51, 20);
		spinnerEditatu = ((JSpinner.DefaultEditor) etorriaMinutu.getEditor()).getTextField();
		spinnerEditatu.setEditable(false);
		etorriaMinutu.setVisible(false);
		getContentPane().add(etorriaMinutu);

		etorriaOrdua = new JSpinner();
		etorriaOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		etorriaOrdua.setBounds(200, 300, 51, 20);
		spinnerEditatu = ((JSpinner.DefaultEditor) etorriaOrdua.getEditor()).getTextField();
		spinnerEditatu.setEditable(false);
		etorriaOrdua.setVisible(false);
		getContentPane().add(etorriaOrdua);

	}

}
