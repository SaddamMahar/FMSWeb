package com.wiztech.dao.Impl;

import com.wiztech.dao.ProductDao;
import com.wiztech.model.Product;
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
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAllProducts() {
        List<Product> products;

        products = sessionFactory.getCurrentSession().createCriteria(Product.class).list();

        return products;
    }

    @Override
    public Product findByProductID(long id) {
        List<Product> products;
        products = sessionFactory.getCurrentSession()
                .createQuery("from Product where productID=?")
                .setParameter(0, id)
                .list();
        
        return products.get(0);
    }

    @Override
    public Product save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Override
    public boolean delete(Product product) {
        try {
            sessionFactory.getCurrentSession().delete(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product update(Product product) {
        sessionFactory.getCurrentSession().update(product);
        return product;
    }
    
}
