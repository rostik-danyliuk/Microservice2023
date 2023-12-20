package com.example.microservice2023.service.interfaces;

import com.example.microservice2023.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getOne(String id);
    List<Teacher> getAll();
    Teacher create(Teacher teacher);
    Teacher update(Teacher teacher);
    void delete(String id);
}
