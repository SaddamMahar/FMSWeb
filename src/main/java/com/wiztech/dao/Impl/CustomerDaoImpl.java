package com.wiztech.dao.Impl;

import com.wiztech.dao.CustomerDao;
import com.wiztech.model.Customer;
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
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers;
        customers = sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
        return customers;
    }

    @Override
    public Customer findByCustomerID(long id) {
        List<Customer> customers;
        customers = sessionFactory.getCurrentSession()
                .createQuery("from Customer where customersID=?")
                .setParameter(0, id)
                .list();
        
        return customers.get(0);
    }

    @Override
    public Customer save(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
        return customer;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Customer customer) {
        try {
            sessionFactory.getCurrentSession().delete(customer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
