package ikuspegia;

import java.awt.*;
import javax.swing.*;
import kontrolatzailea.*;

import ikuspegia.*;
import ikuspegia.Frame;
import kontrolatzailea.*;

import java.awt.event.*;
import java.util.ArrayList;

import ikuspegia.*;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	GridBagConstraints config = new GridBagConstraints();

	public Frame() {
		this.setTitle("1.taldearen txartel salmentaren app");
		this.setSize(new Dimension(600, 600));
		this.setResizable(false); // neurketak ez aldatzeko
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	/*	Leiho1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Leiho1.isVisible()) {
					btn_next.setVisible(false);
					restart.setVisible(true);
					Leiho2.setVisible(true);
					Leiho3.setVisible(false);
					Leiho4.setVisible(false);
					Leiho5.setVisible(false);
					Leiho6.setVisible(false);
					Leiho1.setVisible(false);
					validate();
				}
			}
		});*/


	}
}