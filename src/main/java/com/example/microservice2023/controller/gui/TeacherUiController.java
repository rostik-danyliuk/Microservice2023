package com.example.microservice2023.controller.gui;

import com.example.microservice2023.model.Teacher;
import com.example.microservice2023.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/v1/teachers")
public class TeacherUiController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherUiController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/")
    String showAll(Model model){
        List<Teacher> items = teacherService.getAll();
        model.addAttribute("items", items);
        return "teachers";
    }

    @RequestMapping("/{id}")
    String delete(@PathVariable String id) {
        teacherService.delete(id);
        return "redirect:/ui/v1/teachers/";
    }
}

