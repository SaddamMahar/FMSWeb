package com.wiztech.dao;

import com.wiztech.model.Product;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface ProductDao {
    List<Product> findAllProducts();
    Product findByProductID (long id);
    Product save (Product product);
    Product update (Product product);
    boolean deleteAll ();
    boolean delete (Product product);
}
