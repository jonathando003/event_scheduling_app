package com.springboot.backend.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.backend.entities.Account;

import com.springboot.backend.requests.AccountRequest;
import com.springboot.backend.resourceAssembler.ResourceAssembler;
import com.springboot.backend.resources.AccountResource;
import com.springboot.backend.services.AccountService;


@RestController
@RequestMapping(value = "/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add-account")
    public AccountResource addAccount(@RequestBody AccountRequest request) {
        Account account = this.accountService.createAccount(request);
        return ResourceAssembler.toResource(account, AccountResource.class);
    }

    @GetMapping("/lookUpAccount")
    public AccountResource accountLookUp(@RequestParam(value = "email", required = false) String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email missing.");
        } else {
            Account account = this.accountService.getAccountByEmail(email);
            return ResourceAssembler.toResource(account, AccountResource.class);
        }
    }
}