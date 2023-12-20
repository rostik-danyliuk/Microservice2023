package com.example.microservice2023.model;

import com.example.microservice2023.model.enums.Position;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
@Builder
public class Teacher {
    private String id;
    private People people;
    private Position position;
    private Integer experience;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Teacher(People people, Position position, Integer experience, String description) {
        this.people = people;
        this.position = position;
        this.experience = experience;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
