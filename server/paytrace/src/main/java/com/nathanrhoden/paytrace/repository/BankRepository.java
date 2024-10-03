package com.nathanrhoden.paytrace.repository;

import com.nathanrhoden.paytrace.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank , Long> {

}
