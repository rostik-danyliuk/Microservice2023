package com.example.microservice2023.controller.rest;

import com.example.microservice2023.model.Teacher;
import com.example.microservice2023.service.interfaces.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@Tag(name = "Teacher Controller",
description = "CRUD operation")
public class TeacherRestController {
    @Autowired
    TeacherService teacherService;

    @Operation(summary = "Пошук одного викладача")
    @GetMapping("/{id}")
    Teacher getOne(@PathVariable String id){
        return teacherService.getOne(id);
    }

    @Operation(summary = "Пошук всіх викладачів")
    @GetMapping("/")
    List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @Operation(summary = "Додавання одного викладача")
    @PostMapping("/")
    Teacher create(@RequestBody Teacher teacher){
        return teacherService.create(teacher);
    }

    @Operation(summary = "Оновлення інформації про викладача")
    @PutMapping("/")
    Teacher update(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    @Operation(summary = "Видалення викладача з бази даних")
    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        teacherService.delete(id);
    }
}
