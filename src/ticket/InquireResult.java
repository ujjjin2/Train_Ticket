package ticket;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class InquireResult extends JFrame{

	private String[] title = {"열차", "출발역", "도착역","좌석현황","가격",""};
	private String[][] datas = new String[0][6];
	private DefaultTableModel model = new DefaultTableModel(datas,title);
	private JTable table = new JTable(model);
	private JScrollPane ScrollPane;
	private JButton btnReserve;
	
	public InquireResult() {
		setTitle("조회결과");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2100, 100);
		setSize(600, 700);
		setLayout(new BorderLayout());
		
		table();
		
		try {
			showTotal(this);
		} catch (SQLException e) {
			System.out.println("테이블 오류");
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	private void table() {
		JPanel listPanel = new JPanel();
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
		table.getColumnModel().getColumn(5).setCellEditor(new TableCell());
		
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
	 class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	        JButton jb;
	 
	        public TableCell() {
	            jb = new JButton("예약");
	            jb.addActionListener(e -> {
	                //JTableRemoveRow();
	            });
	        }
	 
	        @Override
	        public Object getCellEditorValue() {
	            return null;
	        }
	 
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	                int row, int column) {
	            return jb;
	        }
	 
	        @Override
	        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
	                int column) {
	            return jb;
	        }
	    } // end class TableCell extends AbstractCellEditor implements TableCellEditor,
	        // TableCellRenderer
	 
	 public void showTotal(InquireResult ir) throws SQLException{
			String sql = "SELECT * FROM student";
			ResultSet rs;
			try {
				rs = DB.getResultSet(sql);
				ir.getModel().setNumRows(0);
				while(rs.next()) {
					String[] imsi = {rs.getString("studentID"),rs.getString("name"),rs.getString("sex"),rs.getString("type"),rs.getString("sin")};
					ir.getModel().addRow(imsi);
				}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
		public DefaultTableModel getModel() {
			return model;
		}
}