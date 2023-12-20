package com.example.microservice2023.controller.rest;

import com.example.microservice2023.model.Teacher;
import com.example.microservice2023.service.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherRestController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    Teacher getOne(@PathVariable String id){
        return teacherService.getOne(id);
    }

    @GetMapping("/")
    List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @PostMapping("/")
    Teacher create(@RequestBody Teacher teacher){
        return teacherService.create(teacher);
    }

    @PutMapping("/")
    Teacher update(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        teacherService.delete(id);
    }
}
