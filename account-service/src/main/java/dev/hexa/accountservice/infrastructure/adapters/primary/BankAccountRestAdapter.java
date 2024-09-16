package dev.hexa.accountservice.infrastructure.adapters.primary;

import dev.hexa.accountservice.application.port.primary.BankAccountServicePort;
import dev.hexa.accountservice.domain.BankAccount;
import dev.hexa.accountservice.domain.Customer;
import dev.hexa.accountservice.infrastructure.adapters.primary.model.mapper.BankAccountRestMapper;
import dev.hexa.accountservice.infrastructure.adapters.primary.model.response.BankAccountResponse;
import dev.hexa.accountservice.infrastructure.clients.CustomerRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class BankAccountRestAdapter {
    private final BankAccountServicePort bankAccountService;
    private final BankAccountRestMapper mapper;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccountResponse> getAccount(@PathVariable String accountId) {
        BankAccount account = bankAccountService.getBankAccount(accountId);
        restCustomer(account);
        return ResponseEntity.ok(mapper.toBankAccountResponse(account));
    }

    @GetMapping
    public ResponseEntity<List<BankAccountResponse>> getBankAccounts() {
        List<BankAccount> accounts = bankAccountService.getAllBankAccount();
        accounts.forEach(this::restCustomer);
        return ResponseEntity.ok(mapper.toBankAccountResponseList(accounts));
    }

    private void restCustomer(BankAccount account) {
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
    }
}
