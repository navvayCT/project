package com.example.crudapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseDto {
    private String id;
    private String message;
}


//package com.example.crudapi.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class EmployeeResponseDto {
//    private String id;
//    private String name;
//    private String email;
//    private String department;
//    private String designation;
//    private String joinDate;
//}
