package com.wiztech.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saddam
 */
@Entity
@Table(name="transactiontypes")
public class TransactionType implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String tranTitle;

    private Set<Transaction> transactionList = new HashSet<Transaction>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "tran_title")
    public String getTranTitle() {
        return tranTitle;
    }

    public void setTranTitle(String tranTitle) {
        this.tranTitle = tranTitle;
    }

    @OneToMany(targetEntity = Transaction.class, mappedBy = "transactionType", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    public Set<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(Set<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

}
