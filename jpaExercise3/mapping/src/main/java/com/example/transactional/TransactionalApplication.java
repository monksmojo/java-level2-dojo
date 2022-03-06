package com.example.transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TransactionalApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TransactionalApplication.class, args);
        AccountService accountService= context.getBean(AccountService.class);

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1,"robin",2000));
        accountList.add(new Account(2,"batman",6000));
        accountService.createRecord(accountList);
        accountService.transferMoney(1000);
    }
}
