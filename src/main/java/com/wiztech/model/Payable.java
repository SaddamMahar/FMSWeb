package com.wiztech.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Saddam
 */
@Entity
@Table(name="payable")
public class Payable implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long payableID;
    private String date;
    private long chequeNO;
    private double amount;
    private String remarks;
    
    private Account account;
    private Vendor vendor;
    private Transaction transaction;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payable_id", nullable = false)
    public long getPayableID() {
        return payableID;
    }

    public void setPayableID(long payableID) {
        this.payableID = payableID;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "cheque_no")
    public long getChequeNO() {
        return chequeNO;
    }

    public void setChequeNO(long chequeNO) {
        this.chequeNO = chequeNO;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false,referencedColumnName = "accountID")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false,referencedColumnName = "vendorID")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false,referencedColumnName = "transactionID")
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
