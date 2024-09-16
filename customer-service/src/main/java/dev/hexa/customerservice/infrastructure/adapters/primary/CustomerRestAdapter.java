package dev.hexa.customerservice.infrastructure.adapters.primary;

import dev.hexa.customerservice.application.port.primary.CustomerServicePort;
import dev.hexa.customerservice.infrastructure.adapters.primary.mapper.CustomerRestMapper;
import dev.hexa.customerservice.infrastructure.adapters.primary.model.CustomerCreateRequest;
import dev.hexa.customerservice.infrastructure.adapters.primary.model.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerRestAdapter {
    private final CustomerServicePort customerService;
    private final CustomerRestMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toCustomerResponse(customerService.getCustomerById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomerList(){
        return ResponseEntity.ok(mapper.toCustomerList(customerService.getCustomerList()));
    }
    @PostMapping
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody CustomerCreateRequest request){
        return ResponseEntity.ok(mapper.toCustomerResponse(customerService.createCustomer (mapper.toCustomer(request))));
    }
}
