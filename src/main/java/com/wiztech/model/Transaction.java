package com.wiztech.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Saddam
 */
@Entity
@Table(name="transaction")
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long transactionID;
    private long debitAccountID;
    private long creditAccountID;
    private String date;
    private double quantity;
    private double amount;

    private Set<Payable> payableList = new HashSet<Payable>(0);
    private Product product;
    private TransactionType transactionType;
    private Vendor vendor;
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    @Column(name = "debit_account_id")
    public long getDebitAccountID() {
        return debitAccountID;
    }

    public void setDebitAccountID(long debitAccountID) {
        this.debitAccountID = debitAccountID;
    }

    @Column(name = "credit_account_id")
    public long getCreditAccountID() {
        return creditAccountID;
    }

    public void setCreditAccountID(long creditAccountID) {
        this.creditAccountID = creditAccountID;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "quantity")
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @OneToMany(targetEntity = Payable.class, mappedBy = "transaction", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Payable> getPayableList() {
        return payableList;
    }

    public void setPayableList(Set<Payable> payableList) {
        this.payableList = payableList;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false,referencedColumnName = "productID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tran_type_id", nullable = false,referencedColumnName = "id")
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false,referencedColumnName = "vendorsID")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false,referencedColumnName = "customersID")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    

}
