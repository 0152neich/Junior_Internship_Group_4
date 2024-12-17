package Views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.impl.BillManagementImpl;
import model.Bill;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class BillViews {
    
//<<<<<<< HEAD
    private JFrame frame;
//=======
//    JFrame frame;
//>>>>>>> c31ab5d (Lưu các thay đổi local trước khi pull code mới)
    private JTable table;
    private JComboBox typeComboBox;
    private JComboBox valueComboBox;
    private BillManagementImpl billManager = new BillManagementImpl();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BillViews window = new BillViews();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BillViews() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1135, 567);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
//<<<<<<< HEAD

//=======
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // Khi người dùng nhấn nút đóng, cửa sổ sẽ bị ẩn đi thay vì dừng tiến trình
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.setVisible(false); // Ẩn cửa sổ thay vì dừng tiến trình
            }
        });
//>>>>>>> c31ab5d (Lưu các thay đổi local trước khi pull code mới)
        JButton btnNewButton = new JButton("Lọc");
        btnNewButton.setBounds(330, 92, 55, 29);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị từ các ComboBox
            	String selectedType = null ; 
            	String check = (String) typeComboBox.getSelectedItem();
                if(check.equalsIgnoreCase("Ngày")){
                	selectedType = "day" ;
                }else if(check.equalsIgnoreCase("Tháng")) {
                	selectedType = "month" ;
                }else {
                	selectedType = "year" ;
                }
                
                int selectedValue = Integer.parseInt(valueComboBox.getSelectedItem().toString());
                
                // Lọc danh sách hóa đơn dựa trên giá trị chọn
                filterBills(selectedType, selectedValue);
            }
        });


        JButton addNewBillButton = new JButton("Tạo hoá đơn");
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
        
        JButton BackButton = new JButton("Huỷ");
        BackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePage window = new homePage();
				window.frame.setVisible(true);
				frame.dispose();
				
			}
		});
//>>>>>>> c31ab5d (Lưu các thay đổi local trước khi pull code mới)
        BackButton.setBounds(1048, 6, 75, 29);
        panel.add(BackButton);
        
        JLabel lblNewLabel = new JLabel("Quản lý hoá đơn");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Chỉnh font chữ to hơn, kích thước 24
        lblNewLabel.setBounds(6, 0, 302, 39); // 
        panel.add(lblNewLabel);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 166, 1135, 367);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel TypeLabel = new JLabel("Loại");
        TypeLabel.setBounds(16, 97, 61, 16);
        frame.getContentPane().add(TypeLabel);

        typeComboBox = new JComboBox<>();
        typeComboBox.setBounds(57, 93, 107, 27);
        typeComboBox.addItem("Ngày");
        typeComboBox.addItem("Tháng");
        typeComboBox.addItem("Năm");
        frame.getContentPane().add(typeComboBox);

        JLabel Valuelabel = new JLabel("Giá trị");
        Valuelabel.setBounds(176, 97, 61, 16);
        frame.getContentPane().add(Valuelabel);

        valueComboBox = new JComboBox();
        valueComboBox.setBounds(231, 93, 87, 27);
        frame.getContentPane().add(valueComboBox);

        typeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateValueComboBox();
            }
        });

        updateValueComboBox();  // Initialize valueComboBox on startup

        // Load table data
        loadTableData();

        
    }

    private void loadTableData() {
        ArrayList<Bill> bills = billManager.getAllBills();
        if (bills == null || bills.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frame, "Không có danh sách hóa đơn!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] table_headers = { "ID", "Amount", "Date", "Customer", "Quantity", "User ID" };
        DefaultTableModel model = new DefaultTableModel(table_headers, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: return Integer.class;
                    case 1: return Double.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return Integer.class;
                    case 5: return Integer.class;
                    default: return Object.class;
                }
            }
        };

        for (Bill bill : bills) {
            model.addRow(new Object[] {
                bill.getId(),
                bill.getAmount(),
                bill.getDate(),
                bill.getCustomer(),
                bill.getQuantity(),
                bill.getUserid()
            });
        }

        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);

        JTableHeader tableHeader = table.getTableHeader();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    ((javax.swing.JLabel) c).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    return c;
                }
            });
        }

        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(3).setMaxWidth(300);
    }

    private void updateValueComboBox() {
        String selectedType = (String) typeComboBox.getSelectedItem();
        valueComboBox.removeAllItems();

        switch (selectedType) {
            case "Ngày":
                for (int i = 1; i <= 31; i++) {
                    valueComboBox.addItem(i);
                }
                break;
            case "Tháng":
                for (int i = 1; i <= 12; i++) {
                    valueComboBox.addItem(i);
                }
                break;
            case "Năm":
                for (int i = 2020; i <= 2030; i++) {
                    valueComboBox.addItem(i);
                }
                break;
        }
    }

    // Add your filterBills method here to handle filtering based on the selected type and value
    private void filterBills(String selectedType, int selectedValue) {
        // Sử dụng phương thức search để lấy danh sách hóa đơn đã lọc
        List<Bill> filteredBills = billManager.search(selectedType, selectedValue);
        
        // Nếu không có hóa đơn nào được tìm thấy, thông báo cho người dùng
        if (filteredBills == null || filteredBills.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frame, "Không có hóa đơn khớp với điều kiện lọc!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Cập nhật bảng với danh sách hóa đơn đã lọc
        updateTable(filteredBills);
    }

    
    private void updateTable(List<Bill> bills) {
        // Tạo lại DefaultTableModel cho bảng
        String[] table_headers = { "ID", "Amount", "Date", "Customer", "Quantity", "User ID" };

        DefaultTableModel model = new DefaultTableModel(table_headers, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: return Integer.class; // ID
                    case 1: return Double.class;  // Amount
                    case 2: return String.class;  // Date
                    case 3: return String.class;  // Customer
                    case 4: return Integer.class; // Quantity
                    case 5: return Integer.class; // User ID
                    default: return Object.class;
                }
            }
        };

        // Thêm các hóa đơn đã lọc vào bảng
        for (Bill bill : bills) {
            model.addRow(new Object[] {
                bill.getId(),
                bill.getAmount(),
                bill.getDate(),
                bill.getCustomer(),
                bill.getQuantity(),
                bill.getUserid()
            });
        }

        // Cập nhật lại model của bảng
        table.setModel(model);

        // Cập nhật lại cột và căn giữa tiêu đề cột như trước
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    ((javax.swing.JLabel) c).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    return c;
                }
            });
        }
    }


}

