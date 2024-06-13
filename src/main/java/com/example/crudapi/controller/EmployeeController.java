package com.example.crudapi.controller;

import com.example.crudapi.dto.EmployeeRequestDto;
import com.example.crudapi.dto.EmployeeResponseDto;
import com.example.crudapi.dto.AverageExperienceDto;
import com.example.crudapi.dto.DepartmentCountDto;
import com.example.crudapi.model.Employee;
import com.example.crudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto requestDto) {
        Employee employee = employeeService.createEmployee(requestDto);
        return new ResponseEntity<>(new EmployeeResponseDto(employee.getId(), "Employee created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable String id, @RequestBody EmployeeRequestDto requestDto) {
        employeeService.updateEmployee(id, requestDto);
        return new ResponseEntity<>(new EmployeeResponseDto(id, "Employee updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new EmployeeResponseDto(id, "Employee deleted successfully"), HttpStatus.OK);
    }

    @GetMapping("/average-experience")
    public ResponseEntity<AverageExperienceDto> getAverageExperience() {
        AverageExperienceDto averageExperienceDto = employeeService.calculateAverageExperience();
        return ResponseEntity.ok(averageExperienceDto);
    }

    @GetMapping("/department-count")
    public ResponseEntity<List<DepartmentCountDto>> getEmployeeCountByDepartment(@RequestParam(required = false) String designation) {
        List<DepartmentCountDto> counts = employeeService.getEmployeeCountByDepartment(designation);
        return ResponseEntity.ok(counts);
    }
}
