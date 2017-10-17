package com.wiztech.dao.Impl;

import com.wiztech.dao.PayableDao;
import com.wiztech.model.Payable;
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
@Repository("payableDao")
public class PayableDaoImpl implements PayableDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Payable> findAllPayables() {
        List<Payable> payables;
        payables = sessionFactory.getCurrentSession().createCriteria(Payable.class).list();
        return payables;
    }

    @Override
    public Payable findByPayableID(long id) {
        List<Payable> payables;
        payables = sessionFactory.getCurrentSession()
                .createQuery("from Payable where payableID=?")
                .setParameter(0, id)
                .list();
        
        return payables.get(0);
    }

    @Override
    public Payable save(Payable payable) {
        sessionFactory.getCurrentSession().save(payable);
        return payable;
    }

    @Override
    public Payable update(Payable payable) {
        sessionFactory.getCurrentSession().update(payable);
        return payable;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Payable payable) {
        try {
            sessionFactory.getCurrentSession().delete(payable);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
