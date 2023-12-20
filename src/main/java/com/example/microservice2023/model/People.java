package com.example.microservice2023.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class People {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer age;
}
