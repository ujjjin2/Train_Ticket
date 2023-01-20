package ticket;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Reserve extends JFrame{

	public Reserve() {
		setTitle("승차권예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1900, 100);
		setSize(240, 130);
		setLayout(new BorderLayout());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Reserve mm = new Reserve();
	}

		
}