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
@Table(name="vendors")
public class Vendor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long vendorsID;
    private String name;
    private double openingBalance;
    private double currentBalance;
    private String address;
    private String zipCode;
    private String telephone;
    private String contactEmail;
    private String contactPhone;

    private City city;
    private Province province;

    private Set<Payable> payableList = new HashSet<Payable>(0);
    private Set<Transaction> transactionList = new HashSet<Transaction>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendors_id", nullable = false)
    public long getVendorsID() {
        return vendorsID;
    }

    public void setVendorsID(long vendorsID) {
        this.vendorsID = vendorsID;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "contact_email")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Column(name = "contact_phone")
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @OneToMany(targetEntity = Payable.class, mappedBy = "vendor", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Payable> getPayableList() {
        return payableList;
    }

    public void setPayableList(Set<Payable> payableList) {
        this.payableList = payableList;
    }

    @OneToMany(targetEntity = Transaction.class, mappedBy = "vendor", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(Set<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false,referencedColumnName = "cityID")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", nullable = false,referencedColumnName = "provinceID")
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

}
