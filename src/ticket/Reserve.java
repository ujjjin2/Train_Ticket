package ticket;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Reserve extends JFrame{

	public Reserve() {
		setTitle("승차권예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setSize(295, 400);
		setLayout(new BorderLayout());
		
		JPanel image = new JPanel();
		image.setLayout(null);
		image.setPreferredSize(new Dimension(50,30));
		
		JMenuBar bar1 = new JMenuBar();
		JMenu stSeoul= new JMenu("서울역");
		stSeoul.add(new JMenuItem("출발역"));
		stSeoul.add(new JMenuItem("도착역"));
		stSeoul.setBounds(80, 80, 70, 20);
		bar1.add(stSeoul);
		image.add(bar1);
		
		ImageIcon img = new ImageIcon("image/TrainMap.jpg");
		JLabel lbl = new JLabel(img);
		lbl.setBounds(12, 5, 250, 300);
		image.add(lbl);
		add(image);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Reserve mm = new Reserve();
	}

		
}