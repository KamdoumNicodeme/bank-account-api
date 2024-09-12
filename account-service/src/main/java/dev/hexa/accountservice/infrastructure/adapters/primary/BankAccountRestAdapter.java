package dev.hexa.accountservice.infrastructure.adapters.primary;

import dev.hexa.accountservice.application.port.primary.BankAccountServicePort;
import dev.hexa.accountservice.infrastructure.adapters.primary.model.mapper.BankAccountRestMapper;
import dev.hexa.accountservice.infrastructure.adapters.primary.model.response.BankAccountResponse;
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

    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccountResponse> getAccount(@PathVariable String accountId){
        return ResponseEntity.ok(mapper.toBankAccountResponse(bankAccountService.getBankAccount(accountId)));
    }
    @GetMapping
   public ResponseEntity<List<BankAccountResponse>> getBankAccounts(){
        return ResponseEntity.ok(mapper.toBankAccountResponseList(bankAccountService.getAllBankAccount()));
   }
}
