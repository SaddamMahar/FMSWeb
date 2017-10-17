package com.wiztech.dao.Impl;

import com.wiztech.dao.AccountDao;
import com.wiztech.model.Account;
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
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Account> findAllAccounts() {
        List<Account> accounts;
        accounts = sessionFactory.getCurrentSession().createCriteria(Account.class).list();
        return accounts;
    }

    @Override
    public Account findByAccountID(long id) {
        List<Account> accounts;
        accounts = sessionFactory.getCurrentSession()
                .createQuery("from Account where accountID=?")
                .setParameter(0, id)
                .list();
        
        return accounts.get(0);
    }

    @Override
    public Account save(Account account) {
        sessionFactory.getCurrentSession().save(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        sessionFactory.getCurrentSession().update(account);
        return account;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Account account) {
        try {
            sessionFactory.getCurrentSession().delete(account);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
