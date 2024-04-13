package com.bennett.unigo.wallet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bennett.unigo.wallet.entity.Wallet;
import com.bennett.unigo.wallet.repository.WalletRepository;

import java.util.List;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet getWalletById(Long id) {
        return walletRepository.findById(id).orElse(null);
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(Long id, Wallet updatedWallet) {
        Wallet existingWallet = walletRepository.findById(id).orElse(null);
        if (existingWallet != null) {
        	if (updatedWallet.getStudentId()!= null)
        		existingWallet.setStudentId(updatedWallet.getStudentId());
        	if (updatedWallet.getBalance()!= null)
        		existingWallet.setBalance(updatedWallet.getBalance());
        	if (updatedWallet.getActive()!= null)
        		existingWallet.setActive(updatedWallet.getActive());
            return walletRepository.save(existingWallet);
        }
        return null;
    }

    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }
}
