package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import controller.impl.*;
import model.Role;
import model.User;
public class UserManager {

	private JFrame frame;
	private JTextField idTextFied;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField userNameTextFeid;
	private JTextField passwordTextFeid;
	private JTextField sdtTextFeid;
	private JTextField roleTextFeid;
	private JTable tableUser;
	private UserManagementImpl userManager = new UserManagementImpl() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManager window = new UserManager();
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
	public UserManager() {
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
		panel.setBounds(25, 74, 273, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin ");
		lblNewLabel.setBounds(106, 5, 74, 16);
		panel.add(lblNewLabel);
		
		idTextFied = new JTextField();
		idTextFied.setBounds(106, 33, 150, 26);
		panel.add(idTextFied);
		idTextFied.setColumns(10);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(17, 38, 61, 16);
		panel.add(idLabel);
		
		JLabel nameLabel = new JLabel("Họ Và Tên");
		nameLabel.setBounds(17, 66, 85, 16);
		panel.add(nameLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(17, 93, 61, 16);
		panel.add(emailLabel);
		
		JLabel userNameLabel = new JLabel("UserName");
		userNameLabel.setBounds(17, 121, 74, 16);
		panel.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("PassWord");
		passwordLabel.setBounds(17, 149, 61, 16);
		panel.add(passwordLabel);
		
		JLabel sdtLabel = new JLabel("SĐT");
		sdtLabel.setBounds(17, 177, 61, 16);
		panel.add(sdtLabel);
		
		JLabel roleLabel = new JLabel("Vai Trò");
		roleLabel.setBounds(17, 203, 61, 16);
		panel.add(roleLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(106, 61, 150, 26);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(106, 88, 150, 26);
		panel.add(emailTextField);
		
		userNameTextFeid = new JTextField();
		userNameTextFeid.setColumns(10);
		userNameTextFeid.setBounds(106, 116, 150, 26);
		panel.add(userNameTextFeid);
		
		passwordTextFeid = new JTextField();
		passwordTextFeid.setColumns(10);
		passwordTextFeid.setBounds(106, 144, 150, 26);
		panel.add(passwordTextFeid);
		
		sdtTextFeid = new JTextField();
		sdtTextFeid.setColumns(10);
		sdtTextFeid.setBounds(106, 172, 150, 26);
		panel.add(sdtTextFeid);
		
		roleTextFeid = new JTextField();
		roleTextFeid.setColumns(10);
		roleTextFeid.setBounds(106, 198, 150, 26);
		panel.add(roleTextFeid);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(188, 188, 188));
		panel_1.setBounds(25, 326, 273, 165);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chức năng");
		lblNewLabel_1.setBounds(106, 5, 86, 16);
		panel_1.add(lblNewLabel_1);
		
		JButton addUserButton = new JButton("Thêm nhân viên");
		addUserButton.setBounds(41, 33, 189, 29);
		panel_1.add(addUserButton);
		// Thêm ActionListener cho nút
		addUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addUser();
			}
		});
		JButton updateUserButton = new JButton("Sửa thông tin nhân viên");
		updateUserButton.setBounds(41, 72, 189, 29);
		panel_1.add(updateUserButton);
		updateUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
		
		JButton deleteUserButton = new JButton("Xóa nhân viên");
		deleteUserButton.setBounds(41, 113, 189, 29);
		panel_1.add(deleteUserButton);
		deleteUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(188, 188, 188));
		panel_2.setBounds(25, 19, 1104, 43);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel titlePage = new JLabel("Quản lý nhân viên");
		titlePage.setBounds(41, 6, 138, 31);
		panel_2.add(titlePage);
		
		JButton btnNewButton = new JButton("Quay lại");
		btnNewButton.setBounds(1003, 8, 95, 29);
		panel_2.add(btnNewButton);
		
		tableUser = new JTable();
		tableUser.setBounds(310, 74, 819, 417);
		frame.getContentPane().add(tableUser);


		String[] columns = {"ID", "Họ và Tên ", "Email", "Username", "Phone", "Phone" , "Role"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);  // Thiết lập tiêu đề cột
		tableUser.setModel(model);


		// Call displayUserTable to fill the table with data
		displayUserTable();

		
	}
	
	private void displayUserTable() {
	    // Lấy danh sách người dùng từ UserManagementImpl
	    boolean result = userManager.showUser();
	    if (!result) {
	        System.out.println("Không có người dùng nào để hiển thị.");
	        return;
	    }

	    try {
	        // Giả sử bạn có phương thức getAll() trong UserDAO trả về danh sách người dùng
	        List<User> users = userManager.getAllUser();  // Lấy danh sách người dùng từ UserDAO

	        // Cấu trúc dữ liệu để hiển thị trong JTable
	        String[] columns = {"ID", "Họ và Tên", "Email", "Username", "Password", "Phone", "Role"};
	        Object[][] data = new Object[users.size()][columns.length];

	        // Điền dữ liệu vào mảng data từ danh sách người dùng
	        for (int i = 0; i < users.size(); i++) {
	            User user = users.get(i);
	            data[i][0] = user.getId();
	            data[i][1] = user.getFullname();
	            data[i][2] = user.getEmail();
	            data[i][3] = user.getUsername();
	            data[i][4] = user.getPassword();
	            data[i][5] = user.getPhone();
	            data[i][6] = user.getRole().toString(); // Giả sử Role có phương thức toString()
	        }

	        // Tạo DefaultTableModel và thiết lập dữ liệu vào JTable
	        DefaultTableModel model = new DefaultTableModel(data, columns);
	        tableUser.setModel(model);
	        model.setColumnIdentifiers(columns);

	        // Thiết lập màu sắc vạch ngăn cách các cột thành màu đen
	        tableUser.setGridColor(Color.BLACK); // Chỉnh vạch ngăn cách thành màu đen

	        // Nếu muốn thay đổi màu sắc đường viền của bảng, có thể sử dụng:
	        tableUser.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Viền bảng màu đen

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Lỗi khi hiển thị người dùng.");
	    }
	    
	}

	private void addUser() {
	    // Lấy thông tin từ các TextField
	    String id = idTextFied.getText().trim();
	    String name = nameTextField.getText().trim();
	    String email = emailTextField.getText().trim();
	    String username = userNameTextFeid.getText().trim();
	    String password = passwordTextFeid.getText().trim();
	    String phone = sdtTextFeid.getText().trim();
	    String role = roleTextFeid.getText().trim();
	    
	    // Kiểm tra các trường thông tin đã nhập hợp lệ
	    if (id.isEmpty() || name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || phone.isEmpty() || role.isEmpty()) {
	        System.out.println("Vui lòng điền đầy đủ thông tin.");
	        return;
	    }
	    
	    // Tạo đối tượng User mới
	    User newUser;
	    if(role.equalsIgnoreCase("admin")) {
	    	newUser = new User(id, name, email, username, password, phone, Role.ADMIN); 
	    }else {
	    	 newUser = new User(id, name, email, username, password, phone, Role.USER); 
	    }
	  
		// Gọi phương thức thêm nhân viên từ lớp UserManagementImpl
	    boolean isAdded = userManager.addUser(newUser);
	    
	   
	    if (isAdded) {
	        // Thông báo thành công
	        JOptionPane.showMessageDialog(frame, "Thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        displayUserTable();
	    } else {
	        // Thông báo lỗi khi thêm không thành công
	        JOptionPane.showMessageDialog(frame, "Lỗi khi thêm nhân viên. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }

	}

	private void updateUser() {
	    // Lấy thông tin từ các TextField
	    String id = idTextFied.getText().trim();
	    String name = nameTextField.getText().trim();
	    String email = emailTextField.getText().trim();
	    String username = userNameTextFeid.getText().trim();
	    String password = passwordTextFeid.getText().trim();
	    String phone = sdtTextFeid.getText().trim();
	    String role = roleTextFeid.getText().trim();
	    
	    // Kiểm tra các trường thông tin đã nhập hợp lệ
	    if (id.isEmpty() || name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || phone.isEmpty() || role.isEmpty()) {
	        // Thông báo lỗi nếu có trường trống
	        JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Tạo đối tượng User mới với thông tin đã sửa
	    User updatedUser;
	    if (role.equalsIgnoreCase("admin")) {
	        updatedUser = new User(id, name, email, username, password, phone, Role.ADMIN);
	    } else {
	        updatedUser = new User(id, name, email, username, password, phone, Role.USER);
	    }

	    // Gọi phương thức sửa thông tin người dùng từ lớp UserManagementImpl
	    boolean isUpdated = userManager.updateUser(updatedUser);

	    // Hiển thị thông báo thành công hoặc thất bại
	    if (isUpdated) {
	        // Thông báo thành công
	        JOptionPane.showMessageDialog(frame, "Cập nhật thông tin nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        displayUserTable();
	    } else {
	        // Thông báo lỗi khi cập nhật không thành công
	        JOptionPane.showMessageDialog(frame, "Lỗi khi cập nhật thông tin nhân viên. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void deleteUser() {
	    // Hiển thị hộp thoại nhập ID của nhân viên cần xóa
	    String id = JOptionPane.showInputDialog(frame, "Nhập ID nhân viên cần xóa:");

	    // Kiểm tra id có hợp lệ hay không
	    if (id == null || id.trim().isEmpty()) {
	        // Thông báo lỗi nếu không có id
	        JOptionPane.showMessageDialog(frame, "Vui lòng nhập ID nhân viên cần xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Gọi phương thức xóa nhân viên từ lớp UserManagementImpl
	    boolean isDeleted = userManager.deleteUser(id.trim());

	    // Hiển thị thông báo thành công hoặc thất bại
	    if (isDeleted) {
	        // Thông báo thành công
	        JOptionPane.showMessageDialog(frame, "Xóa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        displayUserTable(); // Hiển thị lại bảng danh sách nhân viên sau khi xóa
	    } else {
	        // Thông báo lỗi khi xóa không thành công
	        JOptionPane.showMessageDialog(frame, "Lỗi khi xóa nhân viên. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}



}




