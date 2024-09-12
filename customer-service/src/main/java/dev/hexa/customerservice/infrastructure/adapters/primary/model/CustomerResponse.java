package dev.hexa.customerservice.infrastructure.adapters.primary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
