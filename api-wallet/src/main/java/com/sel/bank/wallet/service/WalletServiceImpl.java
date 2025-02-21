package com.sel.bank.wallet.service;

import com.sel.bank.wallet.dao.WalletDao;
import com.sel.bank.wallet.dao.WalletRepoRedis;
import com.sel.bank.wallet.model.Wallet;
import com.sel.bank.wallet.model.WalletRedis;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WalletServiceImpl implements IWalletService {

	@Autowired
	private WalletRepoRedis repoRedis;

	@Autowired
	private WalletDao walletDao;

	@Override
	public List<Wallet> findAll() {
		List<WalletRedis> redisList = repoRedis.findAll();
		log.info("read map from REDIS list size = "+ redisList.size());
		if(CollectionUtils.isNotEmpty(redisList)){
			List<Wallet>  wallets = new ArrayList();
			for (WalletRedis redis: redisList){
				Wallet wallet = new Wallet();
				wallet.setId(redis.getId());
				wallet.setAccount(redis.getAccount());
				wallet.setDescription(redis.getDescription());
				wallet.setMount(redis.getMount());
				wallets.add(wallet);
			}
			return wallets;
		}
		return walletDao.findAll();
	}

	@Override
	public Wallet save(Wallet wallet) {
		wallet = walletDao.save(wallet);
		log.info("Writing value to redis");
		WalletRedis redis = new WalletRedis();
		redis.setId(wallet.getId());
		redis.setAccount(wallet.getAccount());
		redis.setMount(wallet.getMount());
		redis.setDescription(wallet.getDescription());
		redis = repoRedis.save(redis);
		log.info("write to Redis :: "+redis.toString());
		return wallet;
	}

	@Override
	public void delete(Wallet wallet) {
		walletDao.delete(wallet);
	}

	@Override
	public Optional<Wallet> findById(String id) {
		Optional<WalletRedis> redisOptional = repoRedis.findById(id);
		if(redisOptional.isPresent()){
			WalletRedis redis = redisOptional.get();
			log.info("Get Values from Redis :: "+redis.toString());
			Wallet wallet = new Wallet();
			wallet.setId(redis.getId());
			wallet.setAccount(redis.getAccount());
			wallet.setDescription(redis.getDescription());
			wallet.setMount(redis.getMount());
			return Optional.of(wallet);
		}
		return walletDao.findById(id);
	}
}
