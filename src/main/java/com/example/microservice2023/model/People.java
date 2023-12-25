package com.example.microservice2023.model;

import lombok.*;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class People {
    @SuppressWarnings("checkstyle:Indentation")
    private String firstName;
    @SuppressWarnings("checkstyle:Indentation")
    private String lastName;
    @SuppressWarnings("checkstyle:Indentation")
    private String patronymic;
    @SuppressWarnings("checkstyle:Indentation")
    private Integer age;
}
