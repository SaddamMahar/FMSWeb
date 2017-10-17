package com.wiztech.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
@Table(name="province_id")
public class Province implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long provinceID;
    private String name;

    Set<City> cityList = new HashSet<City>(0);
    Set<Customer> customerList = new HashSet<Customer>(0);
    Set<Vendor> vendorList = new HashSet<Vendor>(0);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id", nullable = false)
    public long getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(long provinceID) {
        this.provinceID = provinceID;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = City.class, mappedBy = "province", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<City> getCityList() {
        return cityList;
    }

    public void setCityList(Set<City> cityList) {
        this.cityList = cityList;
    }

    @OneToMany(targetEntity = Customer.class , mappedBy = "province" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Set<Customer> customerList) {
        this.customerList = customerList;
    }

    @OneToMany(targetEntity = Vendor.class , mappedBy = "prvince" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(Set<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    
}
