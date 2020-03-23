package com.yezd.xpcrt.dao.entity;

import com.yezd.xpcrt.dto.entity.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "xpcrt", catalog = "")
public class ProductEntity {
    private int id;
    private String name;
    private String type;
    private String capacity;
    private String brand;
    private String stock;
    private BigDecimal facevalue;
    private BigDecimal retailprice;
    private BigDecimal purchaseprice;
    private String discount;

    public ProductEntity(ProductDTO product) {
        this.name = product.getName();
        this.type = product.getType();
        this.capacity = product.getCapacity();
        this.brand = product.getBrand();
        this.stock = product.getStock();
        this.facevalue = product.getFacevalue();
        this.retailprice = product.getRetailprice();
        this.purchaseprice = product.getPurchaseprice();
        this.discount = product.getDiscount();
    }

    public ProductEntity() {

    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "capacity")
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "stock")
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "facevalue")
    public BigDecimal getFacevalue() {
        return facevalue;
    }

    public void setFacevalue(BigDecimal facevalue) {
        this.facevalue = facevalue;
    }

    @Basic
    @Column(name = "retailprice")
    public BigDecimal getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(BigDecimal retailprice) {
        this.retailprice = retailprice;
    }

    @Basic
    @Column(name = "purchaseprice")
    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    @Basic
    @Column(name = "discount")
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(capacity, that.capacity) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(facevalue, that.facevalue) &&
                Objects.equals(retailprice, that.retailprice) &&
                Objects.equals(purchaseprice, that.purchaseprice) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, capacity, brand, stock, facevalue, retailprice, purchaseprice, discount);
    }


}
