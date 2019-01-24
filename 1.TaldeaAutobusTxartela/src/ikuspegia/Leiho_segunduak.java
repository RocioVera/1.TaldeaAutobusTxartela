package ikuspegia;
import java.util.concurrent.TimeUnit;

import ikuspegia.Frame;
public class Leiho_segunduak {
		public void run(){
			for (int i=1;i<=5;i++) {
				System.out.println(i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} 
			}// for
				Frame.Leiho1.setVisible(true);
				Frame.Leiho3.setVisible(false);
				Frame.Leiho4.setVisible(false);
				Frame.Leiho5.setVisible(false);
				Frame.Leiho2.setVisible(false);
			//	zerrenda.hasieratuMetodoa();
		} //public void
	} //class
