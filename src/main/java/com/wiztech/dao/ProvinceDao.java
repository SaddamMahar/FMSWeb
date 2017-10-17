package com.wiztech.dao;

import com.wiztech.model.Payable;
import com.wiztech.model.Province;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface ProvinceDao {
    List<Province> findAllProvinces();
    Province findByProvinceID (long id);
    Province save (Province province);
    Province update (Province province);
    boolean deleteAll ();
    boolean delete (Province province);
}
