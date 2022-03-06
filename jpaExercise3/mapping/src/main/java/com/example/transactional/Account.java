package com.example.transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    int id;

    String accountHolder;
    double deposits;

    public Account(int id,String accountHolder, double deposits) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.deposits = deposits;
    }
    Account()
    {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public double getDeposits() {
        return deposits;
    }
    public void setDeposits(double deposits) {
        this.deposits = deposits;
    }

}
