package dev.hexa.accountservice.application.port.secondary;

import dev.hexa.accountservice.domain.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountPersistencePort {
    Optional<BankAccount> findBankAccountById(String accountId);
    List<BankAccount> findAllBankAccount();
}
