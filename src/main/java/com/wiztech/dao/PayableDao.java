package com.wiztech.dao;

import com.wiztech.model.Payable;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface PayableDao {
    List<Payable> findAllPayables();
    Payable findByPayableID (long id);
    Payable save (Payable payable);
    Payable update (Payable payable);
    boolean deleteAll ();
    boolean delete (Payable payable);
}
