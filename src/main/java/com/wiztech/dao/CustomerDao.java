package com.wiztech.dao;

import com.wiztech.model.Customer;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface CustomerDao {
    List<Customer> findAllCustomers();
    Customer findByCustomerID (long id);
    Customer save (Customer customer);
    Customer update (Customer customer);
    boolean deleteAll ();
    boolean delete (Customer customer);
}
