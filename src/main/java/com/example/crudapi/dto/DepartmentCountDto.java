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


//package com.example.crudapi.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class DepartmentCountDto {
//    private String department;
//    private String designation;
//    private long employeeCount;
//}
