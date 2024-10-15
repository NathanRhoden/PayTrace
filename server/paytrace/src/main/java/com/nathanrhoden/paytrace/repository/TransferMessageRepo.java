package com.nathanrhoden.paytrace.repository;

import com.nathanrhoden.paytrace.entity.TransferMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferMessageRepo extends JpaRepository<TransferMessage , Long> {

    TransferMessage findByUniqueTransactionRef(String transferRef);
}
