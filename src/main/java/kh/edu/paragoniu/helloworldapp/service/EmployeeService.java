package kh.edu.paragoniu.helloworldapp.service;

import kh.edu.paragoniu.helloworldapp.models.Employee;
import kh.edu.paragoniu.helloworldapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> findAll() { return repo.findAll(); }
    public Employee findById(Long id) { return repo.findById(id).orElseThrow(); }
    public void save(Employee e) { repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
    public List<Employee> search(String keyword) {
        return repo.findByFirstNameContainingIgnoreCase(keyword);
    }
}
