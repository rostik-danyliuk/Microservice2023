package com.example.microservice2023.model;

import com.example.microservice2023.model.enums.Position;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
@Builder
@Schema(name = "Teacher", description = "Поля для викладача")
public class Teacher {
    @Id
    @Schema(name = "ID",
            description = "унікальний ідентифікатор",
            accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    @Schema(name = "People", description = "Повна інформація про людину")
    private People people;
    @Schema(name = "Position", description = "Посада викладача")
    private Position position;
    @Schema(name = "Experience", description = "Досвід роботи викладачем")
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
