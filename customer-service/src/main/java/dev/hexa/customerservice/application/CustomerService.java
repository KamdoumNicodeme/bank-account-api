package dev.hexa.customerservice.application;

import dev.hexa.customerservice.application.annotation.DomainService;
import dev.hexa.customerservice.application.port.primary.CustomerServicePort;
import dev.hexa.customerservice.application.port.secondary.CustomerPersistencePort;
import dev.hexa.customerservice.domain.exception.CustomerNotFoundException;
import dev.hexa.customerservice.domain.model.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@DomainService
public class CustomerService implements CustomerServicePort {
    private final CustomerPersistencePort customerPersistencePort;

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> customers = customerPersistencePort.findAll();
        if (customers.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerPersistencePort.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerPersistencePort.save(customer);
    }

}
