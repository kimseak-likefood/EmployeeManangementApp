package kh.edu.paragoniu.helloworldapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data //Lombok automatically generate getter and setter
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
