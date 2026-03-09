package kh.edu.paragoniu.helloworldapp.controller;
import jakarta.validation.Valid;
import kh.edu.paragoniu.helloworldapp.models.Department;
import kh.edu.paragoniu.helloworldapp.models.Employee;
import kh.edu.paragoniu.helloworldapp.service.DepartmentService;
import kh.edu.paragoniu.helloworldapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;
    @Autowired DepartmentService deptService;

    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> employees = (keyword != null && !keyword.isEmpty())
                ? empService.search(keyword)
                : empService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("keyword", keyword);
        return "employees/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", deptService.findAll());
        return "employees/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", empService.findById(id));
        model.addAttribute("departments", deptService.findAll());
        return "employees/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee e,
                       BindingResult result, Model model,
                       RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("departments", deptService.findAll());
            return "employees/form";
        }
        empService.save(e);
        ra.addFlashAttribute("success", "Employee saved!");
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        empService.deleteById(id);
        ra.addFlashAttribute("success", "Employee deleted successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("employee", empService.findById(id));
        return "employees/detail";
    }

}
