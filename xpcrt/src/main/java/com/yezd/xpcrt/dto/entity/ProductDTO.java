package com.yezd.xpcrt.dto.entity;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private String type;
    private String capacity;
    private String brand;
    private String stock;
    private BigDecimal facevalue;
    private BigDecimal retailprice;
    private BigDecimal purchaseprice;
    private String discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public BigDecimal getFacevalue() {
        return facevalue;
    }

    public void setFacevalue(BigDecimal facevalue) {
        this.facevalue = facevalue;
    }

    public BigDecimal getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(BigDecimal retailprice) {
        this.retailprice = retailprice;
    }

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public ProductDTO(String name, String type, String capacity, String brand, String stock, BigDecimal facevalue, BigDecimal retailprice, BigDecimal purchaseprice, String discount) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.brand = brand;
        this.stock = stock;
        this.facevalue = facevalue;
        this.retailprice = retailprice;
        this.purchaseprice = purchaseprice;
        this.discount = discount;
    }
}
