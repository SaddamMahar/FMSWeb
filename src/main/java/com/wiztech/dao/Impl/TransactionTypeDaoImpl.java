package com.wiztech.dao.Impl;

import com.wiztech.dao.TransactionTypeDao;
import com.wiztech.model.TransactionType;
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
@Repository("transactionTypeDao")
public class TransactionTypeDaoImpl implements TransactionTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TransactionType> findAllTransactionTypes() {
        List<TransactionType> transactionTypes;
        transactionTypes = sessionFactory.getCurrentSession().createCriteria(TransactionType.class).list();
        return transactionTypes;
    }

    @Override
    public TransactionType findByTransactionTypeID(long id) {
        List<TransactionType> transactionTypes;
        transactionTypes = sessionFactory.getCurrentSession()
                .createQuery("from TransactionType where id=?")
                .setParameter(0, id)
                .list();
        
        return transactionTypes.get(0);
    }

    @Override
    public TransactionType save(TransactionType transactionType) {
        sessionFactory.getCurrentSession().save(transactionType);
        return transactionType;
    }

    @Override
    public TransactionType update(TransactionType transactionType) {
        sessionFactory.getCurrentSession().update(transactionType);
        return transactionType;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(TransactionType transactionType) {
        try {
            sessionFactory.getCurrentSession().delete(transactionType);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
