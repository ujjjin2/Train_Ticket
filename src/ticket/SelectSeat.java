package ticket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class SelectSeat extends JFrame {
	private String[] num = {"1호차","2호차","3호차","4호차","5호차","6호차","7호차","8호차"};
	private JSpinner spinner;
	private JButton btn1A;
	private JButton btn2A;
	private JButton btn3A;
	private JButton btn4A;
	private JButton btn5A;
	private JButton btn6A;
	private JButton btnselect;
	
	public SelectSeat() {
		setTitle("좌석선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2100, 100);
		setSize(300, 500);
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setPreferredSize(new Dimension(50,60));
		SpinnerListModel listModel = new SpinnerListModel(num);
		spinner = new JSpinner(listModel);
		spinner.setBounds(20, 20, 80, 30);
		panel1.add(spinner);
		add(panel1, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,2,20,20));
		
		btn1A = new JButton("1A");
		panel2.add(btn1A);
		btn2A = new JButton("2A");
		panel2.add(btn2A);
		btn3A = new JButton("3A");
		panel2.add(btn3A);
		btn4A = new JButton("4A");
		panel2.add(btn4A);
		btn5A = new JButton("5A");
		panel2.add(btn5A);
		btn6A = new JButton("6A");
		panel2.add(btn6A);
		
		add(panel2, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		btnselect  = new JButton("선택완료");
		panel3.add(btnselect);
		add(panel3,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SelectSeat lg = new SelectSeat();
	}
}
