package com.wiztech.dao;

import com.wiztech.model.Transaction;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface TransactionDao {
    List<Transaction> findAllTransactions();
    Transaction findByTransactionID (long id);
    Transaction save (Transaction transaction);
    Transaction update (Transaction transaction);
    boolean deleteAll ();
    boolean delete (Transaction transaction);
}
