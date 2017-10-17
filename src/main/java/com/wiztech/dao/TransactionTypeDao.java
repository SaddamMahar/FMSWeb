package com.wiztech.dao;

import com.wiztech.model.TransactionType;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface TransactionTypeDao {
    List<TransactionType> findAllTransactionTypes();
    TransactionType findByTransactionTypeID (long id);
    TransactionType save (TransactionType transactionType);
    TransactionType update (TransactionType transactionType);
    boolean deleteAll ();
    boolean delete (TransactionType transactionType);
}
