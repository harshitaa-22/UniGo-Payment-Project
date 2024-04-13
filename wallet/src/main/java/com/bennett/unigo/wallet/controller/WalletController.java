package com.bennett.unigo.wallet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bennett.unigo.wallet.entity.Wallet;
import com.bennett.unigo.wallet.model.NewWalletRequest;
import com.bennett.unigo.wallet.service.WalletService;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Long id) {
        return walletService.getWalletById(id);
    }

    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }
    
    @PostMapping("/newWallet")
    public Wallet newWallet(@RequestBody NewWalletRequest request) {
    	Wallet w = new Wallet(null, request.getStudentId(), 0.0, request.getActive());
        return walletService.createWallet(w);
    }

    @PutMapping("/{id}")
    public Wallet updateWallet(@PathVariable Long id, @RequestBody Wallet wallet) {
        return walletService.updateWallet(id, wallet);
    }

    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
    }
}
