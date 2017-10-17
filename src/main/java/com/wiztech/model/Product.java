package com.wiztech.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Saddam
 */

@Entity
@Table(name="products")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long productID;
    private String name;
    private String type;
    private double quantity;
    private double price;
    private double saleRate;
    private double opening;
    private double openingPrice;
    private String meterDate;

    private Set<Transaction> transactionList = new HashSet<Transaction>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id", nullable = false)
    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "quantity")
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "sale_rate")
    public double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }

    @Column(name = "opening")
    public double getOpening() {
        return opening;
    }

    public void setOpening(double opening) {
        this.opening = opening;
    }

    @Column(name = "opening_price")
    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    @Column(name = "meter_date")
    public String getMeterDate() {
        return meterDate;
    }

    public void setMeterDate(String meterDate) {
        this.meterDate = meterDate;
    }

    @OneToMany(targetEntity = Transaction.class, mappedBy = "product", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(Set<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

}
