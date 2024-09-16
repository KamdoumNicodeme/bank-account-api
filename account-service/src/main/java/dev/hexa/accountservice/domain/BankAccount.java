package dev.hexa.accountservice.domain;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType accountType;
    private Customer customer;
    private Long customerId;

}
