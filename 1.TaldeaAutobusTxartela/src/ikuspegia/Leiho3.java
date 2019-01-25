package ikuspegia;
//mirar lo de los group

import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
	private JMenu joanEtorriaMenua;
	private ButtonGroup hasierakoGeltokiaGroup;
	private ButtonGroup amaierakoGeltokiaGroup;
	private ButtonGroup joanEtorriGroup;
	private JTextFieldDateEditor editor;
	private JFormattedTextField spinner;

	private JSpinner etorriaOrdua;
	private JSpinner etorriaMinutu;
	private JSpinner joanOrdua;
	private JSpinner joanMinutu;
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
	private JRadioButton joan;
	private JRadioButton joanEtorria;

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
				if (dateJoan != null) {
					Metodoak.laugarrenLeihoa(hartutakoLinea);
					dispose();
	               }
				Metodoak.laugarrenLeihoa(hartutakoLinea);
				dispose();
			}
			//adios tximuelo
		});
		
		btn_next.setBounds(423, 500, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setEnabled(false);
		getContentPane().add(btn_next);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bigarrenLeihoa();
				dispose();
			}
		});
		btn_prev.setBounds(38, 500, 99, 32);
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		getContentPane().add(btn_prev);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(245, 500, 72, 32);
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

		for (int i = 0; i <= arrayGeltokia.size(); i++) {
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
//						amaierakoGeltItem_2.setEnabled(true);
//						amaierakoGeltItem_3.setEnabled(true);
//						amaierakoGeltItem_4.setEnabled(true);
//						amaierakoGeltItem_5.setEnabled(true);
//						amaierakoGeltItem_6.setEnabled(true);
//						amaierakoGeltItem_7.setEnabled(true);

						// Metodoak.geltokiakMarkatu(JRadioButton );
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
//						amaierakoGeltItem_3.setEnabled(true);
//						amaierakoGeltItem_4.setEnabled(true);
//						amaierakoGeltItem_5.setEnabled(true);
//						amaierakoGeltItem_6.setEnabled(true);
//						amaierakoGeltItem_7.setEnabled(true);
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
//						amaierakoGeltItem_4.setEnabled(true);
//						amaierakoGeltItem_5.setEnabled(true);
//						amaierakoGeltItem_6.setEnabled(true);
//						amaierakoGeltItem_7.setEnabled(true);
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
//						amaierakoGeltItem_5.setEnabled(true);
//						amaierakoGeltItem_6.setEnabled(true);
//						amaierakoGeltItem_7.setEnabled(true);
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
//						amaierakoGeltItem_6.setEnabled(true);
//						amaierakoGeltItem_7.setEnabled(true);
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
//						amaierakoGeltItem_7.setEnabled(true);
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
		
		// joanEtorriaMenua.add(joanEtorria);

		joan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// joanEtorriaMenua.setEnabled(true);
				// amaierakoGeltokiaGroup.add(hasierakoGeltItem_7); 
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
				
				editor.setValue(0);
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

		dateJoan = new JDateChooser();
		dateJoan.setDateFormatString("dd-MM-yyyy");
		dateJoan.setBounds(190, 142, 127, 20);
		editor = (JTextFieldDateEditor) dateJoan.getDateEditor();
		editor.setEditable(false);
		dateJoan.setVisible(false);
		getContentPane().add(dateJoan);

		joanMinutu = new JSpinner();
		joanMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		joanMinutu.setBounds(258, 176, 51, 20);
	    spinner = ((JSpinner.DefaultEditor) joanMinutu.getEditor()).getTextField();
	    spinner.setEditable(false);
	    joanMinutu.setVisible(false);
		getContentPane().add(joanMinutu);

		joanOrdua = new JSpinner();
		joanOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		joanOrdua.setBounds(192, 176, 51, 20);
	    spinner = ((JSpinner.DefaultEditor) joanOrdua.getEditor()).getTextField();
	    spinner.setEditable(false);
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

		dateEtorria = new JDateChooser();
		dateEtorria.setDateFormatString("dd-MM-yyyy");
		dateEtorria.setBounds(190, 265, 127, 20);
		editor = (JTextFieldDateEditor) dateEtorria.getDateEditor();
		editor.setEditable(false);
		dateEtorria.setVisible(false);
		getContentPane().add(dateEtorria);

		etorriaMinutu = new JSpinner();
		etorriaMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		etorriaMinutu.setBounds(266, 300, 51, 20);
	    spinner = ((JSpinner.DefaultEditor) etorriaMinutu.getEditor()).getTextField();
	    spinner.setEditable(false);
		etorriaMinutu.setVisible(false);
		getContentPane().add(etorriaMinutu);

		etorriaOrdua = new JSpinner();
		etorriaOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		etorriaOrdua.setBounds(200, 300, 51, 20);
	    spinner = ((JSpinner.DefaultEditor) etorriaOrdua.getEditor()).getTextField();
	    spinner.setEditable(false);
		etorriaOrdua.setVisible(false);
		getContentPane().add(etorriaOrdua);
	
        //listener
		dateJoan.getDateEditor().addPropertyChangeListener(
	    new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent e) {
	        	 if (dateJoan != null) {
	            	   btn_next.setEnabled(true);
	               }
	        }
	    });
	
}
	
}
