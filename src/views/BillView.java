package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.impl.BillManagementImpl;
import model.Bill;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BillView {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private BillManagementImpl billManager = new BillManagementImpl() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillView window = new BillView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1135, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(31, 89, 175, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Lọc");
		btnNewButton.setBounds(204, 92, 55, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton addNewBillButton = new JButton("Tạo hoá đơn");
		addNewBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addNewBillButton.setBounds(879, 105, 117, 29);
		frame.getContentPane().add(addNewBillButton);
		
		JButton ViewDetailButton = new JButton("Xem chi tiết");
		ViewDetailButton.setBounds(1012, 105, 117, 29);
		frame.getContentPane().add(ViewDetailButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 189, 189));
		panel.setBounds(0, 0, 1129, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(1006, 6, 117, 29);
		panel.add(btnNewButton_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						 "ID", "Amount", "Date", "Customer", "Quantity", "User ID"
				}
			));
		table.setBounds(0, 166, 1135, 367);
		frame.getContentPane().add(table);
		loadTableData();
		
		
	}
	
	private void loadTableData() {
	    // Lấy danh sách hóa đơn từ billManager
//	    ArrayList<Bill> bills = billManager.getAllBills();

	    // Kiểm tra danh sách hóa đơn
//	    if (bills == null || bills.isEmpty()) {
//	        // Hiển thị thông báo nếu không có hóa đơn
//	        javax.swing.JOptionPane.showMessageDialog(frame, "Không có danh sách hóa đơn!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//	        return;
//	    }

	    // Tên cột
	    String[] columnNames = { "ID", "Amount", "Date", "Customer", "Quantity", "User ID" };

	    // Tạo DefaultTableModel
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

	    // Thêm từng hóa đơn vào model
//	    for (Bill bill : bills) {
//	        model.addRow(new Object[] { 
//	            bill.getId(), 
//	            bill.getAmount(), 
//	            bill.getDate(), 
//	            bill.getCustomer(), 
//	            bill.getQuantity() 
////	            bill.getUserid() 
//	        });
//	    }

	    // Gán model cho bảng
	    table.setModel(model);
	}

	
	
	
	
}