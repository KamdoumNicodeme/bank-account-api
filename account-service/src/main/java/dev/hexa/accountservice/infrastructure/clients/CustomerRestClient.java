package dev.hexa.accountservice.infrastructure.clients;

import dev.hexa.accountservice.domain.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{customerId}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long customerId);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long customerId, Exception exception) {
         return new Customer(customerId, "Unknown", "Unknown", "Unknown");
    }


    default List<Customer> getAllCustomers(Exception exception) {

        List<Long> customerIds = allCustomers().stream().map(Customer::getId).toList();
        return customerIds.stream().map(this::findCustomerById).toList();

    }
}
