package com.bennett.unigo.wallet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bennett.unigo.wallet.entity.Recharge;
import com.bennett.unigo.wallet.entity.Wallet;
import com.bennett.unigo.wallet.repository.RechargeRepository;
import com.bennett.unigo.wallet.repository.WalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RechargeService {
    @Autowired
    private RechargeRepository rechargeRepository;
    
    @Autowired
    private WalletRepository walletRepository;

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }


    public Recharge createRecharge(Recharge recharge) {
        Recharge recharge2 = rechargeRepository.save(recharge);
        Optional<Wallet> optional = walletRepository.findById((long)recharge.getWalletId());
        if(optional.isPresent()) {
        	Wallet wallet = optional.get();
        	wallet.setBalance(wallet.getBalance()+recharge.getAmount());
        	walletRepository.save(wallet);
        }
        return recharge2;
    }
}
