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


//
//package com.example.crudapi.controller;
//
//import com.example.crudapi.dto.*;
//import com.example.crudapi.model.Employee;
//import com.example.crudapi.service.EmployeeService;
//import jakarta.validation.Valid;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Data
//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;
//
//    @PostMapping
//    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto request) {
//        Employee employee = new Employee();
//        employee.setName(request.getName());
//        employee.setEmail(request.getEmail());
//        employee.setDepartment(request.getDepartment());
//        employee.setDesignation(request.getDesignation());
//        employee.setJoinDate(request.getJoinDate());
//
//        Employee createdEmployee = employeeService.createEmployee(employee);
//
//        EmployeeResponseDto response = new EmployeeResponseDto();
//        response.setId(createdEmployee.getId());
//        response.setName(createdEmployee.getName());
//        response.setEmail(createdEmployee.getEmail());
//        response.setDepartment(createdEmployee.getDepartment());
//        response.setDesignation(createdEmployee.getDesignation());
//        response.setJoinDate(createdEmployee.getJoinDate().toString());
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable String id) {
//        Employee employee = employeeService.getEmployeeById(id);
//        if (employee == null) {
//            return ResponseEntity.notFound().build();
//        }
//        EmployeeResponseDto response = new EmployeeResponseDto();
//        response.setId(employee.getId());
//        response.setName(employee.getName());
//        response.setEmail(employee.getEmail());
//        response.setDepartment(employee.getDepartment());
//        response.setDesignation(employee.getDesignation());
//        response.setJoinDate(employee.getJoinDate().toString());
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateEmployee(@PathVariable String id, @Valid @RequestBody EmployeeRequestDto request) {
//        Employee employee = new Employee();
//        employee.setName(request.getName());
//        employee.setEmail(request.getEmail());
//        employee.setDepartment(request.getDepartment());
//        employee.setDesignation(request.getDesignation());
//        employee.setJoinDate(request.getJoinDate());
//
//        employeeService.updateEmployee(id, employee);
//        return ResponseEntity.ok("Employee updated successfully");
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
//
//    @GetMapping("/average-experience")
//    public ResponseEntity<AverageExperienceDto> getAverageExperience() {
//        return ResponseEntity.ok(employeeService.getAverageExperience());
//    }
//
//    @GetMapping("/department-count")
//    public ResponseEntity<List<DepartmentCountDto>> getEmployeeCountByDepartmentAndDesignation(@RequestParam(required = false) String designation) {
//        return ResponseEntity.ok(employeeService.getEmployeeCountByDepartmentAndDesignation(designation));
//    }
//}
