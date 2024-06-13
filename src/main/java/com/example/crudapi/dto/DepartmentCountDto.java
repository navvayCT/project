package com.example.crudapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentCountDto {
    private String department;
    private String designation;
    private long employeeCount;
}