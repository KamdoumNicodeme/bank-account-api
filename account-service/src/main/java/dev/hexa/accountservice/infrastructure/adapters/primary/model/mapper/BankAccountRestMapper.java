package dev.hexa.accountservice.infrastructure.adapters.primary.model.mapper;

import dev.hexa.accountservice.domain.BankAccount;
import dev.hexa.accountservice.infrastructure.adapters.primary.model.response.BankAccountResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountRestMapper {
    BankAccountResponse toBankAccountResponse(BankAccount account);
    List<BankAccountResponse> toBankAccountResponseList(List<BankAccount> bankAccounts);
}
