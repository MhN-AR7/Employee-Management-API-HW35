package com.management.employee.repository;

import com.management.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeesByDepartment(String department);

    @Query("SELECT e FROM Employee e WHERE e.email =:email")
    List<Employee> searchEmployeeByEmail(@Param("email") String email);
}
