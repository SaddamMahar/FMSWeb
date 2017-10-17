package com.wiztech.service;

import com.wiztech.dao.AccountDao;
import com.wiztech.model.Account;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saddam
 */
@Service("accountService")
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public List<Account> getAllAccounts(){
        return accountDao.findAllAccounts();
    }

    public Account save(HttpServletRequest request){
        Account account = new Account();
        account.setName(request.getParameter("name"));
        account.setAccountNo(request.getParameter("accountNo"));
        account.setBranchCode(request.getParameter("branchCode"));
        account.setCurrentBalance(Double.parseDouble(request.getParameter("currentBalance")));
        account.setOpeningBalance(Double.parseDouble(request.getParameter("openingBalance")));
        return accountDao.save(account);
    }

    public Account getAccountByID(String id){
        long lId = Long.parseLong(id);        
        return accountDao.findByAccountID(lId);
    }

    public boolean deleteAccountByID(String id){
        return accountDao.delete(getAccountByID(id));
    }

    public Account update(HttpServletRequest request){
        Account account = new Account();
        account.setAccountID(Long.parseLong(request.getParameter("accountID")));
        account.setName(request.getParameter("name"));
        account.setAccountNo(request.getParameter("accountNo"));
        account.setBranchCode(request.getParameter("branchCode"));
        account.setCurrentBalance(Double.parseDouble(request.getParameter("currentBalance")));
        account.setOpeningBalance(Double.parseDouble(request.getParameter("openingBalance")));
        return accountDao.update(account);
    }
}
