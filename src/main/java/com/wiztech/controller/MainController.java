package com.wiztech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Saddam
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String getHello(ModelMap mm){
        return "index";
    }
    
    @RequestMapping("/index")
    public String getHome(ModelMap mm){
        return "index";
    }
}
