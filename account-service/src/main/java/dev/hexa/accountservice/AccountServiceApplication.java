package dev.hexa.accountservice;

import dev.hexa.accountservice.domain.AccountType;
import dev.hexa.accountservice.domain.BankAccount;
import dev.hexa.accountservice.infrastructure.adapters.secondary.mapper.BankAccountPersistenceMapper;
import dev.hexa.accountservice.infrastructure.adapters.secondary.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, BankAccountPersistenceMapper bankAccountPersistenceMapper){
		return args -> {

			BankAccount account = BankAccount.builder()
					.accountId(String.valueOf(UUID.randomUUID()))
					.balance(1000.0)
					.accountType(AccountType.CURRENT_ACCOUNT)
					.createdAt(LocalDate.now())
					.currency("XAF")
					.customerId(1L)
					.build();
			BankAccount account2 = BankAccount.builder()
					.accountId(String.valueOf(UUID.randomUUID()))
					.balance(1000.0)
					.accountType(AccountType.CURRENT_ACCOUNT)
					.createdAt(LocalDate.now())
					.currency("XAF")
					.customerId(2L)
					.build();

			accountRepository.save(bankAccountPersistenceMapper.toBankAccount(account));
			accountRepository.save(bankAccountPersistenceMapper.toBankAccount(account2));

        };
	}

}
