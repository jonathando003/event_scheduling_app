package com.springboot.backend.resources;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import com.springboot.backend.entities.Account;


import lombok.*;

@Data
@Component
@Scope(value="prototype")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountResource extends MainResource<Account> {
    
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Integer privilege;
    private String phoneNumber;

    public AccountResource(Account account) { super(account); }

    @Override
    public void initAttributes() {
        Account account = getEntity();
        setEntityId(account.getId().toString());
        setFirstName(account.getFirstName());
        setLastName(account.getLastName());
        setEmail(account.getEmail());
        setUserName(account.getUserName());
        setPrivilege(account.getPrivilege());
        setPhoneNumber(account.getPhoneNumber());
    }
}
