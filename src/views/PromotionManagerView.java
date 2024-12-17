package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import controller.impl.*;
import model.Promotion;;
public class PromotionManagerView {

	private JFrame frame;
	private JTextField idPmTextFied;
	private JTextField idPdTextField;
	private JTextField startTextField;
	private JTextField endTextFeid;
	private JTextField conTextFeid;
	private JTextField desTextFeid;
	private JTable tablePromotion;
	private PromotionManagementImpl promotionManager = new PromotionManagementImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromotionManagerView window = new PromotionManagerView();
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
	public PromotionManagerView() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188, 188, 188));
		panel.setBounds(10, 77, 273, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN");
		lblNewLabel.setBounds(102, 10, 74, 16);
		panel.add(lblNewLabel);
		
		idPmTextFied = new JTextField();
		idPmTextFied.setBounds(113, 36, 150, 26);
		panel.add(idPmTextFied);
		idPmTextFied.setColumns(10);
		
		JLabel idLabel = new JLabel("Mã khuyến mãi");
		idLabel.setBounds(24, 41, 79, 16);
		panel.add(idLabel);
		
		JLabel nameLabel = new JLabel("Mã sản phẩm");
		nameLabel.setBounds(24, 72, 85, 16);
		panel.add(nameLabel);
		
		JLabel emailLabel = new JLabel("T.gian bắt đầu");
		emailLabel.setBounds(24, 103, 79, 16);
		panel.add(emailLabel);
		
		JLabel userNameLabel = new JLabel("T.gian kết thúc");
		userNameLabel.setBounds(24, 134, 74, 16);
		panel.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("Điều kiện");
		passwordLabel.setBounds(24, 165, 61, 16);
		panel.add(passwordLabel);
		
		JLabel sdtLabel = new JLabel("Mô tả");
		sdtLabel.setBounds(24, 196, 61, 16);
		panel.add(sdtLabel);
		
		idPdTextField = new JTextField();
		idPdTextField.setBounds(113, 67, 150, 26);
		panel.add(idPdTextField);
		idPdTextField.setColumns(10);
		
		startTextField = new JTextField();
		startTextField.setColumns(10);
		startTextField.setBounds(113, 98, 150, 26);
		panel.add(startTextField);
		
		endTextFeid = new JTextField();
		endTextFeid.setColumns(10);
		endTextFeid.setBounds(113, 129, 150, 26);
		panel.add(endTextFeid);
		
		conTextFeid = new JTextField();
		conTextFeid.setColumns(10);
		conTextFeid.setBounds(113, 160, 150, 26);
		panel.add(conTextFeid);
		
		desTextFeid = new JTextField();
		desTextFeid.setColumns(10);
		desTextFeid.setBounds(113, 191, 150, 26);
		panel.add(desTextFeid);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(188, 188, 188));
		panel_1.setBounds(10, 327, 273, 165);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CHỨC NĂNG");
		lblNewLabel_1.setBounds(106, 5, 86, 16);
		panel_1.add(lblNewLabel_1);
		
		JButton addBtn = new JButton("Thêm");
		addBtn.setBounds(10, 56, 78, 29);
		panel_1.add(addBtn);
		// Thêm ActionListener cho nút
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					addPromotion();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		JButton updateBtn = new JButton("Sửa");
		updateBtn.setBounds(98, 56, 78, 29);
		panel_1.add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					updatePromotion();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton deleteBtn = new JButton("Xóa");
		deleteBtn.setBounds(186, 56, 78, 29);
		panel_1.add(deleteBtn);
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deletePromotion();
			}
		});
		
		
		JButton viewBtn = new JButton("Xem danh sách");
		viewBtn.setBounds(64, 106, 143, 29);
		panel_1.add(viewBtn);
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPromotionTable();
			}
		});

		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(188, 188, 188));
		panel_2.setBounds(10, 20, 1104, 43);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel titlePage = new JLabel("QUẢN LÝ KHUYẾN MÃI");
		titlePage.setBounds(41, 6, 138, 31);
		panel_2.add(titlePage);
		
		JButton btnNewButton = new JButton("Hủy");
		btnNewButton.setBounds(985, 7, 95, 29);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		tablePromotion = new JTable();
		tablePromotion.setBounds(295, 75, 819, 417);
		frame.getContentPane().add(tablePromotion);


		String[] columns = {"Mã khuyến mãi", "Thời gian bắt đầu", "Thời gian kết thúc", "Điều kiện", "Mô tả"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);  // Thiết lập tiêu đề cột
		tablePromotion.setModel(model);

		// Thiết lập thuộc tính cho bảng (nếu cần)
		tablePromotion.setGridColor(Color.BLACK); // Vạch ngăn cách màu đen
		tablePromotion.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Viền bảng màu đen
		
		// Tạo JScrollPane chứa bảng
		JScrollPane scrollPane = new JScrollPane(tablePromotion);
		scrollPane.setBounds(310, 74, 819, 417); // Đặt kích thước và vị trí
		frame.getContentPane().add(scrollPane); // Thêm JScrollPane vào giao diện
		

		// Call displayUserTable to fill the table with data
		displayPromotionTable();

	    // Thêm Listener để xử lý sự kiện chọn hàng
	    tablePromotion.getSelectionModel().addListSelectionListener(event -> {
	        if (!event.getValueIsAdjusting()) {
	            fillPromotionDetails(); // Gọi phương thức hiển thị thông tin
	        }
	    });
	}
	
	private void displayPromotionTable() {
	    // Lấy danh sách khuyến mãi
	    List<Promotion> promotions = promotionManager.getAllPromotions();
	    if (promotions == null) {
	        System.out.println("Không có khuyến mãi nào được tạo.");
	        return;
	    }

	    try {

	        // Cấu trúc dữ liệu để hiển thị trong JTable
			String[] columns = {"Mã khuyến mãi", "Thời gian bắt đầu", "Thời gian kết thúc", "Điều kiện", "Mô tả"};
	        Object[][] data = new Object[promotions.size()][columns.length];

	        // Điền dữ liệu vào mảng data từ danh sách khuyến mãi
	        for (int i = 0; i < promotions.size(); i++) {
	            Promotion pm = promotions.get(i);
	            data[i][0] = pm.getIdofpromotion();
	            data[i][1] = pm.getStart();
	            data[i][2] = pm.getEnd();
	            data[i][3] = pm.getCondition();
	            data[i][4] = pm.getDescription();
	        }

	        // Tạo DefaultTableModel và thiết lập dữ liệu vào JTable
	        DefaultTableModel model = new DefaultTableModel(data, columns);
	        tablePromotion.setModel(model);
	        model.setColumnIdentifiers(columns);

	        // Thiết lập màu sắc vạch ngăn cách các cột thành màu đen
	        tablePromotion.setGridColor(Color.BLACK); // Chỉnh vạch ngăn cách thành màu đen

	        // Nếu muốn thay đổi màu sắc đường viền của bảng, có thể sử dụng:
	        tablePromotion.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Viền bảng màu đen

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Lỗi khi hiển thị khuyến mãi.");
	    }
	    
	}
	
	private void fillPromotionDetails() {
	    int selectedRow = tablePromotion.getSelectedRow(); // Lấy chỉ số hàng được chọn
	    if (selectedRow >= 0) {
	        // Lấy dữ liệu từ hàng được chọn và điền vào các JTextField
	        idPmTextFied.setText(tablePromotion.getValueAt(selectedRow, 0).toString());
	        startTextField.setText(tablePromotion.getValueAt(selectedRow, 1).toString());
	        endTextFeid.setText(tablePromotion.getValueAt(selectedRow, 2).toString());
	        conTextFeid.setText(tablePromotion.getValueAt(selectedRow, 3).toString());
	        desTextFeid.setText(tablePromotion.getValueAt(selectedRow, 4).toString());
	    }
	}

	private void addPromotion() throws ParseException {
	    // Lấy thông tin từ các TextField
	    String idOfPm = idPmTextFied.getText().trim();
	    String idOfPd = idPdTextField.getText().trim();
	    String start = startTextField.getText().trim();
	    String end = endTextFeid.getText().trim();
	    String condition = conTextFeid.getText().trim();
	    String description = desTextFeid.getText().trim();
	    
	    // Kiểm tra các trường thông tin đã nhập hợp lệ
	    if (idOfPm.isEmpty() || idOfPd.isEmpty() || start.isEmpty() || start.isEmpty() || end.isEmpty() || condition.isEmpty() || description.isEmpty()) {
	        System.out.println("Vui lòng điền đầy đủ thông tin.");
	        return;
	    }
	    
	    // Tạo đối tượng Promotion mới
	    Promotion newPm; 
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = formatter.parse(start);
			Date endDate = formatter.parse(end);
        
	    newPm = new Promotion(idOfPm, startDate, endDate, condition, description); 
	  
		// Gọi phương thức thêm Khuyến mãi
	    boolean isAdded = promotionManager.addPromotion(newPm);
	    
	   
	    if (isAdded) {
	        // Thông báo thành công
	        JOptionPane.showMessageDialog(frame, "Thêm khuyến mãi thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        displayPromotionTable();
	    } else {
	        // Thông báo lỗi khi thêm không thành công
	        JOptionPane.showMessageDialog(frame, "Lỗi khi thêm khuyến mãi. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }

	}

	private void updatePromotion() throws ParseException {
		// Lấy thông tin từ các TextField
	    String idOfPm = idPmTextFied.getText().trim();
	    String idOfPd = idPdTextField.getText().trim();
	    String start = startTextField.getText().trim();
	    String end = endTextFeid.getText().trim();
	    String condition = conTextFeid.getText().trim();
	    String description = desTextFeid.getText().trim();
	    
	    // Kiểm tra các trường thông tin đã nhập hợp lệ
	    if (idOfPm.isEmpty() || idOfPd.isEmpty() || start.isEmpty() || start.isEmpty() || end.isEmpty() || condition.isEmpty() || description.isEmpty()) {
	        System.out.println("Vui lòng điền đầy đủ thông tin.");
	        return;
	    }
	    
	    // Tạo đối tượng Promotion mới
	    Promotion newPm; 
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = formatter.parse(start);
			Date endDate = formatter.parse(end);
        
	    newPm = new Promotion(idOfPm, startDate, endDate, condition, description); 
	  
	    // Gọi phương thức sửa thông tin
	    boolean isUpdated = promotionManager.updatePromotion(newPm);

	    // Hiển thị thông báo thành công hoặc thất bại
	    if (isUpdated) {
	        // Thông báo thành công
	        JOptionPane.showMessageDialog(frame, "Cập nhật thông tin khuyến mãi thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        displayPromotionTable();
	    } else {
	        // Thông báo lỗi khi cập nhật không thành công
	        JOptionPane.showMessageDialog(frame, "Lỗi khi cập nhật thông tin khuyến mãi. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void deletePromotion() {
	    // Lấy chỉ số hàng được chọn
	    int selectedRow = tablePromotion.getSelectedRow();
	    
	    // Kiểm tra xem người dùng đã chọn hàng nào chưa
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(frame, "Vui lòng chọn một khuyến mãi để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    // Lấy ID khuyến mãi từ hàng được chọn (giả định ID ở cột 0)
	    String idOfPm = tablePromotion.getValueAt(selectedRow, 0).toString();
	    
	    // Hiển thị hộp thoại xác nhận với nút tùy chỉnh
	    String[] options = {"Xác nhận xóa", "Hủy"}; // Tùy chỉnh nút
	    int confirm = JOptionPane.showOptionDialog(
	        frame, 
	        "Bạn có chắc chắn muốn xóa khuyến mãi này không?", // Nội dung thông báo
	        "Xác nhận xóa", // Tiêu đề hộp thoại
	        JOptionPane.DEFAULT_OPTION, // Loại hộp thoại
	        JOptionPane.QUESTION_MESSAGE, // Loại biểu tượng
	        null, // Icon (null để dùng icon mặc định)
	        options, // Danh sách tùy chọn
	        options[1] // Nút mặc định
	    );
	    
	    // Nếu người dùng chọn "Xác nhận xóa"
	    if (confirm == 0) {
	        boolean isDeleted = promotionManager.deletePromotion(idOfPm);
	        
	        // Thông báo kết quả xóa
	        if (isDeleted) {
	            JOptionPane.showMessageDialog(frame, "Xóa khuyến mãi thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            displayPromotionTable(); // Cập nhật lại bảng sau khi xóa
	        } else {
	            JOptionPane.showMessageDialog(frame, "Lỗi khi xóa khuyến mãi. Vui lòng thử lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    // Nếu người dùng chọn "Hủy", không làm gì cả.
	}


}




