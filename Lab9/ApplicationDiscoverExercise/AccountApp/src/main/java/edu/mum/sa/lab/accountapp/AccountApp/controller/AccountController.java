package edu.mum.sa.lab.accountapp.AccountApp.controller;

import edu.mum.sa.lab.accountapp.AccountApp.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountservice")
public class AccountController {

    @GetMapping(path = "/{customerId}")
    public Account getName(@PathVariable("customerId") String customerId){
        Account account = new Account();
        account.setAccountNo("1234");
        account.setBalance("0.00");
        return account;
    }
}
