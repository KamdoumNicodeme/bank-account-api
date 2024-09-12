package dev.hexa.accountservice.infrastructure.adapters.secondary.mapper;

import dev.hexa.accountservice.domain.BankAccount;
import dev.hexa.accountservice.infrastructure.adapters.secondary.entity.BankAccountEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountPersistenceMapper {
    BankAccount toBankAccountEntity(BankAccountEntity bankAccount);
    BankAccountEntity toBankAccount(BankAccount bankAccount);
    List<BankAccount> toBankAccountEntityList(List<BankAccountEntity> bankAccount);
}
