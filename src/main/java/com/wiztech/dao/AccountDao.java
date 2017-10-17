package com.wiztech.dao;

import com.wiztech.model.Account;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface AccountDao {
    List<Account> findAllAccounts();
    Account findByAccountID (long id);
    Account save (Account account);
    Account update (Account account);
    boolean deleteAll ();
    boolean delete (Account account);
}
