package ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Reserve extends JFrame implements ActionListener{

	private JPopupMenu popUpmenu;
	private JMenuItem m1,m2;
	private JButton btnSeoul;
	private JButton btnDaeJeon;
	private JButton btnDaeGu;
	private JButton btnBusan;
	private JButton btnGangJu;
	private String[] kind = {"전체","KTX","새마을호","무궁화호"};
	private JComboBox<String> comboBox;
	private JButton btnTrain;

	public Reserve() {
		setTitle("승차권예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2100, 100);
		setSize(295, 500);
		setLayout(new BorderLayout());
		
		JPanel image = new JPanel();
		image.setLayout(null);
		image.setPreferredSize(new Dimension(50,30));
		
		btnSeoul = new JButton("서울역");
		btnSeoul.addActionListener(this);
		btnSeoul.setBounds(60, 80, 80, 30);
		btnSeoul.setBorderPainted(false);
		btnSeoul.setFocusPainted(false);
		btnSeoul.setContentAreaFilled(false);
		
		btnDaeJeon = new JButton("대전역");
		btnDaeJeon.addActionListener(this);
		btnDaeJeon.setBounds(90, 135, 80, 30);
		btnDaeJeon.setBorderPainted(false);
		btnDaeJeon.setFocusPainted(false);
		btnDaeJeon.setContentAreaFilled(false);
		
		btnDaeGu = new JButton("대구역");
		btnDaeGu.addActionListener(this);
		btnDaeGu.setBounds(160, 165, 80, 30);
		btnDaeGu.setBorderPainted(false);
		btnDaeGu.setFocusPainted(false);
		btnDaeGu.setContentAreaFilled(false);
		
		btnBusan = new JButton("부산역");
		btnBusan.addActionListener(this);
		btnBusan.setBounds(190, 205, 80, 30);
		btnBusan.setBorderPainted(false);
		btnBusan.setFocusPainted(false);
		btnBusan.setContentAreaFilled(false);
		
		btnGangJu = new JButton("광주역");
		btnGangJu.addActionListener(this);
		btnGangJu.setBounds(40, 215, 80, 30);
		btnGangJu.setBorderPainted(false);
		btnGangJu.setFocusPainted(false);
		btnGangJu.setContentAreaFilled(false);
		
		popUpmenu = new JPopupMenu();
		m1 = new JMenuItem("출발역");
		popUpmenu.add(m1);
		m2 = new JMenuItem("도착역");
		popUpmenu.add(m2);
		
		image.add(btnSeoul);
		image.add(btnDaeJeon);
		image.add(btnDaeGu);
		image.add(btnBusan);
		image.add(btnGangJu);
		btnSeoul.setComponentPopupMenu(popUpmenu);
		
		ImageIcon img = new ImageIcon("image/TrainMap.jpg");
		JLabel lbl = new JLabel(img);
		lbl.setBounds(12, 5, 250, 300);
		image.add(lbl);
		
		add(image, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(40,150));
//		bottomPanel.setBackground(Color.blue);
		bottomPanel.setLayout(null);
		JLabel lblstart = new JLabel("출발역 : ");
		lblstart.setBounds(10, 10, 80, 20);
		bottomPanel.add(lblstart);
		JLabel lblstart2 = new JLabel("00역");
		lblstart2.setBounds(110, 10, 80, 20);
		bottomPanel.add(lblstart2);
		
		
		JLabel lblarrive = new JLabel("도착역 : ");
		lblarrive.setBounds(10, 40, 80, 20);
		bottomPanel.add(lblarrive);
		JLabel lblarrive2 = new JLabel("00역");
		lblarrive2.setBounds(110, 40, 80, 20);
		bottomPanel.add(lblarrive2);
		
		JLabel lbltrain = new JLabel("열차종류 : ");
		lbltrain.setBounds(10, 70, 80, 20);
		bottomPanel.add(lbltrain);
		
		comboBox = new JComboBox<String>(kind);
		comboBox.setBounds(110, 70, 80, 20);
		bottomPanel.add(comboBox);
		
		btnTrain = new JButton("열차조회");
		btnTrain.setBounds(90, 100, 100, 25);
		bottomPanel.add(btnTrain);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Reserve mm = new Reserve();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnSeoul || obj ==btnGangJu || obj == btnDaeJeon || obj == btnDaeGu || obj==btnBusan) {
			showPopup(obj);
		}
		
	}

	private void showPopup(Object obj) {
		Component b = (Component) obj;
		Point p = b.getLocationOnScreen();
		popUpmenu.show(this,0,0);
		popUpmenu.setLocation(p.x,p.y+b.getHeight());
	}

		
}