package kh.edu.paragoniu.helloworldapp.service;

import kh.edu.paragoniu.helloworldapp.models.Employee;
import kh.edu.paragoniu.helloworldapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Employee findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void save(Employee e) {

        if (e.getStatus() == null || e.getStatus().isEmpty()) {
            e.setStatus("Active");
        }
        repo.save(e);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public List<Employee> search(String keyword) {
        return repo.findByFirstNameContainingIgnoreCase(keyword);
    }

    // ✅ Add this new method
    public long countActiveEmployees() {
        return repo.findAll().stream()
                .filter(e -> "Active".equals(e.getStatus()))
                .count();
    }

    // ✅ Add this too for recent employees table
    public List<Employee> findRecent(int limit) {
        return repo.findAll().stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
