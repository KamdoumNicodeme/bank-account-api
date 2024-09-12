package dev.hexa.accountservice.infrastructure.adapters.secondary.repository;

import dev.hexa.accountservice.infrastructure.adapters.secondary.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity,String> {
}
