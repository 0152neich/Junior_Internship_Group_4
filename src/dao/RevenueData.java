package dao;

public class RevenueData {
    private int period; // Tháng hoặc Năm
    private double totalRevenue;

    public RevenueData(int period, double totalRevenue) {
        this.period = period;
        this.totalRevenue = totalRevenue;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
