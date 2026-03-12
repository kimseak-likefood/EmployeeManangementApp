package kh.edu.paragoniu.helloworldapp.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "\"hwwa_user\"")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//
//    @NotBlank(message = "Name is mandatory") //make sure user enter at least one character that is not a whitespace
//    private String name;
//
//    @NotBlank(message = "Email is mandatory")
//    @Column(unique = true) // to prevent duplicating emails
//    private String email;
//
//}

@Entity
@Data
@ToString(exclude = "department")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20, message = "First name cannot exceed 20 characters")
    @NotBlank
    private String  firstName;

    @Size(max = 20, message = "Last name cannot exceed 20 characters")
    @NotBlank
    private String  lastName;

    @Email
    private String email;

    private String phone, jobTitle;

    private LocalDate hireDate;

    private Double salary;

    private String status; // "Active" or "Inactive"

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}