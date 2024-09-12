package dev.hexa.accountservice.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType accountType;
    private Customer customer;
    private Long customerId;

}
