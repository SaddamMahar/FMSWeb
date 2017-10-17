package com.wiztech.dao.Impl;

import com.wiztech.dao.ProvinceDao;
import com.wiztech.model.Province;
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
@Repository("provinceDao")
public class ProvinceDaoImpl implements ProvinceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Province> findAllProvinces() {
        List<Province> provinces;

        provinces = sessionFactory.getCurrentSession().createCriteria(Province.class).list();

        return provinces;
    }

    @Override
    public Province findByProvinceID(long id) {
        List<Province> provinces;
        provinces = sessionFactory.getCurrentSession()
                .createQuery("from Province where provinceID=?")
                .setParameter(0, id)
                .list();
        
        return provinces.get(0);
    }

    @Override
    public Province save(Province province) {
        sessionFactory.getCurrentSession().save(province);
        return province;
    }

    @Override
    public Province update(Province province) {
        sessionFactory.getCurrentSession().update(province);
        return province;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Province province) {
        try {
            sessionFactory.getCurrentSession().delete(province);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
