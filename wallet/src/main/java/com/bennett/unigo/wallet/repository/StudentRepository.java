package com.bennett.unigo.wallet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bennett.unigo.wallet.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
