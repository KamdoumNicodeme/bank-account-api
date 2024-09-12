package dev.hexa.customerservice.infrastructure.adapters.primary.mapper;

import dev.hexa.customerservice.domain.model.Customer;
import dev.hexa.customerservice.infrastructure.adapters.primary.model.CustomerCreateRequest;
import dev.hexa.customerservice.infrastructure.adapters.primary.model.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerRestMapper {

    CustomerResponse toCustomerResponse(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerCreateRequest request);

    List<CustomerResponse> toCustomerList(List<Customer> customerList);
}
