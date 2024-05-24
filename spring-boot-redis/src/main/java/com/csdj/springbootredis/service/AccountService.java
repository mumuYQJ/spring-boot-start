package com.csdj.springbootredis.service;

import com.csdj.springbootredis.pojo.Account;

import java.util.List;

public interface AccountService {

    Account select(Account account);

    List<Account> accounts();
}
