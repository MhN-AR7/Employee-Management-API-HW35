package com.management.employee.service;

import com.management.employee.dto.EmployeeRequestDto;
import com.management.employee.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> findAll();
    EmployeeResponseDto findById(Long id);
    EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto);
    void delete(Long id);
    List<EmployeeResponseDto> findByFirstName(String firstName);
    List<EmployeeResponseDto> findByDepartment(String department);
    List<EmployeeResponseDto> searchByEmail(String email);
}
