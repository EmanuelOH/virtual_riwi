package com.riwi.virtual_riwi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Status is required")
    private Boolean active = true;

    @NotNull(message = "Class is required")
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

}
