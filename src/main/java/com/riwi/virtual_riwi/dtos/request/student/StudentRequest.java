package com.riwi.virtual_riwi.dtos.request.student;

import com.riwi.virtual_riwi.entities.ClassEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Last name is required!")
    private String last_name;

    @NotNull(message = "Age is required!")
    @Min(value = 0, message = "Must be greater than zero")
    private Integer age;

    @NotBlank(message = "Email is required!")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Create At is required!")
    private LocalDateTime createAt;

    @NotNull(message = "ID foreign is required!")
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

}
