package com.wiztech.controller;

import com.wiztech.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Saddam
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getAllProducts(){
        ModelAndView model = new ModelAndView("product");
        model.addObject("productList", productService.getAllProducts());
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getsubp(){
        ModelAndView model = new ModelAndView("addProduct");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addProduct(HttpServletRequest request){
        ModelAndView model = new ModelAndView("product");
        productService.save(request);
        model.addObject("productList", productService.getAllProducts());
        return model;
    }

    @RequestMapping(value = "/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView getProduct(@PathVariable("id")String id){
        ModelAndView model = new ModelAndView("addProduct");
        model.addObject("product", productService.getProductByID(id));
        return model;
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateProduct(HttpServletRequest request){
        ModelAndView model = new ModelAndView("product");
        productService.update(request);
        model.addObject("productList", productService.getAllProducts());
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("id")String id){
        ModelAndView model = new ModelAndView("product");
        model.addObject("productDeleted", productService.deleteProductByID(id));
        model.addObject("productList", productService.getAllProducts());
        return model;
    }
}
