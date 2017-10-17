package com.wiztech.service;

import com.wiztech.dao.ProductDao;
import com.wiztech.model.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saddam
 */
@Service("productService")
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts(){
        return productDao.findAllProducts();
    }

    public Product save(HttpServletRequest request){
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setType(request.getParameter("type"));        
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setSaleRate(Double.parseDouble(request.getParameter("saleRate")));
        product.setOpening(Double.parseDouble(request.getParameter("opening")));
        product.setMeterDate(request.getParameter("meterDate"));
        product.setOpeningPrice(Double.parseDouble(request.getParameter("openingPrice")));
        return productDao.save(product);
    }

    public Product getProductByID(String id){
        long lId = Long.parseLong(id);        
        return productDao.findByProductID(lId);
    }

    public boolean deleteProductByID(String id){
        return productDao.delete(getProductByID(id));
    }

    public Product update(HttpServletRequest request){
        Product product = new Product();
        product.setProductID(Long.parseLong(request.getParameter("productID")));
        product.setName(request.getParameter("name"));
        product.setType(request.getParameter("type"));        
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setSaleRate(Double.parseDouble(request.getParameter("saleRate")));
        product.setOpening(Double.parseDouble(request.getParameter("opening")));
        product.setMeterDate(request.getParameter("meterDate"));
        product.setOpeningPrice(Double.parseDouble(request.getParameter("openingPrice")));
        return productDao.update(product);
    }
}
