package ticket;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class InquireResult extends JFrame{

	private String[] title = {"열차", "출발역", "도착역","좌석현황","가격",""};
	private String[][] datas = new String[0][5];
	private DefaultTableModel model = new DefaultTableModel(datas,title);
	private JTable table = new JTable(model);
	private JScrollPane ScrollPane;
	
	public InquireResult() {
		setTitle("조회결과");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2100, 100);
		setSize(600, 700);
		setLayout(new BorderLayout());
		
		table();
		
		setVisible(true);
	}
	
	private void table() {
		JPanel listPanel = new JPanel();
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
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
		InquireResult mm = new InquireResult();
		
	}

		
}