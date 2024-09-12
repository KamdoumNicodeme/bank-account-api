package dev.hexa.customerservice;

import dev.hexa.customerservice.domain.model.Customer;
import dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.mapper.CustomerPersistenceMapper;
import dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository repository, CustomerPersistenceMapper mapper){
		return args -> {
			Customer customer =
					Customer.builder()
							.lastName("nicolas")
							.firstName("jean")
							.email("nicolas@gmail.com")
							.build();

			repository.save(mapper.toCustomerEntity(customer));
        };

	}

}
