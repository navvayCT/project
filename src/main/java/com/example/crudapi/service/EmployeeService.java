package com.example.crudapi.service;

import com.example.crudapi.dto.AverageExperienceDto;
import com.example.crudapi.dto.DepartmentCountDto;
import com.example.crudapi.dto.EmployeeRequestDto;
import com.example.crudapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeRequestDto requestDto);
    Employee getEmployeeById(String id);
    void updateEmployee(String id, EmployeeRequestDto requestDto);
    void deleteEmployee(String id);
    AverageExperienceDto calculateAverageExperience();
    List<DepartmentCountDto> getEmployeeCountByDepartment(String designation);
}