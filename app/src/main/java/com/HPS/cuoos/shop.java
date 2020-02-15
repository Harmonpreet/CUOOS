package com.HPS.cuoos;

public class shop {
    private String shopName;
    private String shopLocation;

    public shop() {
    }

    public shop(String shopName, String shopLocation) {
        this.shopName = shopName;
        this.shopLocation = shopLocation;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }
}
