package dev.hexa.accountservice.infrastructure.adapters.secondary;

import dev.hexa.accountservice.application.port.secondary.BankAccountPersistencePort;
import dev.hexa.accountservice.domain.BankAccount;
import dev.hexa.accountservice.infrastructure.adapters.secondary.mapper.BankAccountPersistenceMapper;
import dev.hexa.accountservice.infrastructure.adapters.secondary.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements BankAccountPersistencePort {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountPersistenceMapper mapper;
    @Override
    public Optional<BankAccount> findBankAccountById(String accountId) {
        return bankAccountRepository.findById(accountId).map(mapper::toBankAccountEntity);
    }

    @Override
    public List<BankAccount> findAllBankAccount() {
        return mapper.toBankAccountEntityList(bankAccountRepository.findAll());
    }
}
