package kh.edu.paragoniu.helloworldapp.repositories;

import kh.edu.paragoniu.helloworldapp.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
