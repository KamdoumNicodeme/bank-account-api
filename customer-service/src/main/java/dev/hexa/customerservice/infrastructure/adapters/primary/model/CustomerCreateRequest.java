package dev.hexa.customerservice.infrastructure.adapters.primary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
}
