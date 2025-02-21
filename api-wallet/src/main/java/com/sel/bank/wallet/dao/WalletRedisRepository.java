package com.sel.bank.wallet.dao;

import com.sel.bank.wallet.model.Wallet;
import com.sel.bank.wallet.model.WalletRedis;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WalletRedisRepository implements WalletRepoRedis{

    public static final String WALLET_KEY = "WALLET";

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public WalletRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    @Override
    public List<WalletRedis> findAll() {
        return hashOperations.values(WALLET_KEY);
    }

    public Optional<WalletRedis> findById(String id) {
        WalletRedis redis = (WalletRedis) hashOperations.get(WALLET_KEY, Integer.valueOf(id));
        return Optional.of(redis);
    }

    @Override
    public WalletRedis save(WalletRedis wallet) {
        hashOperations.put(WALLET_KEY, wallet.getId(), wallet);
        return wallet;
    }

    @Override
    public void delete(WalletRedis wallet) {
        hashOperations.delete(WALLET_KEY, wallet.getId());
    }
}
