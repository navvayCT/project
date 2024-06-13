package com.example.crudapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequestDto {
    private String name;
    private String email;
    private String department;
    private String designation;
    private LocalDate joinDate;
}


//package com.example.crudapi.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//
//
//public class EmployeeRequestDto {
//    private String name;
//    private String email;
//    private String department;
//    private String designation;
//    private LocalDate joinDate;
//
//}
