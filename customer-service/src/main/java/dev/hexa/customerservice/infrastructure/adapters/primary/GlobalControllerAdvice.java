package dev.hexa.customerservice.infrastructure.adapters.primary;

import dev.hexa.customerservice.domain.exception.CustomerNotFoundException;


import dev.hexa.customerservice.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleStudentNotFoundException() {
        return ErrorResponse.builder()
                .code("ACCOUNT_NOT_FOUND")
                .message("ACCOUNT_NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .build();
    }





}
