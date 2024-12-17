package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
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
import controller.impl.BillDetailsImpl;
import model.Production;
import java.awt.Font;

public class TopSaleProductView {

    private JFrame frame;
    private JTable tableTopSaleProduct;
    private BillDetailsImpl billDetail = new BillDetailsImpl();  // Sử dụng BillDetailsImpl
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TopSaleProductView window = new TopSaleProductView();
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
    public TopSaleProductView() {
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

        // Tạo panel chứa các nút "Top Ngày", "Top Tuần", "Top Tháng"
        JPanel panel = new JPanel();
        panel.setBackground(new Color(188, 188, 188));
        panel.setBounds(10, 75, 1104, 125);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Nút "Top Ngày"
        JButton btnTopDay = new JButton("Top Ngày");
        btnTopDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTopDay.setBounds(151, 40, 120, 50);
        panel.add(btnTopDay);

        // Nút "Top Tuần"
        JButton btnTopWeek = new JButton("Top tuần");
        btnTopWeek.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTopWeek.setBounds(469, 40, 120, 50);
        panel.add(btnTopWeek);

        // Nút "Top Tháng"
        JButton btnTopMonth = new JButton("Top Tháng");
        btnTopMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTopMonth.setBounds(787, 40, 138, 50);
        panel.add(btnTopMonth);

        // Tạo panel chứa tiêu đề
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(188, 188, 188));
        panel_2.setBounds(10, 22, 1104, 43);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        // Tiêu đề trang
        JLabel titlePage = new JLabel("XEM SẢN PHẨM BÁN CHẠY");
        titlePage.setBounds(41, 6, 138, 31);
        panel_2.add(titlePage);

        // Nút "Hủy"
        JButton btnCancel = new JButton("Hủy");
        btnCancel.setBounds(1003, 8, 95, 29);
        panel_2.add(btnCancel);

        // Tạo bảng hiển thị sản phẩm
        tableTopSaleProduct = new JTable();
        tableTopSaleProduct.setBounds(10, 210, 1104, 310);
        frame.getContentPane().add(tableTopSaleProduct);

        String[] columns = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng bán được"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);  // Thiết lập tiêu đề cột
        tableTopSaleProduct.setModel(model);

        // Sự kiện khi nhấn "Top Ngày"
        btnTopDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTable("day");  // Gọi phương thức để cập nhật bảng cho ngày
            }
        });

        // Sự kiện khi nhấn "Top Tuần"
        btnTopWeek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTable("week");  // Gọi phương thức để cập nhật bảng cho tuần
            }
        });

        // Sự kiện khi nhấn "Top Tháng"
        btnTopMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTable("month");  // Gọi phương thức để cập nhật bảng cho tháng
            }
        });

        // Sự kiện khi nhấn "Hủy"
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Đóng cửa sổ hiện tại
            }
        });
    }

 // Phương thức cập nhật bảng với dữ liệu từ phương thức getTopSoldProducts
    private void updateTable(String periodType) {
        try {
            // Lấy dữ liệu sản phẩm bán được theo ngày/tuần/tháng
            List<Object[]> topProducts = billDetail.getTopSoldProducts(periodType);

            // Kiểm tra nếu không có dữ liệu
            if (topProducts.isEmpty()) {
                // Hiển thị thông báo nếu không có sản phẩm
                JOptionPane.showMessageDialog(frame, "Hiện không có hóa đơn hay sản phẩm phù hợp!", 
                                              "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Xóa tất cả các dòng hiện tại trong bảng
                DefaultTableModel model = (DefaultTableModel) tableTopSaleProduct.getModel();
                model.setRowCount(0);

                // Duyệt qua dữ liệu và thêm vào bảng
                for (Object[] product : topProducts) {
                    String productId = (String) product[0];  // ID sản phẩm
                    String productName = (String) product[1];  // Tên sản phẩm
                    int totalSold = (int) product[2];  // Tổng số lượng bán

                    // Thêm dòng mới vào bảng
                    model.addRow(new Object[]{productId, productName, totalSold});
                }
            }
        } catch (RuntimeException e) {
            // Thông báo lỗi nếu không thể kết nối tới cơ sở dữ liệu
            JOptionPane.showMessageDialog(frame, e.getMessage(), 
                                          "Lỗi kết nối", JOptionPane.ERROR_MESSAGE);
        }
    }

}
