package com.wiztech.dao;

import com.wiztech.model.Vendor;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface VendorDao {
    List<Vendor> findAllVendors();
    Vendor findByVendorID (long id);
    Vendor save (Vendor vendor);
    Vendor update (Vendor vendor);
    boolean deleteAll ();
    boolean delete (Vendor vendor);
}
