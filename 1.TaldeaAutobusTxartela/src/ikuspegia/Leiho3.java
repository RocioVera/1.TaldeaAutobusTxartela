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
	//panelan ikusten diren bariableak
	private JMenuBar geltoki;
	private JMenu hasierakoGeltokia, amaierakoGeltokia, joanEtorriaMenua;
	private ButtonGroup hasierakoGeltokiaGroup, amaierakoGeltokiaGroup, joanEtorriGroup;
	private JButton btn_next = new JButton("Hurrengoa"),btn_prev = new JButton("Atzera"),restart = new JButton("\u2302"),btnDataEgiaztatu1, btnDataEgiaztatu2;

	private JSpinner etorriaOrdua, etorriaMinutu, joanOrdua, joanMinutu;
	private JLabel lblEtorria, lblJoan, lblDataEtorria, lblDataJoan, lblOrduaJoan, lblOrduaEtorria;
	private JDateChooser dateEtorria = new JDateChooser(), dateJoan = new JDateChooser();
	private JTextFieldDateEditor dataEzEditatu; //kentzeko eskuz sartu ahal izana
	private JRadioButton amaierakoGeltItem_1, amaierakoGeltItem_2, amaierakoGeltItem_3, amaierakoGeltItem_4,
			amaierakoGeltItem_5, amaierakoGeltItem_6, amaierakoGeltItem_7, hasierakoGeltItem_1, hasierakoGeltItem_2, hasierakoGeltItem_3, hasierakoGeltItem_4,
			hasierakoGeltItem_5, hasierakoGeltItem_6, hasierakoGeltItem_7,joan, joanEtorria;

	//bariableak
	private int hasierakoGeltokiaKod, amaierakoGeltokiaKod, ibilbideZbk;
	private ArrayList<Geltokiak> arrayGeltokia = new ArrayList<Geltokiak>();
	private ArrayList<Double> arrayDistantzia = new ArrayList<Double>();
	private double distantziaTermibusetik = 0, altuera1, luzera1, altuera2, luzera2;
	private Date dataJoan, dataEtorri;
	private Hashtable<String, Double> geltokiakOrdenatuta = new Hashtable<String, Double>();

	/**
	 * Hasierako eta amaierako geltokiak, joan/joan etorria, data eta ordua erabaki behar duen panela sortu
	 * @param hartutakoLinea
	 * @param autobusa
	 * @author talde1
	 */
	public Leiho3(String hartutakoLinea, Autobusak autobusa) {
		//panelaren propietateak
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("1.taldearen txartel salmenta");


		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.laugarrenLeihoa(hartutakoLinea, autobusa, ibilbideZbk, hasierakoGeltokiaKod,
						amaierakoGeltokiaKod, altuera1, luzera1, altuera2, luzera2, arrayGeltokia, dataJoan, dataEtorri);
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

		// JMenuak sortu eta sartu aukerak
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

		//ordenatu geltokiak 
		arrayGeltokia = Kontsultak.geltokiakAtera((hartutakoLinea));

		for (int i = 0; i < arrayGeltokia.size(); i++) {
			//"Termibus-Bilbao" desberdin denean 
			if (!arrayGeltokia.get(0).getIzena().equals(arrayGeltokia.get(i).getIzena())) {
				//termibusekoAltuera = arrayGeltokia.get(0).getAltuera()    termibusekoLuzera = arrayGeltokia.get(0).getLuzera()
				distantziaTermibusetik = Metodoak.kalkulatuDistantzia(arrayGeltokia.get(0).getAltuera(), arrayGeltokia.get(0).getLuzera(),
						arrayGeltokia.get(i).getAltuera(), arrayGeltokia.get(i).getLuzera());
				arrayDistantzia.add(distantziaTermibusetik);
				geltokiakOrdenatuta.put(arrayGeltokia.get(i).getIzena(), distantziaTermibusetik);
			}
		}
		Collections.sort(arrayDistantzia);
		geltokiakOrdenatuta.get(arrayGeltokia);
		System.out.println(geltokiakOrdenatuta);

		//pantailaratu geltokiak ordenean
		int luzera = arrayGeltokia.size();
		for (int i = 0; i <= luzera - 1; i++) {
			if (i == 1) {
				hasierakoGeltItem_1 = new JRadioButton(arrayGeltokia.get(0).getIzena());
				hasierakoGeltItem_1.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_1);
				hasierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_1);
						hasierakoGeltokiaKod = arrayGeltokia.get(0).getKodGeltokia();
						altuera1 = arrayGeltokia.get(0).getAltuera();
						luzera1 = arrayGeltokia.get(0).getLuzera();
						amaierakoGeltItem_1.setEnabled(false);
						if (luzera == 2)
							amaierakoGeltItem_2.setEnabled(true);
						else if (luzera == 3) {
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
						} else if (luzera == 4) {
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
						} else if (luzera == 5) {
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
						} else if (luzera == 6) {
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						} else if (luzera == 7) {
							amaierakoGeltItem_2.setEnabled(true);
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
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
						hasierakoGeltokiaKod = arrayGeltokia.get(1).getKodGeltokia();
						altuera1 = arrayGeltokia.get(1).getAltuera();
						luzera1 = arrayGeltokia.get(1).getLuzera();
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						if (luzera == 3) {
							amaierakoGeltItem_3.setEnabled(true);
						} else if (luzera == 4) {
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
						} else if (luzera == 5) {
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
						} else if (luzera == 6) {
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						} else if (luzera == 7) {
							amaierakoGeltItem_3.setEnabled(true);
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
					}
				});
			}

			if (i == 3) {
				hasierakoGeltItem_3 = new JRadioButton(arrayGeltokia.get(2).getIzena());
				hasierakoGeltItem_3.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokiaKod = arrayGeltokia.get(2).getKodGeltokia();
				altuera1 = arrayGeltokia.get(2).getAltuera();
				luzera1 = arrayGeltokia.get(2).getLuzera();
				hasierakoGeltokia.add(hasierakoGeltItem_3);
				hasierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_3);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						if (luzera == 4) {
							amaierakoGeltItem_4.setEnabled(true);
						} else if (luzera == 5) {
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
						} else if (luzera == 6) {
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						} else if (luzera == 7) {
							amaierakoGeltItem_4.setEnabled(true);
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
					}
				});
			}

			if (i == 4) {
				hasierakoGeltItem_4 = new JRadioButton(arrayGeltokia.get(3).getIzena());
				hasierakoGeltItem_4.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_4);
				hasierakoGeltokiaKod = arrayGeltokia.get(3).getKodGeltokia();
				altuera1 = arrayGeltokia.get(3).getAltuera();
				luzera1 = arrayGeltokia.get(3).getLuzera();
				hasierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_4);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						amaierakoGeltItem_4.setEnabled(false);
						if (luzera == 5) {
							amaierakoGeltItem_5.setEnabled(true);
						} else if (luzera == 6) {
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
						} else if (luzera == 7) {
							amaierakoGeltItem_5.setEnabled(true);
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
					}
				});
			}

			if (i == 5) {
				hasierakoGeltItem_5 = new JRadioButton(arrayGeltokia.get(4).getIzena());
				hasierakoGeltItem_5.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokiaKod = arrayGeltokia.get(4).getKodGeltokia();
				altuera1 = arrayGeltokia.get(4).getAltuera();
				luzera1 = arrayGeltokia.get(4).getLuzera();
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
						if (luzera == 6) {
							amaierakoGeltItem_6.setEnabled(true);
						} else if (luzera == 7) {
							amaierakoGeltItem_6.setEnabled(true);
							amaierakoGeltItem_7.setEnabled(true);
						}
						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
					}
				});
			}
			if (i == 6) {
				hasierakoGeltItem_6 = new JRadioButton(arrayGeltokia.get(5).getIzena());
				hasierakoGeltItem_6.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokiaKod = arrayGeltokia.get(5).getKodGeltokia();
				altuera1 = arrayGeltokia.get(5).getAltuera();
				luzera1 = arrayGeltokia.get(5).getLuzera();
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
						if (luzera == 7)
							amaierakoGeltItem_7.setEnabled(true);
						
						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
					}
				});
			}

			if (i == 7) {
				hasierakoGeltItem_7 = new JRadioButton(arrayGeltokia.get(6).getIzena());
				hasierakoGeltItem_7.setFont(new Font("Verdana", Font.BOLD, 12));
				hasierakoGeltokia.add(hasierakoGeltItem_7);
				hasierakoGeltokiaKod = arrayGeltokia.get(6).getKodGeltokia();
				altuera1 = arrayGeltokia.get(6).getAltuera();
				luzera1 = arrayGeltokia.get(6).getLuzera();
				hasierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//amaierako geltokietan zein bai utzi
						amaierakoGeltokia.setEnabled(true);
						hasierakoGeltokiaGroup.add(hasierakoGeltItem_7);
						amaierakoGeltItem_1.setEnabled(false);
						amaierakoGeltItem_2.setEnabled(false);
						amaierakoGeltItem_3.setEnabled(false);
						amaierakoGeltItem_4.setEnabled(false);
						amaierakoGeltItem_5.setEnabled(false);
						amaierakoGeltItem_6.setEnabled(false);
						amaierakoGeltItem_7.setEnabled(false);

						//aurretik jarri baldin badu berriz hasteko
						joanEtorriaMenua.setEnabled(false);
						lblJoan.setVisible(false);
						lblDataJoan.setVisible(false);
						lblOrduaJoan.setVisible(false);
						dateJoan.setVisible(false);
						joanMinutu.setVisible(false);
						joanOrdua.setVisible(false);

						lblEtorria.setVisible(false);
						lblDataEtorria.setVisible(false);
						lblOrduaEtorria.setVisible(false);
						dateEtorria.setVisible(false);
						etorriaMinutu.setVisible(false);
						etorriaOrdua.setVisible(false);
						btnDataEgiaztatu2.setVisible(false);
						btnDataEgiaztatu1.setVisible(false);
					}
				});
			}
		}

		// amaierako geltokiak atera
		for (int i = 0; i <= arrayGeltokia.size(); i++) {
			if (i == 1) {
				amaierakoGeltItem_1 = new JRadioButton(arrayGeltokia.get(0).getIzena());
				amaierakoGeltItem_1.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_1);
				amaierakoGeltokiaKod = arrayGeltokia.get(0).getKodGeltokia();
				altuera2 = arrayGeltokia.get(0).getAltuera();
				luzera2 = arrayGeltokia.get(0).getLuzera();

				amaierakoGeltItem_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_1);
					}
				});
			}

			if (i == 2) {
				amaierakoGeltItem_2 = new JRadioButton(arrayGeltokia.get(1).getIzena());
				amaierakoGeltItem_2.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_2);
				amaierakoGeltokiaKod = arrayGeltokia.get(1).getKodGeltokia();
				altuera2 = arrayGeltokia.get(1).getAltuera();
				luzera2 = arrayGeltokia.get(1).getLuzera();
				amaierakoGeltItem_2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_2);
					}
				});
			}

			if (i == 3) {
				amaierakoGeltItem_3 = new JRadioButton(arrayGeltokia.get(2).getIzena());
				amaierakoGeltItem_3.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_3);
				amaierakoGeltokiaKod = arrayGeltokia.get(2).getKodGeltokia();
				altuera2 = arrayGeltokia.get(2).getAltuera();
				luzera2 = arrayGeltokia.get(2).getLuzera();
				amaierakoGeltItem_3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_3);
					}
				});
			}

			if (i == 4) {
				amaierakoGeltItem_4 = new JRadioButton(arrayGeltokia.get(3).getIzena());
				amaierakoGeltItem_4.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_4);
				amaierakoGeltokiaKod = arrayGeltokia.get(3).getKodGeltokia();
				altuera2 = arrayGeltokia.get(3).getAltuera();
				luzera2 = arrayGeltokia.get(3).getLuzera();
				amaierakoGeltItem_4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_4);
					}
				});
			}

			if (i == 5) {
				amaierakoGeltItem_5 = new JRadioButton(arrayGeltokia.get(4).getIzena());
				amaierakoGeltItem_5.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_5);
				amaierakoGeltokiaKod = arrayGeltokia.get(4).getKodGeltokia();
				altuera2 = arrayGeltokia.get(4).getAltuera();
				luzera2 = arrayGeltokia.get(4).getLuzera();
				amaierakoGeltItem_5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_5);

					}
				});
			}

			if (i == 6) {
				amaierakoGeltItem_6 = new JRadioButton(arrayGeltokia.get(5).getIzena());
				amaierakoGeltItem_6.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_6);
				amaierakoGeltokiaKod = arrayGeltokia.get(5).getKodGeltokia();
				altuera2 = arrayGeltokia.get(5).getAltuera();
				luzera2 = arrayGeltokia.get(5).getLuzera();
				amaierakoGeltItem_6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_6);
					}
				});
			}

			if (i == 7) {
				amaierakoGeltItem_7 = new JRadioButton(arrayGeltokia.get(6).getIzena());
				amaierakoGeltItem_7.setFont(new Font("Verdana", Font.BOLD, 12));
				amaierakoGeltokia.add(amaierakoGeltItem_7);
				amaierakoGeltokiaKod = arrayGeltokia.get(6).getKodGeltokia();
				altuera2 = arrayGeltokia.get(6).getAltuera();
				luzera2 = arrayGeltokia.get(6).getLuzera();
				amaierakoGeltItem_7.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						joanEtorriaMenua.setEnabled(true);
						amaierakoGeltokiaGroup.add(amaierakoGeltItem_7);
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

		//joateko bidaia bakarrik eguna eta ordua erabaki
		joan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ibilbideZbk = 1;
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
				btnDataEgiaztatu1.setVisible(true);
				btnDataEgiaztatu2.setVisible(false);
				btn_next.setVisible(false);

				etorriaMinutu.setValue(0);
				etorriaOrdua.setValue(0);
			}
		});

		// joan propietateak
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

		dateJoan.setDateFormatString("yyyy-MM-dd");
		dateJoan.setBounds(190, 142, 127, 20);
		dataEzEditatu = (JTextFieldDateEditor) dateJoan.getDateEditor();
		dataEzEditatu.setEditable(false);

		dateJoan.setVisible(false);
		dateJoan.getJCalendar().setMinSelectableDate(new Date());
		getContentPane().add(dateJoan);

		joanMinutu = new JSpinner();
		joanMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		joanMinutu.setBounds(258, 176, 51, 20);
		joanMinutu.setVisible(false);
		getContentPane().add(joanMinutu);

		joanOrdua = new JSpinner();
		joanOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		joanOrdua.setBounds(192, 176, 51, 20);
		joanOrdua.setVisible(false);
		getContentPane().add(joanOrdua);

		//joan eta etorria bidaia eguna eta ordua erabaki
		joanEtorria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ibilbideZbk = 2;
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
				btnDataEgiaztatu2.setVisible(true);
				btnDataEgiaztatu1.setVisible(false);
				btn_next.setVisible(false);

			}
		});

		// joan-etorri propietateak
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

		dateEtorria.setDateFormatString("yyyy-MM-dd");
		dateEtorria.setBounds(190, 265, 127, 20);
		dateEtorria.setVisible(false);
		dataEzEditatu = (JTextFieldDateEditor) dateEtorria.getDateEditor();
		dataEzEditatu.setEditable(false);
		getContentPane().add(dateEtorria);

		etorriaMinutu = new JSpinner();
		etorriaMinutu.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		etorriaMinutu.setBounds(266, 300, 51, 20);
		etorriaMinutu.setVisible(false);
		getContentPane().add(etorriaMinutu);

		etorriaOrdua = new JSpinner();
		etorriaOrdua.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		etorriaOrdua.setBounds(200, 300, 51, 20);
		etorriaOrdua.setVisible(false);
		getContentPane().add(etorriaOrdua);

		btnDataEgiaztatu1 = new JButton("Data egiaztatu");
		btnDataEgiaztatu1.setBounds(423, 421, 122, 25);
		btnDataEgiaztatu1.setVisible(false);
		getContentPane().add(btnDataEgiaztatu1);

		btnDataEgiaztatu2 = new JButton("Data egiaztatu");
		btnDataEgiaztatu2.setBounds(423, 421, 122, 25);
		btnDataEgiaztatu2.setVisible(false);
		getContentPane().add(btnDataEgiaztatu2);

		//gaurtik aurreko egunak bakarrik utzi 
		dateJoan.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataJoan = (Date) dateJoan.getDate();
				dataEtorri = (java.sql.Date) dateEtorria.getDate();
				dateEtorria.setEnabled(true);
				dateEtorria.getDateEditor().setSelectableDateRange(dataJoan, null);;
			}
		});
		//joango den egunetik egunak bakarrik utzi 
		dateEtorria.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataJoan = (Date) dateJoan.getDate();
				dateEtorria.getDateEditor().setSelectableDateRange(dataJoan, null);;

				if (dataJoan == null) {
					dateEtorria.setEnabled(false);
					dateEtorria.getJCalendar().setMinSelectableDate(new Date());
					dateEtorria.getJCalendar().setMaxSelectableDate(new Date());
				} else {
					dateEtorria.getJCalendar().setMinSelectableDate(dataJoan);
					dateEtorria.getJCalendar().setMaxSelectableDate(null);
				}
			}
		});

		//joan beteta dagoenean
		btnDataEgiaztatu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataJoan = dateJoan.getDate();
				if (dataJoan != null) {
					btn_next.setVisible(true);
				}
			}
		});

		//joan eta joan-etorria beteta dagoenean
		btnDataEgiaztatu2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataJoan = dateJoan.getDate();
				dataEtorri = dateEtorria.getDate();

				if (dataJoan != null && dataEtorri != null) {
					btn_next.setVisible(true);
				}
			}
		});

	}
}
