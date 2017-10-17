package com.wiztech.controller;

import com.wiztech.service.AccountService;
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
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getAllAccounts(){
        ModelAndView model = new ModelAndView("account");
        model.addObject("accountList", accountService.getAllAccounts());
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddAccunt(){
        ModelAndView model = new ModelAndView("addAccount");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addAccount(HttpServletRequest request){
        ModelAndView model = new ModelAndView("account");
        accountService.save(request);
        model.addObject("accountList", accountService.getAllAccounts());
        return model;
    }

    @RequestMapping(value = "/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView getAccount(@PathVariable("id")String id){
        ModelAndView model = new ModelAndView("addAccount");
        model.addObject("account", accountService.getAccountByID(id));
        return model;
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateAccount(HttpServletRequest request){
        ModelAndView model = new ModelAndView("account");
        accountService.update(request);
        model.addObject("accountList", accountService.getAllAccounts());
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAccount(@PathVariable("id")String id){
        ModelAndView model = new ModelAndView("account");
        model.addObject("accountDeleted", accountService.deleteAccountByID(id));
        model.addObject("accountList", accountService.getAllAccounts());
        return model;
    }
}
