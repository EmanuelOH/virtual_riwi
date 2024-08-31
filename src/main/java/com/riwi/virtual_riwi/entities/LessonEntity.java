package com.riwi.virtual_riwi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean active = true;


    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;

}
