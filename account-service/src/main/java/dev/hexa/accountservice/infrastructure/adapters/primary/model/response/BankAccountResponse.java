package dev.hexa.accountservice.infrastructure.adapters.primary.model.response;

import dev.hexa.accountservice.domain.AccountType;
import dev.hexa.accountservice.infrastructure.adapters.secondary.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountResponse {

    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType accountType;
    private Customer customer;
    private Long customerId;
}
