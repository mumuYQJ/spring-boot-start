package com.csdj.springbootredis.controller;

import com.csdj.springbootredis.pojo.Account;
import com.csdj.springbootredis.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "存款",description = "操作存款")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "查询个人存款",description = "无需参数")
    @GetMapping("/{name}")
    public Object getAccount(@Parameter(description = "姓名")
                             @PathVariable("name") String name) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(7500D);
        return accountService.select(account);
    }

    @Operation(summary = "查询所有存款",description = "无需参数")
    @GetMapping
    public Object accounts() {
        return accountService.accounts();
    }
}
