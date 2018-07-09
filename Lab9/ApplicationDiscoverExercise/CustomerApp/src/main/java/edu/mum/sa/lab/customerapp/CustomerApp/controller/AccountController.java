package edu.mum.sa.lab.customerapp.CustomerApp.controller;

import edu.mum.sa.lab.customerapp.CustomerApp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountFeignClient feignClient;

    @RequestMapping("/customer/{customerId}")
    public Account getName(@PathVariable("customerId") String customerId) {
        Account account = feignClient.getName(customerId);
        return account;
    }


    @FeignClient("AccountService")
    interface AccountFeignClient {
        @RequestMapping("/account/{customerId}")
        Account getName(@PathVariable("customerId") String customerId);
    }
}
