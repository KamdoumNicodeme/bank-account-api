package dev.hexa.accountservice.domain;

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
