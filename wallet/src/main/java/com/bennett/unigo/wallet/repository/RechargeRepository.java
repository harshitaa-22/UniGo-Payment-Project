package com.bennett.unigo.wallet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bennett.unigo.wallet.entity.Recharge;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    // You can add custom query methods if needed
}
