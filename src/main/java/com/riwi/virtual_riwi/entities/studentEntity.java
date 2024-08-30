package com.riwi.virtual_riwi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Last_name is required")
    private String last_name;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Must be greater than zero")
    private Integer age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "CreateAt is required")
    private LocalDateTime createAt;

    @NotNull(message = "Status is required")
    private Boolean active = true;

    @NotNull(message = "Class is required")
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

    public StudentEntity(){
        this.createAt = LocalDateTime.now();
    }
}