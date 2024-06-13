//package com.example.crudapi.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.LocalDate;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Document(collection = "employees")
//public class Employee {
//    @Id
//    private String id;
//    private String name;
//    private String email;
//    private String department;
//    private String designation;
//    private LocalDate joinDate;
//}

package com.example.crudapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String department;
    private String designation;
    private LocalDate joinDate;
}
