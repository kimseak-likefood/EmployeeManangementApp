package kh.edu.paragoniu.helloworldapp.service;

import kh.edu.paragoniu.helloworldapp.models.Department;
import kh.edu.paragoniu.helloworldapp.repositories.DepartmentRepository;
import kh.edu.paragoniu.helloworldapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //to tell spring that this part is for business logic and tell it to:
//  1. create one instance of that class automatically at startup, no need for DepartmentService service = new DepartmentService();
// 2. Register in spring's container so that other classes can use it

public class DepartmentService {
    @Autowired //find the object we need and inject it here (repo) automatically
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() { return departmentRepository.findAll(); }
    public Department findById(Long id) { return departmentRepository.findById(id).orElseThrow(); }
    public void save(Department d) { departmentRepository.save(d); }
    public void deleteById(Long id) { departmentRepository.deleteById(id); }
}
