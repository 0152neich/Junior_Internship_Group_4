package Views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.impl.ProductManagementImpl;
import model.Production;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class CreateNewBillView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tableProduct;
	private JTable tablePromotion;
	private JTable ProductInShopTable;
	private JTable PromotionInshopTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewBillView window = new CreateNewBillView();
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
	public CreateNewBillView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 985, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin hoá đơn ");
		lblNewLabel.setBounds(106, 6, 159, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel userIDLabel = new JLabel("Mã nhân viên :");
		userIDLabel.setBounds(17, 55, 99, 16);
		frame.getContentPane().add(userIDLabel);
		
		JLabel customerNameLabel = new JLabel("Tên khách hàng :");
		customerNameLabel.setBounds(17, 95, 112, 16);
		frame.getContentPane().add(customerNameLabel);
		
		textField = new JTextField();
		textField.setBounds(141, 50, 188, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 90, 188, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 135, 188, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 179, 188, 26);
		frame.getContentPane().add(textField_3);
		
		JLabel phoneLabel = new JLabel("SĐT :");
		phoneLabel.setBounds(17, 140, 61, 16);
		frame.getContentPane().add(phoneLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày bán : ");
		lblNewLabel_1.setBounds(17, 184, 99, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel productListLabel = new JLabel("Danh mục sản phầm đã mua :");
		productListLabel.setBounds(17, 234, 188, 16);
		frame.getContentPane().add(productListLabel);
		
		tableProduct = new JTable();
		tableProduct.setBounds(0, 263, 357, 88);
		frame.getContentPane().add(tableProduct);
		
		JLabel promotionListLabel = new JLabel("Nội dung khuyễn mãi được áp dụng:");
		promotionListLabel.setBounds(17, 390, 266, 16);
		frame.getContentPane().add(promotionListLabel);
		
		tablePromotion = new JTable();
		tablePromotion.setBounds(0, 418, 357, 88);
		frame.getContentPane().add(tablePromotion);
		
		JLabel tamtinhLabel = new JLabel("Tạm tính :");
		tamtinhLabel.setBounds(141, 362, 80, 16);
		frame.getContentPane().add(tamtinhLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(233, 362, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel finalMoneyLabel = new JLabel("Thành tiền :");
		finalMoneyLabel.setBounds(141, 518, 81, 16);
		frame.getContentPane().add(finalMoneyLabel);
		
		JButton TaoButton = new JButton("Tạo");
		TaoButton.setBounds(233, 547, 117, 29);
		frame.getContentPane().add(TaoButton);
		
		JButton CancelButton = new JButton("Huỷ");
		CancelButton.setBounds(0, 547, 117, 29);
		frame.getContentPane().add(CancelButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 189, 189));
		panel.setBounds(0, 0, 357, 582);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel ProductListLabel = new JLabel("Danh sách sản phầm trong cừa hàng");
		ProductListLabel.setBounds(393, 6, 245, 16);
		frame.getContentPane().add(ProductListLabel);
		
		ProductInShopTable = new JTable();
		ProductInShopTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = ProductInShopTable.rowAtPoint(evt.getPoint());
		        if (row >= 0) {
		            // Lấy thông tin sản phẩm từ dòng đã chọn
		            String productId = (String)ProductInShopTable.getValueAt(row, 0);
		            String productName = (String) ProductInShopTable.getValueAt(row, 1);
		            double productPrice = (double) ProductInShopTable.getValueAt(row, 2);
		            int productQuantity = (int) ProductInShopTable.getValueAt(row, 3);

		            // Hiển thị thông tin sản phẩm vào bảng sản phẩm đã mua
		            DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();
		            // Xóa dữ liệu cũ (nếu có)
		            productModel.setRowCount(0);
		            // Thêm dòng mới vào bảng
		            productModel.addRow(new Object[] {
		                productId, productName, productPrice, productQuantity
		            });
		        }
		    }
		});

		ProductInShopTable.setBounds(388, 34, 591, 289);
		frame.getContentPane().add(ProductInShopTable);
		
		JLabel PromotionInShopLabel = new JLabel("Danh sách khuyến mãi trong cửa hàng");
		PromotionInShopLabel.setBounds(393, 335, 245, 16);
		frame.getContentPane().add(PromotionInShopLabel);
		
		PromotionInshopTable = new JTable();
		PromotionInshopTable.setBounds(388, 363, 591, 210);
		frame.getContentPane().add(PromotionInshopTable);
		
		populateProductTable();
	}
	
	private void populateProductTable() {
	    ProductManagementImpl productManagement = new ProductManagementImpl();
	    ArrayList<Production> products = productManagement.getAllProducts();

	    if (products == null || products.isEmpty()) {
	        javax.swing.JOptionPane.showMessageDialog(frame, "Không có sản phẩm trong cửa hàng!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    String[] tableHeaders = { "ID", "Tên sản phẩm", "Giá", "Số lượng", "Thương hiệu" };

	    DefaultTableModel model = new DefaultTableModel(tableHeaders, 0) {
	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            switch (columnIndex) {
	                case 0: return Integer.class;   // ID
	                case 1: return String.class;    // Tên sản phẩm
	                case 2: return Double.class;    // Giá
	                case 3: return Integer.class;   // Số lượng
	                case 4: return String.class;    // Thương hiệu
	                default: return Object.class;
	            }
	        }
	    };

	    // Duyệt qua danh sách sản phẩm và thêm vào bảng
	    for (Production product : products) {
	        model.addRow(new Object[] {
	            product.getId(),
	            product.getName(),
	            product.getPrice(),
	            product.getQuantity(),
	            product.getBrand()
	        });
	    }

	    // Cập nhật model vào bảng
	    ProductInShopTable.setModel(model);

	    // Cấu hình độ rộng các cột
	    ProductInShopTable.getColumnModel().getColumn(0).setPreferredWidth(20);
	    ProductInShopTable.getColumnModel().getColumn(1).setPreferredWidth(150);
	    ProductInShopTable.getColumnModel().getColumn(2).setPreferredWidth(100);
	    ProductInShopTable.getColumnModel().getColumn(3).setPreferredWidth(80);
	    ProductInShopTable.getColumnModel().getColumn(4).setPreferredWidth(120);

	    // Canh giữa các cột
	    JTableHeader tableHeader = ProductInShopTable.getTableHeader();
	    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
	    headerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	    for (int i = 0; i < ProductInShopTable.getColumnCount(); i++) {
	        ProductInShopTable.getColumnModel().getColumn(i).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
	            @Override
	            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                ((javax.swing.JLabel) c).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	                return c;
	            }
	        });
	    }

	    // Đặt độ rộng tối thiểu và tối đa cho các cột (nếu cần)
	    ProductInShopTable.getColumnModel().getColumn(0).setMinWidth(50);
	    ProductInShopTable.getColumnModel().getColumn(4).setMaxWidth(200);
	    
	    String[] productTableHeaders = { "ID", "Tên sản phẩm", "Giá", "Số lượng" };
	    DefaultTableModel productModel = new DefaultTableModel(productTableHeaders, 0) {
	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            switch (columnIndex) {
	                case 0: return String.class;   // ID
	                case 1: return String.class;   // Tên sản phẩm
	                case 2: return Double.class;   // Giá
	                case 3: return Integer.class;  // Số lượng
	                default: return Object.class;
	            }
	        }
	    };
	    tableProduct.setModel(productModel);

	    
	}

}
