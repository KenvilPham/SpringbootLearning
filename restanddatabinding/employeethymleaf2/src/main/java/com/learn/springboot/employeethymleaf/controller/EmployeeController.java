package com.learn.springboot.employeethymleaf.controller;

import javax.validation.Valid;

import com.learn.springboot.employeethymleaf.model.Employee;
import com.learn.springboot.employeethymleaf.service.EmployeeServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp serviceImp;

    @GetMapping("/employee")
    public String listEmp(Model model) {
        model.addAttribute("employees", serviceImp.findAll());
        return "list";
    }

    @GetMapping("/")
    public String gethome(Model model) {
        return "home";
    }

    @GetMapping("/employee/search")
    public String searchEmployeByEmail(@RequestParam(name = "term") String term, Model model) {
        if (!StringUtils.hasText(term)) {
            return "redirect:/employee";
        }
        model.addAttribute("employees", serviceImp.search(term));
        return "list";
    }

    @GetMapping("/employee/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@Valid Employee emp, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        serviceImp.save(emp);
        redirect.addFlashAttribute("successMessage", "Save employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/edit")
    public String editEmpInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", serviceImp.findById(id));
                return "form";
    }

    @GetMapping("/employee/{id}/delete")
    public String deleteEmp(@PathVariable Integer id, RedirectAttributes redirect) {
        serviceImp.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted employee successfully!");
        return "redirect:/employee";
    }
}
