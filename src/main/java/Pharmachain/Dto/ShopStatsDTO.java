package Pharmachain.Dto;

public class ShopStatsDTO {
    private String shopName;

    public ShopStatsDTO(String shopName, Double turnover) {
        this.shopName = shopName;
        this.turnover = turnover;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    private Double turnover;

}