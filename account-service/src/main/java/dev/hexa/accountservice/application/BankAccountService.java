package dev.hexa.accountservice.application;

import dev.hexa.accountservice.application.annotation.DomainService;
import dev.hexa.accountservice.application.port.primary.BankAccountServicePort;
import dev.hexa.accountservice.application.port.secondary.BankAccountPersistencePort;
import dev.hexa.accountservice.domain.BankAccount;
import dev.hexa.accountservice.domain.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@DomainService
public class BankAccountService implements BankAccountServicePort {
    private BankAccountPersistencePort bankAccountPersistencePort;
    @Override
    public BankAccount getBankAccount(String accountId) {
        return bankAccountPersistencePort.findBankAccountById(accountId).orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<BankAccount> getAllBankAccount() {
        List<BankAccount> bankAccounts = bankAccountPersistencePort.findAllBankAccount();
        if (bankAccounts == null || bankAccounts.isEmpty()) {
            throw new AccountNotFoundException();
        }
        return bankAccounts;
    }
}
