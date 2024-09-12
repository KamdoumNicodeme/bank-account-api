package dev.hexa.customerservice.infrastructure.adapters.secondary.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cust_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
