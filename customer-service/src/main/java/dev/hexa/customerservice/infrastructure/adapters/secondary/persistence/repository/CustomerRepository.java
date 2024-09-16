package dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.repository;

import dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
