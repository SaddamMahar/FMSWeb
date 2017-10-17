package com.wiztech.dao.Impl;

import com.wiztech.dao.VendorDao;
import com.wiztech.model.Vendor;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saddam
 */
@Transactional
@Repository("vendorDao")
public class VendorDaoImpl implements VendorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Vendor> findAllVendors() {
        List<Vendor> vendors;
        vendors = sessionFactory.getCurrentSession().createCriteria(Vendor.class).list();
        return vendors;
    }

    @Override
    public Vendor findByVendorID(long id) {
        List<Vendor> vendors;
        vendors = sessionFactory.getCurrentSession()
                .createQuery("from Vendor where vendorsID=?")
                .setParameter(0, id)
                .list();
        
        return vendors.get(0);
    }

    @Override
    public Vendor save(Vendor vendor) {
        sessionFactory.getCurrentSession().save(vendor);
        return vendor;
    }

    @Override
    public Vendor update(Vendor vendor) {
        sessionFactory.getCurrentSession().update(vendor);
        return vendor;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Vendor vendor) {
        try {
            sessionFactory.getCurrentSession().delete(vendor);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
