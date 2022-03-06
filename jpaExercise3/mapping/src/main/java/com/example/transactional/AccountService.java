package com.example.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;
    void createRecord(List<Account> accounts) {repository.saveAll(accounts);
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(double money)
    {
        int exception_raiser;
        Account account = repository.findById(1).get();
        account.setDeposits(account.getDeposits()-money);
        repository.save(account);
        exception_raiser=5/0;
        Account account2 = repository.findById(2).get();
        account2.setDeposits(account2.getDeposits()-money);
        repository.save(account2);
    }
}
