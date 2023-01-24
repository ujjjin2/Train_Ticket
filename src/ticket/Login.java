package ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	private JButton btnlogin;
	private JTextField tfID;
	private JPasswordField tfpw;
	String ID,PW;

	public Login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2100, 100);
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
		DB.init();
		Login lg = new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj ==btnlogin) {
			ID = tfID.getText();
			PW = tfpw.getText();
			login(ID, PW);
		}
		
	}
	
	public void login(String ID2,String PW2) {
		String sql = "SELECT * FROM user WHERE uID = '" + ID2 + "'";
		try {
			ResultSet rs = DB.getResultSet(sql);
			if (rs.next()) {
				String id = rs.getString("uID");
				String pw = rs.getString("uPW");
				String name = rs.getString("name");
				
				if (ID2.equals(id) && PW2.equals(pw)) {
					JOptionPane.showMessageDialog(this, name+"님 환영합니다.","메세지",JOptionPane.INFORMATION_MESSAGE);
					Main main = new Main();
					dispose();
					System.out.println("로그인 성공");
				}else {
					JOptionPane.showMessageDialog(this, "ID 또는 PW를 확인해주세요","메세지",JOptionPane.ERROR_MESSAGE);
					tfID.setText("");
					tfpw.setText("");
					tfID.requestFocus(true);
					System.out.println("로그인 입력 실수");
				}
			}
			
		} catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
	}
}
