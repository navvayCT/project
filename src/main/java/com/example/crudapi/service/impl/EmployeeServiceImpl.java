package com.example.crudapi.service.impl;

import com.example.crudapi.dto.AverageExperienceDto;
import com.example.crudapi.dto.DepartmentCountDto;
import com.example.crudapi.dto.EmployeeRequestDto;
import com.example.crudapi.model.Employee;
import com.example.crudapi.repository.EmployeeRepository;
import com.example.crudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(EmployeeRequestDto requestDto) {
        Employee employee = new Employee();
        employee.setName(requestDto.getName());
        employee.setEmail(requestDto.getEmail());
        employee.setDepartment(requestDto.getDepartment());
        employee.setDesignation(requestDto.getDesignation());
        employee.setJoinDate(requestDto.getJoinDate());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public void updateEmployee(String id, EmployeeRequestDto requestDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(requestDto.getName());
        employee.setEmail(requestDto.getEmail());
        employee.setDepartment(requestDto.getDepartment());
        employee.setDesignation(requestDto.getDesignation());
        employee.setJoinDate(requestDto.getJoinDate());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public AverageExperienceDto calculateAverageExperience() {
        List<Employee> employees = employeeRepository.findAll();
        double averageExperience = employees.stream()
                .mapToLong(employee -> ChronoUnit.YEARS.between(employee.getJoinDate(), LocalDate.now()))
                .average()
                .orElse(0);
        return new AverageExperienceDto(averageExperience);
    }

    @Override
    public List<DepartmentCountDto> getEmployeeCountByDepartment(String designation) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .filter(employee -> designation == null || employee.getDesignation().equals(designation))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new DepartmentCountDto(entry.getKey(), designation, entry.getValue()))
                .collect(Collectors.toList());
    }
}