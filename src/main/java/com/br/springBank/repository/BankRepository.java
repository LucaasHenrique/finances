package com.br.springBank.repository;

import com.br.springBank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BankRepository extends JpaRepository<BankAccount, UUID> {
}
