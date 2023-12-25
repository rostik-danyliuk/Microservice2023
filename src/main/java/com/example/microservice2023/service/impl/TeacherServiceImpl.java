package com.example.microservice2023.service.impl;

import com.example.microservice2023.model.People;
import com.example.microservice2023.model.Teacher;
import com.example.microservice2023.model.enums.Position;
import com.example.microservice2023.repository.TeacherRepository;
import com.example.microservice2023.service.interfaces.TeacherService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void init(){repository.save(new Teacher(new People("Rost", "Dan",
            "Vol", 25),
            Position.SENIOR_TEACHER, 2, "People"));}
    @Override
    public Teacher getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher create(Teacher teacher) {
        teacher.setCreatedAt(LocalDateTime.now());
        return repository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        String id = teacher.getId();
        Teacher teacher1 = this.getOne(id);
        teacher.setCreatedAt(teacher1.getCreatedAt());
        teacher.setUpdatedAt(LocalDateTime.now());
        return repository.save(teacher);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
