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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Saddam
 */
@Entity
@Table(name="account")
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long accountID;
    private String name;
    private String branchCode;
    private String accountNo;
    private double openingBalance;
    private double currentBalance;

    private Set<Payable> payableList = new HashSet<Payable>(0);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "branch_code")
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Column(name = "account_no")
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Column(name = "opening_balance")
    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    @Column(name = "current_balance")
    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @OneToMany(targetEntity = Payable.class, mappedBy = "account", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Payable> getPayableList() {
        return payableList;
    }

    public void setPayableList(Set<Payable> payableList) {
        this.payableList = payableList;
    }
}
