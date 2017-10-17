package com.wiztech.dao;

import com.wiztech.model.City;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface CityDao {
    List<City> findAllCities();
    City findByCityID (long id);
    City save (City city);
    City update (City city);
    boolean deleteAll ();
    boolean delete (City city);
}
