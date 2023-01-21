package ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	private JButton btnlogin;
	private JTextField tfID;
	private JPasswordField tfpw;

	public Login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setSize(240, 130);
		setLayout(new BorderLayout());
		
		JPanel panelUp = new JPanel();
		panelUp.setLayout(new GridLayout(2,1));
		
		JPanel panelID = new JPanel();
		JLabel lblID = new JLabel("ID :");
		panelID.add(lblID);
		tfID = new JTextField(20);
		panelID.add(tfID);
		panelUp.add(panelID);
		
		JPanel panelPW = new JPanel();
		JLabel lblpw = new JLabel("pw:");
		panelPW.add(lblpw);
		tfpw = new JPasswordField(20);
		panelPW.add(tfpw);
		panelUp.add(panelPW);
			
		add(panelUp, BorderLayout.CENTER);
		
		
		btnlogin = new JButton("Login");
		btnlogin.addActionListener(this);
		add(btnlogin, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Login lg = new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj ==btnlogin) {
			
		}
		
	}
}
