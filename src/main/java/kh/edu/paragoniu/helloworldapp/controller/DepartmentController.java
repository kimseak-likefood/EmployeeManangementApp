package kh.edu.paragoniu.helloworldapp.controller;

import jakarta.validation.Valid;
import kh.edu.paragoniu.helloworldapp.models.Department;
import kh.edu.paragoniu.helloworldapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping
    //When a user types ://yourwebsite.com into their browser address bar, this method is triggered.
    //the user GETS the signup page

    // /signup is just URL(web addresses). example: localhost:8080/signup
    public String list(Model model) {
        model.addAttribute("departments", service.findAll());
        return "departments/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("department", new Department());
        return "departments/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("department", service.findById(id));
        model.addAttribute("activePage", "departments");
        return "departments/form";
    }

    @PostMapping("/save")
    //This is triggered when the user clicks the "Submit" button on your HTML form.
    // (Your HTML form must have method="post" and action="/adduser").
    //user fill out the form and POSTS the data to the server
    public String save(@Valid @ModelAttribute Department d,
                       BindingResult result,
                       RedirectAttributes ra) {
        if (result.hasErrors()) return "departments/form";
        service.save(d);
        ra.addFlashAttribute("success", "Department saved!");
        return "redirect:/departments";
    }

    //@Valid makes sure the @NotBlank condition inside User.java is met before it saves
    //@Valid also allows the method hasErrors()
    //If @NotBlank is not met, instead of crashing or throwing an immediate exception, it will stores validation failure inside "result"
    // then result.hasErrors() = true and return "add-user" and user sees the message "Name is mandatory)

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        service.deleteById(id);
        ra.addFlashAttribute("success", "Department deleted!");
        return "redirect:/departments";
    }
}
