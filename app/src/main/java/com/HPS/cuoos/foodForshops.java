package com.HPS.cuoos;

public class foodForshops {
    String key;
    String resName;
    public String fKey;
    String hPrice;
    String fPrice;

    public foodForshops() {
    }

    public foodForshops(String key, String resName, String fKey, String hPrice, String fPrice) {
        this.key = key;
        this.resName = resName;
        this.fKey = fKey;
        this.hPrice = hPrice;
        this.fPrice = fPrice;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getResName() {
        return resName;
    }

    public void setResKey(String resKey) {
        this.resName = resKey;
    }

    public String getfKey() {
        return fKey;
    }

    public void setfKey(String fKey) {
        this.fKey = fKey;
    }

    public String gethPrice() {
        return hPrice;
    }

    public void sethPrice(String hPrice) {
        this.hPrice = hPrice;
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }
}
