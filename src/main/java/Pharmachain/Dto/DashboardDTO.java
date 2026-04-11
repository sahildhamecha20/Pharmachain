package Pharmachain.Dto;

public class DashboardDTO {
    public long totalMedicines;
    public long outOfStock;
    public double todaySales;
    public double todayPurchases;

    public long getTotalMedicines() {
        return totalMedicines;
    }

    public void setTotalMedicines(long totalMedicines) {
        this.totalMedicines = totalMedicines;
    }

    public long getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(long outOfStock) {
        this.outOfStock = outOfStock;
    }

    public double getTodaySales() {
        return todaySales;
    }

    public void setTodaySales(double todaySales) {
        this.todaySales = todaySales;
    }

    public double getTodayPurchases() {
        return todayPurchases;
    }

    public void setTodayPurchases(double todayPurchases) {
        this.todayPurchases = todayPurchases;
    }
}