package com.bennett.unigo.wallet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bennett.unigo.wallet.entity.Student;
import com.bennett.unigo.wallet.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
	Wallet findByStudentId(Integer studentId);
}
