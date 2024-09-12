package dev.hexa.accountservice.application.port.primary;

import dev.hexa.accountservice.domain.BankAccount;

import java.util.List;

public interface BankAccountServicePort {
    BankAccount getBankAccount(String accountId);
    List<BankAccount> getAllBankAccount();
}
