package ticket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Main extends JFrame implements ActionListener{

	private JButton btnReserve;
	private JButton btnCheck;
	private JButton btnLogout;
	
	private String[] title = {"열차", "출발시간", "도착역","도착시간"};
	private String[][] datas = new String[0][5];
	private DefaultTableModel model = new DefaultTableModel(datas,title);
	private JTable table = new JTable(model);
	private JScrollPane ScrollPane;
	private JComboBox<String> comboBox;
	private String[] station = {"서울역","대전역","대구역","부산역","광주역"};
	
	public Main() {
		setTitle("메인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1900, 100);
		setSize(500, 395);
		setLayout(new BorderLayout());
		
		JPanel panelUp = new JPanel();
		panelUp.setLayout(null);
		panelUp.setPreferredSize(new Dimension(50,50));
		comboBox = new JComboBox<String>(station);
		comboBox.setBounds(8, 15, 120, 30);
		panelUp.add(comboBox);
		
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int Minute = now.getMinute();
		
		JLabel lbltime = new JLabel("현재시각 : " + hour + ":"+Minute);
		lbltime.setBounds(380, 15, 150, 30);
		panelUp.add(lbltime);
		add(panelUp,BorderLayout.NORTH);
		
		table();
		
		JPanel panelDown = new JPanel();
		panelDown.setLayout(null);
		panelDown.setPreferredSize(new Dimension(50,90));
		
		btnReserve = new JButton("승차권예매");
		btnReserve.setBounds(10, 20, 150, 40);
		btnReserve.addActionListener(this);
		panelDown.add(btnReserve);
		
		btnCheck = new JButton("승차권확인");
		btnCheck.setBounds(167, 20, 150, 40);
		btnCheck.addActionListener(this);
		panelDown.add(btnCheck);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setBounds(325, 20, 150, 40);
		btnLogout.addActionListener(this);
		panelDown.add(btnLogout);
		
		add(panelDown, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private void table() {
		JPanel listPanel = new JPanel();
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		//DafaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
						
		//DfaultTableCellHeaderRender의 정렬을 가운데 정렬로 지정
		tableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
						
		//정렬할 테이블의 ColumnModel 을 가져옴
		TableColumnModel tableColumnModel = table.getColumnModel();
						
		//반복문을 이용하여 테이블 가운데 정렬로 지정
			for (int i = 0; i < tableColumnModel.getColumnCount(); i++) {
				tableColumnModel.getColumn(i).setCellRenderer(tableCellRenderer);
			}
		
		ScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ScrollPane.setPreferredSize(new Dimension(470,200));
		listPanel.add(ScrollPane);
		add(listPanel, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		Main mm = new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if (obj == btnLogout) {
			dispose();
			new Login();
		}else if (obj == btnReserve) {
			dispose();
			new Reserve();
		}else if (obj == btnCheck) {
			dispose();
			new Check();
		}
	}

		
}

