package main.java.com.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.entities.Account;

import main.java.com.requests.AccountRequest;
import main.java.com.resourceAssembler.ResourceAssembler;
import main.java.com.resources.AccountResource;
import main.java.com.services.AccountService;


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
    
}
