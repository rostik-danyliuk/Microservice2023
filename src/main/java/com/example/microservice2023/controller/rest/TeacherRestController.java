package com.example.microservice2023.controller.rest;

import com.example.microservice2023.model.Teacher;
import com.example.microservice2023.service.interfaces.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@Tag(name = "Teacher Controller",
description = "CRUD operation")
public class TeacherRestController {

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Operation(summary = "Search for one teacher")
    @GetMapping("/{id}")
    ResponseEntity<Teacher> getOne(@PathVariable String id){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.teacherService.getOne(id));
    }

    @Operation(summary = "Search all teachers")
    @GetMapping("/")
    ResponseEntity<List<Teacher>> getAll(){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.teacherService.getAll());
    }

    @Operation(summary = "Adding one teacher")
    @PostMapping("/")
    Teacher create(@RequestBody Teacher teacher){
        return teacherService.create(teacher);
    }

    @Operation(summary = "Updating information about the teacher")
    @PutMapping("/")
    Teacher update(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    @Operation(summary = "Removing the teacher from the database")
    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        teacherService.delete(id);
    }
}
