package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.List;

import dao.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class RevenueStatisticsView extends JFrame {

    private JComboBox<Integer> yearSelector;
    private JButton btnMonthlyRevenue, btnYearlyRevenue;
    private JPanel chartPanel, controlPanel;
    private BillDAO billDAO;
    private JLabel yearLabel;
    private JButton btnReturn;

    public RevenueStatisticsView() {
        billDAO = new BillDAO();
        initUI();
        loadMonthlyChart(Year.now().getValue()); // Hiển thị biểu đồ theo tháng của năm hiện tại khi giao diện khởi động
    }

    private void initUI() {
        setTitle("Revenue Statistics");
        setSize(800, 600);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Control Panel
        controlPanel = new JPanel();
        btnYearlyRevenue = new JButton("THỐNG KÊ THEO NĂM");
        yearLabel = new JLabel("Chọn Năm:");
        yearSelector = new JComboBox<>(getRecentYears(10));
        btnMonthlyRevenue = new JButton("THỐNG KÊ THEO THÁNG");

        // Add listeners
        btnMonthlyRevenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yearLabel.setVisible(true); // Hiển thị nhãn "Chọn Năm"
                yearSelector.setVisible(true); // Hiển thị ComboBox "Chọn Năm"
                int selectedYear = (int) yearSelector.getSelectedItem();
                loadMonthlyChart(selectedYear); // Cập nhật biểu đồ theo tháng
            }
        });

        controlPanel.add(btnMonthlyRevenue);
        
        controlPanel.add(btnYearlyRevenue);
        controlPanel.add(yearLabel);
        controlPanel.add(yearSelector);

        btnReturn = new JButton("Quay lại");
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng cửa sổ hiện tại
            }
        });
        controlPanel.add(btnReturn);

        getContentPane().add(controlPanel, BorderLayout.NORTH);

        yearSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedYear = (int) yearSelector.getSelectedItem();
                loadMonthlyChart(selectedYear);
            }
        });

        btnYearlyRevenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yearLabel.setVisible(false); // Ẩn nhãn "Chọn Năm"
                yearSelector.setVisible(false); // Ẩn ComboBox "Chọn Năm"
                loadYearlyChart(); // Cập nhật biểu đồ theo năm
            }
        });

        // Khởi tạo chartPanel (nếu chưa khởi tạo)
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        getContentPane().add(chartPanel, BorderLayout.CENTER);
    }

    // Lấy danh sách 10 năm gần nhất
    private Integer[] getRecentYears(int numberOfYears) {
        int currentYear = Year.now().getValue();
        Integer[] years = new Integer[numberOfYears];
        for (int i = 0; i < numberOfYears; i++) {
            years[i] = currentYear - i;
        }
        return years;
    }

    // Load biểu đồ doanh thu theo tháng cho năm đã chọn
    private void loadMonthlyChart(int year) {
        List<RevenueData> revenueData = billDAO.getRevenueByMonth(year);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int month = 1; month <= 12; month++) {
            final int tempMonth = month;
            double revenue = revenueData.stream()
                    .filter(data -> data.getPeriod() == tempMonth)
                    .map(RevenueData::getTotalRevenue)
                    .findFirst()
                    .orElse(0.0);
            dataset.addValue(revenue, "Revenue", "Tháng " + month);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh Thu Theo Tháng - Năm " + year,
                "Tháng",
                "Doanh Thu",
                dataset
        );

        // Xoay nhãn trục X
        CategoryPlot plot = barChart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(
            CategoryLabelPositions.UP_45 // Xoay 45 độ
        );

        updateChart(barChart);
    }

    // Load biểu đồ doanh thu của 10 năm gần nhất
    private void loadYearlyChart() {
        List<RevenueData> revenueData = billDAO.getRevenueByYear();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int year : getRecentYears(10)) { // Duyệt qua tất cả các năm
            double revenue = revenueData.stream()
                    .filter(data -> data.getPeriod() == year)
                    .map(RevenueData::getTotalRevenue)
                    .findFirst()
                    .orElse(0.0); // Doanh thu mặc định là 0 nếu không có dữ liệu
            dataset.addValue(revenue, "Revenue", "Năm " + year);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh Thu 10 Năm Gần Nhất",
                "Năm",
                "Doanh Thu",
                dataset
        );

        // Xoay nhãn trục X
        CategoryPlot plot = barChart.getCategoryPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(
            CategoryLabelPositions.UP_45 // Xoay 45 độ
        );

        updateChart(barChart);
    }

    // Hiển thị biểu đồ mới
    private void updateChart(JFreeChart chart) {
        if (chartPanel != null) {  // Kiểm tra chartPanel đã được khởi tạo chưa
            chartPanel.removeAll();
            ChartPanel chartPanelComponent = new ChartPanel(chart);
            chartPanel.add(chartPanelComponent, BorderLayout.CENTER);
            chartPanel.validate();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RevenueStatisticsView view = new RevenueStatisticsView();
            view.setVisible(true);
        });
    }
}
