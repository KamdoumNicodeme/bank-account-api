package dev.hexa.customerservice.application.port.primary;

import dev.hexa.customerservice.domain.model.Customer;

import java.util.List;

public interface CustomerServicePort {
    List<Customer> getCustomerList();
    Customer getCustomerById(Long id);
    Customer createCustomer(Customer customer);
}
