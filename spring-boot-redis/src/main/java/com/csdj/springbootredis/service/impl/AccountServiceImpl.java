package com.csdj.springbootredis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csdj.springbootredis.mapper.AccountMapper;
import com.csdj.springbootredis.pojo.Account;
import com.csdj.springbootredis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Account select(Account account) {
        Account ac = null;
        Object object = redisTemplate.opsForValue().get(account.getName());
        if (object == null) {
            QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
            accountQueryWrapper.eq("name", account.getName()).eq("money", account.getMoney());
            ac = accountMapper.selectOne(accountQueryWrapper);
            redisTemplate.opsForValue().set(account.getName(), account);
        } else {
            ac = (Account) object;
        }

        return ac;
    }

    @Override
    public List<Account> accounts() {
        List<Account> accounts = null;
        List<Object> accounts1 = redisTemplate.opsForList().range("accounts", 0, -1);
        if (accounts1.size() == 0) {
            accounts = accountMapper.selectList(null);
            redisTemplate.opsForList().leftPush("accounts",accounts);
        } else {
            accounts = (List<Account>) accounts1.get(0);
        }
        return accounts;
    }
}
