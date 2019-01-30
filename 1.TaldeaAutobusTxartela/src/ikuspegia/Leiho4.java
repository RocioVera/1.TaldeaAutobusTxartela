package ikuspegia;

import java.awt.*;
import javax.swing.*;
import kontrolatzailea.*;
import java.awt.event.*;
import java.util.Date;

import com.toedter.calendar.*;

public class Leiho4 extends JFrame {
	private static final long serialVersionUID = 1L;
	static JTextField txtPrezioTot = new JTextField();
	private JTextField txtNan = new JTextField(), txtIzena = new JTextField(), txtAbizenak = new JTextField(),
			txtSexua = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblPrezioTotala, lblNan, lblPasahitza, lblIzena, lblAbizenak, lblJaioData, lblSexua,
			lblErroreakonektatu, lblKonekBezeroMezua;
	private JButton btnHasiSaioa;
	private JButton btnKonektatu = new JButton("Konektatu");
	private JButton btnErregistratuNahi = new JButton("Erregistratu");
	private JButton btnErregistratu = new JButton("Erregistratu");

	private JButton btn_next = new JButton("Hurrengoa");
	private JButton btn_prev = new JButton("Atzera");
	private JButton restart = new JButton("\u2302");
	private String pasahitza, nan, izena, abizenak, sexua, guztiraPrez;
	private Date jaioData;
	private boolean balPasa, balNan, balErregis;
	private int nanLuzera = 8, izenLuzera = 49, abizenLuzera = 99, pasahitzLuzera = 49, sexuLuzera = 0, jaioDataLuzera=9;
	private char letra;
	private JDateChooser txtJaioData = new JDateChooser("yyyy-MM-dd","####/##/##",'_');

	public Leiho4(String hartutakoLinea) {
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));		

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bostgarrenLeihoa(hartutakoLinea);
				dispose();
			}
		});
		btn_next.setBounds(423, 500, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.hirugarrenLeihoa(hartutakoLinea);
				dispose();
			}
		});
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBounds(38, 500, 99, 32);
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
		getContentPane().add(restart);

		lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrezioTotala.setBounds(157, 37, 117, 20);
		getContentPane().add(lblPrezioTotala);

		txtPrezioTot.setEditable(false);
		txtPrezioTot.setColumns(10);
		txtPrezioTot.setBounds(281, 37, 86, 20);
		
//		guztiraPrez = Metodoak.kalkPrezioa();
		txtPrezioTot.setText(guztiraPrez + " €");
		getContentPane().add(txtPrezioTot);
		btn_next.setVisible(false);

		btnKonektatu.setVisible(false);
		lblNan = new JLabel("NAN:");
		lblPasahitza = new JLabel("Pasahitza:");

		lblKonekBezeroMezua = new JLabel("Hasi saioa edo erregistratu");
		lblKonekBezeroMezua.setForeground(Color.BLUE);
		lblKonekBezeroMezua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKonekBezeroMezua.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		lblKonekBezeroMezua.setBounds(122, 74, 328, 25);
		getContentPane().add(lblKonekBezeroMezua);

		btnErregistratu.setVisible(false);
		
		btnHasiSaioa = new JButton("Hasi saioa");
		btnHasiSaioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//bisibilitatea
				btnKonektatu.setVisible(true);
				btnErregistratu.setVisible(false);
				btnHasiSaioa.setVisible(false);
				btnErregistratuNahi.setVisible(true);

				lblKonekBezeroMezua.setVisible(false);
				lblErroreakonektatu.setVisible(false);
				lblIzena.setVisible(false);
				lblAbizenak.setVisible(false);
				lblJaioData.setVisible(false);
				lblSexua.setVisible(false);
				lblPasahitza.setVisible(true);
				lblNan.setVisible(true);
				
				txtIzena.setVisible(false);
				txtAbizenak.setVisible(false);
				txtJaioData.setVisible(false);
				txtSexua.setVisible(false);
				passwordField.setVisible(true);
				txtNan.setVisible(true);

				lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblNan.setBounds(214, 211, 62, 20);
				getContentPane().add(lblNan);

				txtNan.setBounds(283, 211, 86, 20);
				getContentPane().add(txtNan);
				txtNan.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						letra = e.getKeyChar();
						// 9 baino gehiago edo espazioa sartzerakoan
						if (txtNan.getText().length() > nanLuzera || (letra == '\b'))
							e.consume(); // ez du godetzen
					}
				});

				lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblPasahitza.setBounds(184, 266, 93, 20);
				getContentPane().add(lblPasahitza);

				passwordField.setEchoChar('*');
				passwordField.setBounds(283, 269, 86, 20);
				getContentPane().add(passwordField);
			}
		});
		btnHasiSaioa.setBounds(143, 112, 109, 25);
		getContentPane().add(btnHasiSaioa);

		lblErroreakonektatu = new JLabel();
		lblErroreakonektatu.setVisible(false);
		lblErroreakonektatu.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblErroreakonektatu);

		btnKonektatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bbdd-ra konektatu pasahitza frogatzeko
				nan = txtNan.getText();
				pasahitza = String.valueOf(passwordField.getPassword());
				balPasa = Metodoak.frogatuPasahitza(pasahitza);
				balNan = Metodoak.frogatuNAN(nan);
				if (balPasa && balNan) {
					btn_next.setVisible(true);
					lblErroreakonektatu.setBounds(145, 329, 318, 22);
					lblErroreakonektatu.setForeground(Color.BLACK);
					lblErroreakonektatu.setText("Konektatuta");
					lblErroreakonektatu.setVisible(true);
					passwordField.setEnabled(false);
					txtNan.setEnabled(false);
					btnKonektatu.setEnabled(false);
				} else {
					lblErroreakonektatu.setBounds(145, 329, 318, 22);
					lblErroreakonektatu.setForeground(Color.RED);
					lblErroreakonektatu.setText("NAN-a edo pasahitza ez dago ondo, sartu berriz");
					lblErroreakonektatu.setVisible(true);
				}
			}
		});
		btnKonektatu.setBounds(245, 360, 104, 25);
		getContentPane().add(btnKonektatu);

		lblIzena = new JLabel("Izena:");
		lblAbizenak = new JLabel("Abizenak:");
		lblJaioData = new JLabel("Jaio data:");
		lblSexua = new JLabel("Sexua (V/M):");
		
		btnErregistratuNahi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//bisibilitatea
				btnErregistratu.setVisible(true);
				btnHasiSaioa.setVisible(true);
				btnKonektatu.setVisible(false);
				btnErregistratuNahi.setVisible(false);
				
				lblKonekBezeroMezua.setVisible(false);
				lblErroreakonektatu.setVisible(false);
				lblIzena.setVisible(true);
				lblAbizenak.setVisible(true);
				lblJaioData.setVisible(true);
				lblSexua.setVisible(true);
				lblPasahitza.setVisible(true);
				lblNan.setVisible(true);
				
				txtIzena.setVisible(true);
				txtAbizenak.setVisible(true);
				/*******				txtJaioData.setVisible(true);*/
				txtSexua.setVisible(true);
				passwordField.setVisible(true);
				txtNan.setVisible(true);
				
				//non, formatua eta zer jarri
				lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblNan.setBounds(212, 150, 62, 20);
				getContentPane().add(lblNan);

				txtNan.setBounds(281, 150, 86, 20);
				getContentPane().add(txtNan);
				txtNan.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						letra = e.getKeyChar();
						// 9 baino gehiago edo espazioa sartzerakoan
						if (txtNan.getText().length() > nanLuzera || (letra == '\b'))
							e.consume(); // ez du godetzen
					}
				});

				lblIzena.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblIzena.setBounds(203, 183, 62, 20);
				getContentPane().add(lblIzena);

				txtIzena.setBounds(281, 185, 86, 20);
				getContentPane().add(txtIzena);
				txtIzena.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						// 50 baino gehiago
						if (txtIzena.getText().length() > izenLuzera)
							e.consume(); // ez du godetzen
					}
				});

				lblAbizenak.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblAbizenak.setBounds(178, 226, 93, 20);
				getContentPane().add(lblAbizenak);

				txtAbizenak.setBounds(281, 228, 86, 20);
				getContentPane().add(txtAbizenak);
				txtAbizenak.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						// izenLuzera=50, abizenLuzera=100, pasahitzLuzera=50, sexuLuzera=1;
						if (txtAbizenak.getText().length() > abizenLuzera)
							e.consume(); // ez du godetzen
					}
				});
				
				lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblPasahitza.setBounds(175, 360, 93, 20);
				getContentPane().add(lblPasahitza);

				passwordField.setEchoChar('*');
				passwordField.setBounds(281, 362, 86, 20);
				getContentPane().add(passwordField);
				passwordField.addKeyListener(new KeyAdapter() {
					@SuppressWarnings("deprecation")
					public void keyTyped(KeyEvent e) {
						letra = e.getKeyChar();
						if (passwordField.getText().length() > pasahitzLuzera)
							e.consume(); // ez du godetzen
					}
				});

				lblSexua.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblSexua.setBounds(143, 270, 122, 20);
				getContentPane().add(lblSexua);

				txtSexua.setBounds(281, 272, 86, 20);
				getContentPane().add(txtSexua);
				txtSexua.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {						
						letra = e.getKeyChar();
						if (txtSexua.getText().length() > sexuLuzera || letra !='V' && letra !='v' && letra !='M' && letra !='m')
							e.consume(); // ez du godetzen
					}
				});
				
				lblJaioData.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblJaioData.setBounds(175, 315, 90, 20);
				getContentPane().add(lblJaioData);

				
 				
				txtJaioData.setDateFormatString("yyyy-MM-dd");
				txtJaioData.setBounds(281, 315, 112, 20);
				getContentPane().add(txtJaioData);
 
		}
		});
		btnErregistratuNahi.setBounds(313, 112, 122, 25);
		getContentPane().add(btnErregistratuNahi);

		
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bbdd-ra konektatu pasahitza frogatzeko
				nan = txtNan.getText();
				pasahitza = String.valueOf(passwordField.getPassword());
				izena = txtIzena.getText();
				abizenak = txtAbizenak.getText();
				jaioData = txtJaioData.getDate();
				
		//		jaioData = Metodoak.dataAldatu(jaioData);
				sexua = txtSexua.getText();

				balErregis = Metodoak.erregistratuBezeroak(pasahitza, nan, izena, abizenak, sexua, jaioData);
								
				if (balErregis) {
					btn_next.setVisible(true);
					lblErroreakonektatu.setBounds(122, 445, 318, 22);
					lblErroreakonektatu.setForeground(Color.BLACK);
					lblErroreakonektatu.setText("Erregistratuta");
					lblErroreakonektatu.setVisible(true);
					passwordField.setEnabled(false);
					txtNan.setEnabled(false);					
					txtIzena.setEnabled(false);
					txtAbizenak.setEnabled(false);
					txtJaioData.setEnabled(false);
					txtSexua.setEnabled(false);
					// btnKonektatu.setEnabled(false);
				} else {
					lblErroreakonektatu.setForeground(Color.RED);
					lblErroreakonektatu.setBounds(122, 445, 318, 22);
					lblErroreakonektatu.setVisible(true);
					if (nan.isEmpty())
						lblErroreakonektatu.setText("nan-a bete behar duzu");
					else if (izena.isEmpty())
						lblErroreakonektatu.setText("izena bete behar duzu");
					else if (abizenak.isEmpty())
						lblErroreakonektatu.setText("abizena bete behar duzu");
					else if (sexua.isEmpty())
						lblErroreakonektatu.setText("sexua bete behar duzu");
					else if (jaioData==null)
						lblErroreakonektatu.setText("jaioData bete behar duzu");
					else if (pasahitza.length()==0)
						lblErroreakonektatu.setText("pasahitza bete behar duzu");
				}
			}
		});
		btnErregistratu.setBounds(233, 408, 109, 25);
		getContentPane().add(btnErregistratu);
		


	}
}
