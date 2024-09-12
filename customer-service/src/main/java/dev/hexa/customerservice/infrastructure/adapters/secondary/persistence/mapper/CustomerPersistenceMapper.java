package dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.mapper;

import dev.hexa.customerservice.domain.model.Customer;
import dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerPersistenceMapper {

        CustomerEntity toCustomerEntity(Customer customer);
        Customer toCustomer(CustomerEntity customerEntity);
        List<Customer> toCustomerList(List<CustomerEntity> customers);


}
