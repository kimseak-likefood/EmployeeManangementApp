package kh.edu.paragoniu.helloworldapp.repositories;

import kh.edu.paragoniu.helloworldapp.models.Department;
import kh.edu.paragoniu.helloworldapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//extends JpaRepo instead of CRUDRepo because I want to build employee maangement system and it needs to return a list
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstNameContainingIgnoreCase(String name);
    List<Employee> findByDepartmentId(Long departmentId);
}
