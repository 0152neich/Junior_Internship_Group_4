package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
public class homePage {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage window = new homePage();
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
	public homePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 973, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(177, 177, 177));
		panel.setBounds(6, 6, 166, 418);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton billManageButton = new JButton("Quản lý đơn hàng");
		billManageButton.setBounds(0, 81, 160, 29);
		panel.add(billManageButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 6, 166, 37);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Các Chức Năng");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(177, 177, 177));
		panel_2.setBounds(214, 6, 135, 55);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel BrandLabel = new JLabel("Số thương hiệu");
		BrandLabel.setBounds(23, 6, 123, 16);
		panel_2.add(BrandLabel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(177, 177, 177));
		panel_2_1.setBounds(419, 6, 135, 55);
		frame.getContentPane().add(panel_2_1);
		
		JLabel productLabel = new JLabel("Số sản phẩm");
		productLabel.setBounds(27, 6, 108, 16);
		panel_2_1.add(productLabel);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(177, 177, 177));
		panel_2_2.setBounds(626, 6, 135, 55);
		frame.getContentPane().add(panel_2_2);
		
		JLabel lblNewLabel_1 = new JLabel("Số người dùng");
		lblNewLabel_1.setBounds(18, 6, 111, 16);
		panel_2_2.add(lblNewLabel_1);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBackground(new Color(177, 177, 177));
		panel_2_3.setBounds(832, 6, 135, 55);
		frame.getContentPane().add(panel_2_3);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng doanh thu");
		lblNewLabel_2.setBounds(23, 6, 112, 16);
		panel_2_3.add(lblNewLabel_2);
		
		// Biểu đồ
        JPanel chartPanel = createChartPanel();
        chartPanel.setBounds(223, 88, 700, 300); // Đặt vị trí và kích thước của biểu đồ
        frame.getContentPane().add(chartPanel);
	}
	
	private JPanel createChartPanel() {
	    // Dữ liệu cho biểu đồ
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    dataset.setValue(10, "Doanh thu", "Tháng 1");
	    dataset.setValue(20, "Doanh thu", "Tháng 2");
	    dataset.setValue(15, "Doanh thu", "Tháng 3");

	    // Tạo biểu đồ cột
	    JFreeChart barChart = ChartFactory.createBarChart(
	            "Doanh thu hàng tháng", // Tiêu đề biểu đồ
	            "Tháng",                // Nhãn trục X
	            "Doanh thu",            // Nhãn trục Y
	            dataset                 // Dữ liệu
	    );

	    // Tạo và trả về một ChartPanel để chứa biểu đồ
	    return new ChartPanel(barChart);
	}
}
