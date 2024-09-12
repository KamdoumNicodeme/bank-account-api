package dev.hexa.customerservice.infrastructure.adapters.secondary;

import dev.hexa.customerservice.application.port.secondary.CustomerPersistencePort;
import dev.hexa.customerservice.domain.model.Customer;
import dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.mapper.CustomerPersistenceMapper;
import dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements CustomerPersistencePort {
    private final CustomerPersistenceMapper customerPersistenceMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerPersistenceMapper.toCustomerList((customerRepository.findAll()));
    }

    @Override
    public Optional<Customer> findById(Long id) {

        return customerRepository.findById(id).map(customerPersistenceMapper::toCustomer);
    }

    @Override
    public Customer save(Customer customer) {
        return customerPersistenceMapper.toCustomer(customerRepository.save(customerPersistenceMapper.toCustomerEntity(customer)));
    }
}
