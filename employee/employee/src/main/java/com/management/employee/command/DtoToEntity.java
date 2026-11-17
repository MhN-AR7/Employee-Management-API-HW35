package com.management.employee.command;

import com.management.employee.dto.EmployeeRequestDto;
import com.management.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoToEntity {
    Employee convert(EmployeeRequestDto employeeRequestDto);
}
