package ikuspegia;

import java.awt.*;
import javax.swing.*;
import kontrolatzailea.*;
import java.awt.event.*;

public class Leiho4 extends JFrame {
	private static final long serialVersionUID = 1L;
	static JTextField txtPrezioTot = new JTextField();
	private JTextField txtNan;
	private JPasswordField passwordField;
	private JLabel lblPrezioTotala, lblNan, lblPasahitza, lblErroreakonektatu, lblKonekBezeroMezua;
	private JButton btnSartu;
	private JButton btnKonektatu = new JButton("Konektatu"); 
	private JButton btn_next = new JButton("Hurrengoa");
	private JButton btn_prev = new JButton("Atzera");
	private JButton restart = new JButton("\u2302");
	private String pasahitza, nan;
	private boolean balPasa, balNan;
	private int nanLuzera=8;
	private char letra;
	
	public Leiho4(String hartutakoLinea) {
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
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
		lblPrezioTotala.setBounds(159, 91, 117, 20);
		getContentPane().add(lblPrezioTotala);

		txtPrezioTot.setEditable(false);
		txtPrezioTot.setColumns(10);
		txtPrezioTot.setBounds(283, 91, 86, 20);
		String guztiraPrezBEZ="";
		//guztiraPrezBEZ = zerrenda.guztiraPrezBEZMetodoa();
		txtPrezioTot.setText(guztiraPrezBEZ + " €");
		getContentPane().add(txtPrezioTot);
		btn_next.setVisible(false);
		
		btnKonektatu.setVisible(false);
		lblNan = new JLabel("NAN:");
		lblNan.setVisible(false);
		lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setVisible(false);
		
		lblKonekBezeroMezua = new JLabel("Konektatzeko bezeroa eta pasahitza sartu");
		lblKonekBezeroMezua.setForeground(Color.BLUE);
		lblKonekBezeroMezua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKonekBezeroMezua.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		lblKonekBezeroMezua.setBounds(122, 137, 328, 16);
		getContentPane().add(lblKonekBezeroMezua);
		
		btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnKonektatu.setVisible(true);
				lblKonekBezeroMezua.setVisible(false);
				btnSartu.setVisible(false);
				
				lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblNan.setBounds(214, 211, 62, 20);
				getContentPane().add(lblNan);
				
				txtNan = new JTextField();
				txtNan.setBounds(283, 211, 86, 20);
				getContentPane().add(txtNan);
				txtNan.addKeyListener(new KeyAdapter(){
				   public void keyTyped(KeyEvent e){
					   letra = e.getKeyChar();
					   //9 baino gehiago edo espazioa sartzerakoan
					   if (txtNan.getText().length()>nanLuzera || (letra == '\b'))
				         e.consume();  // ez du godetzen  
				   }
				});
				
				lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 17));
				lblPasahitza.setBounds(184, 266, 93, 20);
				getContentPane().add(lblPasahitza);
						
				lblPasahitza.setVisible(true);
				lblNan.setVisible(true);
				
				passwordField = new JPasswordField();
				passwordField.setEchoChar('*');
				passwordField.setBounds(283, 269, 86, 20);
				getContentPane().add(passwordField);
			}
		});
		btnSartu.setBounds(245, 166, 69, 25);
		getContentPane().add(btnSartu);	
		
		
		lblErroreakonektatu = new JLabel();
		lblErroreakonektatu.setVisible(false);
		lblErroreakonektatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblErroreakonektatu.setBounds(134, 325, 318, 22);
		getContentPane().add(lblErroreakonektatu);

		btnKonektatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//bbdd-ra konektatu pasahitza frogatzeko
				nan = txtNan.getText();
				pasahitza = String.valueOf(passwordField.getPassword());
				balPasa = Metodoak.frogatuPasahitza(pasahitza);
				balNan = Metodoak.frogatuNAN(nan);
				if (balPasa && balNan) {
					btn_next.setVisible(true);
					lblErroreakonektatu.setForeground(Color.BLACK);
					lblErroreakonektatu.setText("Konektatuta");
					passwordField.setEnabled(false);
					txtNan.setEnabled(false);
					btnKonektatu.setEnabled(false);
					lblErroreakonektatu.setVisible(true);
				}else {
					lblErroreakonektatu.setForeground(Color.RED);
					lblErroreakonektatu.setText("NAN-a edo pasahitza ez dago ondo, sartu berriz");
					lblErroreakonektatu.setVisible(true);
				}	
			}
		});
		btnKonektatu.setBounds(245, 360, 104, 25);
		getContentPane().add(btnKonektatu);
		


		
	}
}
