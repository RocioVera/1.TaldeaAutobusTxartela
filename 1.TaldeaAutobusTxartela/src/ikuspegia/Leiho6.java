package ikuspegia;
import java.awt.*;
import javax.swing.*;
import kontrolatzailea.Metodoak;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leiho6 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblEskerrikAskoMezua1, lblEskerrikAskoMezua2;
	private JButton btnTiketaIkusi;
	private JTextField txtSegundenMezua;

	public Leiho6() {
		getContentPane().setLayout(null);
		this.setBounds(350,50,600,600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		//Eskerrik asko mezua
		lblEskerrikAskoMezua1 = new JLabel("Eskerrik asko Termibus-eko");
		lblEskerrikAskoMezua1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua1.setFont(new Font("MS PMincho", Font.BOLD, 35));
		lblEskerrikAskoMezua1.setBounds(43, 29, 493, 53);
		getContentPane().add(lblEskerrikAskoMezua1);
		
		lblEskerrikAskoMezua2 = new JLabel("makinetan erosteagatik");
		lblEskerrikAskoMezua2.setFont(new Font("MS PMincho", Font.BOLD, 35));
		lblEskerrikAskoMezua2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua2.setBounds(53, 84, 493, 59);
		getContentPane().add(lblEskerrikAskoMezua2);
		
		
		txtSegundenMezua = new JTextField("Tiketa");
		//lblPasahitza = new JLabel("Pasahitza:");
		txtSegundenMezua.setVisible(false);
	//	lblNan.setVisible(false);
		
		btnTiketaIkusi = new JButton("Tiketa ikusi");
		btnTiketaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSegundenMezua.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtSegundenMezua.setHorizontalAlignment(SwingConstants.CENTER);
				txtSegundenMezua.setBackground(Color.LIGHT_GRAY);
				txtSegundenMezua.setBounds(99, 230, 389, 216);
				getContentPane().add(txtSegundenMezua);
				txtSegundenMezua.setVisible(true);

			//	Metodoak.Leiho_segunduak();
			//	dispose();
			}
		});
		btnTiketaIkusi.setBounds(247, 168, 97, 25);
		getContentPane().add(btnTiketaIkusi);
		
		
		//FALTA EL TICKET
		
	}
}
