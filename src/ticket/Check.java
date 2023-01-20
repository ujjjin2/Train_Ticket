package ticket;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Check extends JFrame{

	public Check() {
		setTitle("승차권확인");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1900, 100);
		setSize(240, 130);
		setLayout(new BorderLayout());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Reserve mm = new Reserve();
	}

		
}
