package com.management.employee.controller;

import com.management.employee.dto.EmployeeRequestDto;
import com.management.employee.dto.EmployeeResponseDto;
import com.management.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> findAll() {
        List<EmployeeResponseDto> employees = employeeService.findAll();

        if (employees.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> findById(@PathVariable Long id) {
        EmployeeResponseDto employee = employeeService.findById(id);

        if (employee == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDto> save(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employee = employeeService.save(employeeRequestDto);

        if (employee == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponseDto>> findByFirstName(@RequestParam String firstName) {
        List<EmployeeResponseDto> employees = employeeService.findByFirstName(firstName);

        if (employees.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/byDepartment")
    public ResponseEntity<List<EmployeeResponseDto>> findByDepartment(@RequestParam String department) {
        List<EmployeeResponseDto> employees = employeeService.findByDepartment(department);
        
        if (employees.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<List<EmployeeResponseDto>> searchByEmail(@RequestParam String email) {
        List<EmployeeResponseDto> employees = employeeService.searchByEmail(email);

        if (employees.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/auth-test")
    public String authTest() {
        return "Authenticated!";
    }
}
