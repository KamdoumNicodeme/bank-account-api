package dev.hexa.customerservice.application.port.secondary;

import dev.hexa.customerservice.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerPersistencePort {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
}
