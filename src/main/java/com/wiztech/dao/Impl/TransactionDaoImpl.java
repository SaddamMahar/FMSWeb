package com.wiztech.dao.Impl;

import com.wiztech.dao.TransactionDao;
import com.wiztech.model.Transaction;
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
@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Transaction> findAllTransactions() {
        List<Transaction> transactions;
        transactions = sessionFactory.getCurrentSession().createCriteria(Transaction.class).list();
        return transactions;
    }

    @Override
    public Transaction findByTransactionID(long id) {
        List<Transaction> tansactions;
        tansactions = sessionFactory.getCurrentSession()
                .createQuery("from Transaction where transactionID=?")
                .setParameter(0, id)
                .list();
        
        return tansactions.get(0);
    }

    @Override
    public Transaction save(Transaction transaction) {
        sessionFactory.getCurrentSession().save(transaction);
        return transaction;
    }

    @Override
    public Transaction update(Transaction transaction) {
        sessionFactory.getCurrentSession().update(transaction);
        return transaction;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Transaction transaction) {
        try {
            sessionFactory.getCurrentSession().delete(transaction);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
