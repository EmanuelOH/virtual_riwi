package com.riwi.virtual_riwi.dtos.response.student;


import com.riwi.virtual_riwi.entities.ClassEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StudentResponse {
    private Long id;

    private String name;

    private String last_name;

    private Integer age;

    private String email;

    private LocalDateTime createAt;

    private Boolean active = true;

    private ClassEntity classEntity;

    public StudentResponse(){
        this.createAt = LocalDateTime.now();
    }
}
