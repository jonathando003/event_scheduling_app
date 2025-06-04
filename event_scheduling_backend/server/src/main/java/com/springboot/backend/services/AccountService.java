package com.springboot.backend.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.springboot.backend.entities.Account;

import com.springboot.backend.repositories.AccountRepository;
import com.springboot.backend.requests.AccountRequest;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }

    public Account createAccount(AccountRequest request) {
        Account account = new Account();
        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setUserName(request.getUserName());
        account.setPrivilege(request.getPrivilege());
        account.setPhoneNumber(request.getPhoneNumber());
        account = this.accountRepository.save(account);

        return account;
    }
    
}