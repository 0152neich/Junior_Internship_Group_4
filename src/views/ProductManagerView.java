package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.impl.ProductManagementImpl;
import model.*;

import java.awt.event.MouseEvent;

public class ProductManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProduction;
	private JTextField txtProduct_id;
	private JTextField txtProduct_name;
	private JTextField txtProduct_price;
	private JTextField txtProduct_quantity;
	private JTextField txtProduct_brand;

	private ProductManagementImpl pmi = new ProductManagementImpl();;
	private List<Production> productions;
	private String[] table_headers = { "Id", "Tên", "Gía", "Số lượng", "Thương hiệu" };
	private DefaultTableModel defaultTableModel;

	public ProductManagerView() {
		initComponents();
	}

	// Phương thức tạo ra 1 danh sách
	public void displayProductionTable() {
		productions = pmi.getAllProduction();

		boolean result = pmi.showProduct();
		if (!result) {
			System.out.println("Không có sản phẩm nào để hiển thị.");
			return;
		}

		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableProduction.setModel(defaultTableModel);

		for (int i = 0; i < table_headers.length; i++) {
			defaultTableModel.addColumn(table_headers[i]);
		}

		for (Production i : productions) {
			defaultTableModel
					.addRow(new Object[] { i.getId(), i.getName(), i.getPrice(), i.getQuantity(), i.getBrand() });
		}

		tableProduction.setVisible(true);
		defaultTableModel.fireTableDataChanged();
		tableProduction.repaint();
	}

	// Phương thức cập nhật các JTextField dựa trên dòng được chọn
	private void updateTextFields() {
		int selectedRow = tableProduction.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Choose 1 item please!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			txtProduct_id.setText(tableProduction.getValueAt(selectedRow, 0).toString());
			txtProduct_name.setText(tableProduction.getValueAt(selectedRow, 1).toString());
			txtProduct_price.setText(tableProduction.getValueAt(selectedRow, 2).toString());
			txtProduct_quantity.setText(tableProduction.getValueAt(selectedRow, 3).toString());
			txtProduct_brand.setText(tableProduction.getValueAt(selectedRow, 4).toString());
		}
	}

	public void xoaForm() {
		// TODO Auto-generated method stub
		this.txtProduct_id.setText("");
		this.txtProduct_name.setText("");
		this.txtProduct_price.setText("");
		this.txtProduct_quantity.setText("");
		this.txtProduct_brand.setText("");
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductManagerView.class.getResource("/icons/ypp.png")));
		setTitle("Quản lý sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1101, 662);
		setLocationRelativeTo(null); // background center

		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		try {
			// Thiết lập giao diện theo hệ điều hành
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(433, 81, 648, 534);
		contentPane.add(scrollPane);

		tableProduction = new JTable();
		tableProduction.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		tableProduction.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Id", "Tên", "Giá", "Số lượng", "Thương hiệu" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.Double.class,
					java.lang.Integer.class, java.lang.String.class, java.lang.Double.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		tableProduction.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableProduction.setRowHeight(30);
		tableProduction.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableProduction.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMouseClicked(evt);
			}
		});
		scrollPane.setViewportView(tableProduction);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 80, 413, 331);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 82, 138, 25);
		panel.add(lblNewLabel);

		JLabel lblTnSnPhm = new JLabel("Tên");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnSnPhm.setBounds(22, 130, 138, 25);
		panel.add(lblTnSnPhm);

		JLabel lblGiSnPhm = new JLabel("Giá");
		lblGiSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiSnPhm.setBounds(22, 171, 138, 25);
		panel.add(lblGiSnPhm);

		JLabel lblSLngSn = new JLabel("Số lượng");
		lblSLngSn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLngSn.setBounds(22, 212, 138, 25);
		panel.add(lblSLngSn);

		JLabel lblTnLaptop = new JLabel("Thương hiệu");
		lblTnLaptop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnLaptop.setBounds(22, 253, 138, 25);
		panel.add(lblTnLaptop);

		txtProduct_id = new JTextField();
		txtProduct_id.setBounds(170, 82, 232, 30);
		panel.add(txtProduct_id);
		txtProduct_id.setColumns(10);

		txtProduct_name = new JTextField();
		txtProduct_name.setColumns(10);
		txtProduct_name.setBounds(170, 124, 232, 30);
		panel.add(txtProduct_name);

		txtProduct_price = new JTextField();
		txtProduct_price.setColumns(10);
		txtProduct_price.setBounds(170, 166, 232, 30);
		panel.add(txtProduct_price);

		txtProduct_quantity = new JTextField();
		txtProduct_quantity.setColumns(10);
		txtProduct_quantity.setBounds(170, 208, 232, 30);
		panel.add(txtProduct_quantity);

		txtProduct_brand = new JTextField();
		txtProduct_brand.setColumns(10);
		txtProduct_brand.setBounds(170, 250, 232, 30);
		panel.add(txtProduct_brand);

		JLabel lblNewLabel_1 = new JLabel("Thông tin");
		lblNewLabel_1.setIcon(
				null);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(116, 12, 181, 32);
		panel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 372, 2);
		panel.add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(10, 422, 413, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(16, 53, 375, 15);
		panel_1.add(separator_1);

		JLabel lblNewLabel_1_1 = new JLabel("Chức năng");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\Colebemis-Feather-Tool.16.png"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(116, 10, 181, 32);
		panel_1.add(lblNewLabel_1_1);

//		 Thêm 1 Laptop vào danh sách
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		btnAdd.setIcon(
				null);
		btnAdd.setBounds(30, 77, 78, 32);
		panel_1.add(btnAdd);

		// Sửa 1 sản phẩm rong danh sách
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEditActionPerformed(evt);
			}
		});
		btnEdit.setIcon(null);
		btnEdit.setBounds(160, 77, 78, 32);
		panel_1.add(btnEdit);

		// Xóa 1 sản phẩm khỏi danh sách
		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDelActionPerformed(evt);
			}
		});
		btnDel.setIcon(null);
		btnDel.setBounds(294, 77, 97, 32);
		panel_1.add(btnDel);

		// Hiện 1 danh sách có sẵn 20 thông tin
		JButton btnList = new JButton("Xem danh sách");
		btnList.setIcon(
				null);
		btnList.setBounds(139, 136, 125, 32);
		panel_1.add(btnList);
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayProductionTable();
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(10, 10, 1071, 61);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitle = new JLabel("Quản lý sản phẩm");
		lblTitle.setIcon(null);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setBounds(10, 0, 433, 61);
		panel_3.add(lblTitle);
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(972, 11, 89, 37);
		panel_3.add(btnBack);
	}

	private void btnBackActionPerformed(MouseEvent e) {// GEN-FIRST:event_btnBackActionPerformed
//		new Dashboard().setVisible(true);
		this.dispose();
	}

	/**
	 * thông tin của row được lấy ra
	 * 
	 * @param evt
	 */
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		updateTextFields();
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Production production = new Production();

			production.setId(txtProduct_id.getText());
			production.setName(txtProduct_name.getText());
			production.setPrice(Double.parseDouble(txtProduct_price.getText()));
			production.setQuantity(Integer.parseInt(txtProduct_quantity.getText()));
			production.setBrand(txtProduct_brand.getText());

			int c = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm sản phẩm?");
			if (c == JOptionPane.OK_OPTION) {
				if (!pmi.addProduct(production)) {
					JOptionPane.showMessageDialog(this, "Lỗi khi thêm sản phẩm. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
					defaultTableModel.fireTableDataChanged();
					displayProductionTable();
				}
			} else {
				return;
			}
		} catch (NumberFormatException e) { // bắt lỗi nếu các trường bị để trống
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
		// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
		xoaForm();
	}

	private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			int selectedRow = tableProduction.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(tableProduction, "Vui lòng chọn 1 sản phẩm", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			Production production = new Production();

			production.setId(txtProduct_id.getText());
			production.setName(txtProduct_name.getText());
			production.setPrice(Double.parseDouble(txtProduct_price.getText()));
			production.setQuantity(Integer.parseInt(txtProduct_quantity.getText()));
			production.setBrand(txtProduct_brand.getText());

			int c = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa sản phẩm?");
			if (c == JOptionPane.OK_OPTION) {
				if (!pmi.updateProduct(production)) {
					JOptionPane.showMessageDialog(this, "Lỗi khi sửa sản phẩm. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
					defaultTableModel.fireTableDataChanged();
					displayProductionTable();
				}
			} else {
				return;
			}

		} catch (NumberFormatException e) { // bắt lỗi nếu các trường bị để trống
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
		// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
		xoaForm();
	}

	private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			int selectedRow = tableProduction.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(tableProduction, "Vui lòng chọn 1 sản phẩm", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			int c = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa sản phẩm?");
			if (c == JOptionPane.OK_OPTION) {
				if (!pmi.deleteProduct(txtProduct_id.getText())) {
					JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
				} else {

					JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
					defaultTableModel.fireTableDataChanged();
					displayProductionTable();
				}
			} else {
				return;
			}
		} catch (NumberFormatException e) { // bắt lỗi nếu các trường bị để trống
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}

		// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
		xoaForm();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManagerView frame = new ProductManagerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
