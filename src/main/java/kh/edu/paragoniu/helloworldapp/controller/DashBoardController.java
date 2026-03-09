package kh.edu.paragoniu.helloworldapp.controller;

import kh.edu.paragoniu.helloworldapp.service.DepartmentService;
import kh.edu.paragoniu.helloworldapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {

    @Autowired
    EmployeeService empService;
    @Autowired
    DepartmentService deptService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalEmployees", empService.findAll().size());
        model.addAttribute("totalDepartments", deptService.findAll().size());
        model.addAttribute("recentEmployees", empService.findAll()
                .stream().limit(5).toList());
        return "DashBoard";
    }
}
