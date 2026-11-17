package com.management.employee.service.impl;

import com.management.employee.command.DtoToEntity;
import com.management.employee.command.EntityToDto;
import com.management.employee.dto.EmployeeRequestDto;
import com.management.employee.dto.EmployeeResponseDto;
import com.management.employee.entity.Employee;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DtoToEntity dtoToEntity, EntityToDto entityToDto) {
        this.employeeRepository = employeeRepository;
        this.dtoToEntity = dtoToEntity;
        this.entityToDto = entityToDto;
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(entityToDto::convert)
                .toList();
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return employeeRepository.findById(id)
                .map(entityToDto::convert).orElse(null);
    }

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeRepository.save(dtoToEntity.convert(employeeRequestDto));
        return entityToDto.convert(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeResponseDto> findByFirstName(String firstName) {
        return employeeRepository.findEmployeeByFirstName(firstName)
                .stream()
                .map(entityToDto::convert)
                .toList();
    }

    @Override
    public List<EmployeeResponseDto> findByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department)
                .stream()
                .map(entityToDto::convert)
                .toList();
    }

    @Override
    public List<EmployeeResponseDto> searchByEmail(String email) {
        return employeeRepository.searchEmployeeByEmail(email)
                .stream()
                .map(entityToDto::convert)
                .toList();
    }
}
