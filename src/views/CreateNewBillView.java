package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.orsoncharts.util.json.parser.ParseException;

import controller.impl.BillDetailsManagementImpl;
import controller.impl.BillManagementImpl;
import controller.impl.ProductManagementImpl;
import dao.ProductionDAO;
import dao.PromotionDAO;
import model.Bill;
import model.BillDetails;
import model.Production;
import model.Promotion;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class CreateNewBillView {
	private String idBill = "HD2";
	private JFrame frame;
	private JTextField textField;
	private JTextField nameCustomer_text;
	private JTextField phone_textFeid;
	private JTextField dateText;
	private JTable tableProduct;
	private JTable tablePromotion;
	private JTable ProductInShopTable;
	private JTable PromotionInshopTable;
	private PromotionDAO promotionManager ;
	private ArrayList<BillDetails> listCurrentDetailBill = new ArrayList() ;
	private ProductionDAO productManager = new ProductionDAO();
	/**
	 * Launch the application
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
		
		nameCustomer_text = new JTextField();
		nameCustomer_text.setColumns(10);
		nameCustomer_text.setBounds(141, 90, 188, 26);
		frame.getContentPane().add(nameCustomer_text);
		
		phone_textFeid = new JTextField();
		phone_textFeid.setColumns(10);
		phone_textFeid.setBounds(141, 135, 188, 26);
		frame.getContentPane().add(phone_textFeid);
		
		dateText = new JTextField();
		dateText.setColumns(10);
		dateText.setBounds(141, 179, 188, 26);
		frame.getContentPane().add(dateText);
		
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
		// Thêm ActionListener vào nút "Tạo"
		TaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					taoBill();
				} catch (java.text.ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
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
		    	int count = 1 ;
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
//		            productModel.setRowCount(0);
		            for (int i = 0; i < productModel.getRowCount(); i++) {
		                String existingProductId = productModel.getValueAt(i, 0).toString(); // Lấy productId từ cột 0
		                if (existingProductId.equals(productId)) {
		                    count++; // Tăng biến count nếu productId trùng
		                }
		            }
		            // Thêm dòng mới vào bảng
		            productModel.addRow(new Object[] {
		                productId, productName, productPrice, count
		            });
		            BillDetails billDetail = new BillDetails(productId,idBill,"2024-12-18",count);
		            int countNew = 0 ;
		            if(checkAvaiable(billDetail)) {
		            	countNew = billDetail.getCount() + 1 ;
		            	System.out.println(countNew);
		            	billDetail.setCount(countNew);
		            }else {
		            	listCurrentDetailBill.add(billDetail);
		            }
		            for(BillDetails b : listCurrentDetailBill) {
		            	System.out.println(b);
		            }
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
		frame.getContentPane().add(PromotionInshopTable);// Thêm MouseListener vào bảng PromotionInshopTable
		PromotionInshopTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        // Lấy dòng được chọn trong bảng PromotionInshopTable
		        int row = PromotionInshopTable.rowAtPoint(evt.getPoint());
		        if (row >= 0) {
		            // Lấy dữ liệu từ các cột trong bảng PromotionInshopTable
		            String promotionId = (String) PromotionInshopTable.getValueAt(row, 0); // Cột 0: ID
		            java.sql.Date startDate = (java.sql.Date) PromotionInshopTable.getValueAt(row, 1); // Cột 1: Start date
		            java.sql.Date endDate = (java.sql.Date) PromotionInshopTable.getValueAt(row, 2); // Cột 2: End date
		            String dieukien = (String) PromotionInshopTable.getValueAt(row, 3); // Cột 3: Dieukien
		            String description = (String) PromotionInshopTable.getValueAt(row, 4); // Cột 4: Description

		            // Kiểm tra kiểu dữ liệu của startDate và endDate (in ra console)
		            System.out.println("Kiểu dữ liệu của Start Date: " + (startDate != null ? startDate.getClass().getName() : "null"));
		            System.out.println("Kiểu dữ liệu của End Date: " + (endDate != null ? endDate.getClass().getName() : "null"));

		            try {
		                // Chuyển đổi startDate và endDate sang String nếu chúng không null
		                String startDateStr = (startDate != null) ? startDate.toString() : "N/A";
		                String endDateStr = (endDate != null) ? endDate.toString() : "N/A";

		                // Lấy DefaultTableModel của bảng tablePromotion
		                DefaultTableModel promotionModel = (DefaultTableModel) tablePromotion.getModel();
		                if (promotionModel != null) {
		                    // Thêm dòng mới vào bảng tablePromotion với dữ liệu vừa lấy từ PromotionInshopTable
		                    promotionModel.addRow(new Object[] {
		                        promotionId, startDateStr, endDateStr, dieukien, description
		                    });

		                    // In ra bảng sau khi thêm
		                    System.out.println("Dòng đã được thêm vào tablePromotion");
		                } else {
		                    // Nếu bảng chưa có DefaultTableModel, tạo mới và gán cho tablePromotion
		                    promotionModel = new DefaultTableModel(
		                        new Object[]{"ID", "Start Date", "End Date", "Dieukien", "Description"}, 0
		                    );
		                    tablePromotion.setModel(promotionModel);
		                    System.out.println("Bảng tablePromotion không có DefaultTableModel, đã tạo mới");
		                    
		                    // Sau đó thêm dòng vào bảng
		                    promotionModel.addRow(new Object[] {
		                        promotionId, startDateStr, endDateStr, dieukien, description
		                    });
		                }

		            } catch (Exception e) {
		                // In ra lỗi nếu có vấn đề trong quá trình thêm dòng vào bảng
		                e.printStackTrace();
		            }
		        }
		    }
		});







		populateProductTable();
		populatePromotionTable();

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

	private void populatePromotionTable() {
	    // Giả sử bạn đang sử dụng PromotionDAO để lấy danh sách các khuyến mãi
	    PromotionDAO promotionManager = new PromotionDAO();
	    ArrayList<Promotion> promotions = (ArrayList<Promotion>) promotionManager.getAllPromotions();

	    // Kiểm tra nếu không có khuyến mãi nào
	    if (promotions == null || promotions.isEmpty()) {
	        javax.swing.JOptionPane.showMessageDialog(frame, "Không có khuyến mãi trong cửa hàng!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    // Định nghĩa tiêu đề của các cột trong bảng khuyến mãi
	    String[] tableHeaders = { "ID","Ngày bắt đầu",  "Ngày kết thúc" , "Tên khuyến mãi", "Mô tả" };

	    // Tạo model cho bảng PromotionInshopTable
	    DefaultTableModel model = new DefaultTableModel(tableHeaders, 0) {
	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            switch (columnIndex) {
	                case 0: return String.class;   // ID
	                case 1: return String.class;   // Tên khuyến mãi
	                case 2: return String.class;   // Mô tả
	                case 3: return String.class;   // Ngày bắt đầu
	                case 4: return String.class;   // Ngày kết thúc
	                default: return Object.class;
	            }
	        }
	    };

	    // Duyệt qua danh sách khuyến mãi và thêm vào bảng
	    for (Promotion promotion : promotions) {
	        model.addRow(new Object[] {
	            promotion.getIdofpromotion(),
	            promotion.getStart(),
	            promotion.getEnd(),
	            promotion.getDescription(),
	            promotion.getCondition()
	        });
	    }

	    // Cập nhật model vào bảng PromotionInshopTable
	    PromotionInshopTable.setModel(model);

	    // Cấu hình độ rộng các cột trong bảng khuyến mãi
	    PromotionInshopTable.getColumnModel().getColumn(0).setPreferredWidth(50);
	    PromotionInshopTable.getColumnModel().getColumn(1).setPreferredWidth(150);
	    PromotionInshopTable.getColumnModel().getColumn(2).setPreferredWidth(200);
	    PromotionInshopTable.getColumnModel().getColumn(3).setPreferredWidth(100);
	    PromotionInshopTable.getColumnModel().getColumn(4).setPreferredWidth(100);

	    // Canh giữa các cột
	    JTableHeader tableHeader = PromotionInshopTable.getTableHeader();
	    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
	    headerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

	    for (int i = 0; i < PromotionInshopTable.getColumnCount(); i++) {
	        PromotionInshopTable.getColumnModel().getColumn(i).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
	            @Override
	            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                ((javax.swing.JLabel) c).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	                return c;
	            }
	        });
	    }
	}
	
	private boolean checkAvaiable(BillDetails billDetail) {
		for(BillDetails b : listCurrentDetailBill) {
			if(b.getIdProduct().equalsIgnoreCase(billDetail.getIdProduct())) {
				return true ;
			}
		}
		return false;
		
	}
	public BigDecimal TotalAmout() {
        int amout = 0;
        for (BillDetails b : listCurrentDetailBill) {
            ArrayList<Production> listpro;
            // Không còn null vì đã khởi tạo productManager
			listpro = (ArrayList<Production>) productManager.getAllSanPham();
			for (Production p : listpro) {
			    if (p.getId().equalsIgnoreCase(b.getIdProduct())) {
			        amout += p.getPrice() * b.getCount();
			    }
			}
        }
        return new BigDecimal(amout);
    }
	
	public int getQuality() {
		int quality = 0 ; 
		for(BillDetails b : listCurrentDetailBill) {
			quality += b.getCount();
		}
		return quality ; 
	}
	public void taoBill() throws java.text.ParseException {
	    String id = idBill; 
	    String userId = textField.getText();
	    String custemor = nameCustomer_text.getText();
	    String dateString = dateText.getText(); // Chuỗi ngày tháng từ TextField
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
	    java.util.Date date = null;

	    try {
	        // Chuyển đổi từ String sang java.util.Date
	        date =  dateFormat.parse(dateString);
	        
	        // Chuyển đổi từ java.util.Date sang java.sql.Date
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	        System.out.println("Ngày tháng sau khi chuyển đổi: " + sqlDate);

	        // Tính toán các giá trị khác
	        BigDecimal amount = TotalAmout();
	        int quality = this.getQuality();

	        // Tạo đối tượng Bill
	        Bill b = new Bill(id, sqlDate, amount, custemor, quality, userId);
	        BillManagementImpl manager = new BillManagementImpl();
	        manager.add(b);
	        BillDetailsManagementImpl bdmi = new BillDetailsManagementImpl() ; 
	        for(BillDetails bd : listCurrentDetailBill) {
	        	bdmi.add(bd);
	        }
	        
	        // Hiển thị thông báo thành công
	        JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

	    } catch (java.text.ParseException ex) {
	        // Thông báo lỗi khi không thể phân tích chuỗi ngày tháng
	        JOptionPane.showMessageDialog(null, "Định dạng ngày tháng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        // Thông báo lỗi khác (nếu có)
	        JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tạo hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}



}
