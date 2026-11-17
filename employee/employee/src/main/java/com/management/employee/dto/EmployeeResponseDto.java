package com.management.employee.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeResponseDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String department;

    private BigDecimal salary;
}
