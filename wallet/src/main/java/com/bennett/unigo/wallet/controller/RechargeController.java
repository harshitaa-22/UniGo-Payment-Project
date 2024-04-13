package com.bennett.unigo.wallet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bennett.unigo.wallet.entity.Recharge;
import com.bennett.unigo.wallet.service.RechargeService;

import java.util.List;

@RestController
@RequestMapping("/api/recharges")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @GetMapping
    public List<Recharge> getAllRecharges() {
        return rechargeService.getAllRecharges();
    }

    @PostMapping
    public Recharge createRecharge(@RequestBody Recharge recharge) {
        return rechargeService.createRecharge(recharge);
    }

}
