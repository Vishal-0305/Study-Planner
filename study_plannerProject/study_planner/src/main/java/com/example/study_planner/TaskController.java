package com.example.study_planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepo.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Task task) {
        taskRepo.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Task task = taskRepo.findById(id).orElse(null);
        model.addAttribute("task", task);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskRepo.deleteById(id);
        return "redirect:/";
    }
    
    
    
    
    
}
