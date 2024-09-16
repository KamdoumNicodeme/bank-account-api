package dev.hexa.accountservice.infrastructure.adapters.secondary.entity;

import dev.hexa.accountservice.infrastructure.adapters.secondary.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "bank_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankAccountEntity {
    @Id
    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
