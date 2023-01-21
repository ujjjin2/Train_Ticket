package ticket;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InquireResult extends JFrame{

	public InquireResult() {
		setTitle("조회결과");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setSize(240, 130);
		setLayout(new BorderLayout());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		InquireResult mm = new InquireResult();
	}

		
}