package com.wiztech.dao.Impl;

import com.wiztech.dao.CityDao;
import com.wiztech.model.City;
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
@Repository("cityDao")
public class CityDaoImpl implements CityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> findAllCities() {
        List<City> cities;
        cities = sessionFactory.getCurrentSession().createCriteria(City.class).list();
        return cities;
    }

    @Override
    public City findByCityID(long id) {
        List<City> cities;
        cities = sessionFactory.getCurrentSession()
                .createQuery("from City where cityID=?")
                .setParameter(0, id)
                .list();
        
        return cities.get(0);
    }

    @Override
    public City save(City city) {
        sessionFactory.getCurrentSession().save(city);
        return city;
    }

    @Override
    public City update(City city) {
        sessionFactory.getCurrentSession().update(city);
        return city;
    }

    @Override
    public boolean deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(City city) {
        try {
            sessionFactory.getCurrentSession().delete(city);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
