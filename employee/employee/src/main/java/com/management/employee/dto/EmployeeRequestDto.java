package com.management.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeRequestDto {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 100)
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String department;

    @NotNull
    private BigDecimal salary;
}
