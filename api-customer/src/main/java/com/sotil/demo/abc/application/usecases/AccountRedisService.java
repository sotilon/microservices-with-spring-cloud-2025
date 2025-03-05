package com.sotil.demo.abc.application.usecases;

import com.sotil.demo.abc.domain.model.Account;
import com.sotil.demo.abc.infrastructure.port.outport.IAccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
public class AccountRedisService implements IAccountService {

    @Autowired
    private RedisTemplate<String, Account> redisTemplate;
    private static final String ACCOUNT_KEY_PREFIX = "account:";


    // Save an account to Redis
    public void saveAccount(Account account) {
        ValueOperations<String, Account> ops = redisTemplate.opsForValue();
        ops.set(ACCOUNT_KEY_PREFIX + account.getId(), account);
    }

    // Get an account by ID
    public Account getAccountById(Long id) {
        return redisTemplate.opsForValue().get(ACCOUNT_KEY_PREFIX + id);
    }

    // Get all accounts from Redis
    public List<Account> getAllAccounts() {
        Set<String> keys = redisTemplate.keys(ACCOUNT_KEY_PREFIX + "*");
        List<Account> accounts = new ArrayList<>();
        if (keys != null) {
            for (String key : keys) {
                Account account = redisTemplate.opsForValue().get(key);
                if (account != null) {
                    accounts.add(account);
                }
            }
        }
        return accounts;
    }

    // Delete an account by ID
    public void deleteAccount(Long id) {
        redisTemplate.delete(ACCOUNT_KEY_PREFIX + id);
    }

}
