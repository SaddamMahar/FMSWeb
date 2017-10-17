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
@Table(name="city")
public class City implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int cityID;
    private String name;

    private Province province;
    
    Set<Customer> customerList = new HashSet<Customer>(0);
    Set<Vendor> vendorList = new HashSet<Vendor>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", nullable = false,referencedColumnName = "provinceID")
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @OneToMany(targetEntity = Customer.class, mappedBy = "city", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Set<Customer> customerList) {
        this.customerList = customerList;
    }

    @OneToMany(targetEntity = Vendor.class, mappedBy = "city", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(Set<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    
}
