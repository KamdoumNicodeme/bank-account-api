package dev.hexa.accountservice.infrastructure.adapters.secondary.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
