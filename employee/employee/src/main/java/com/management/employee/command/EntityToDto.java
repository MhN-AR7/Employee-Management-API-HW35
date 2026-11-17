package com.management.employee.command;

import com.management.employee.dto.EmployeeResponseDto;
import com.management.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityToDto {
    EmployeeResponseDto convert(Employee employee);
}
