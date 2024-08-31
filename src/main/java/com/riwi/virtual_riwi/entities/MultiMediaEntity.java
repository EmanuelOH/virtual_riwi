package com.riwi.virtual_riwi.entities;

import com.riwi.virtual_riwi.enums.TypeMultiMedia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "multi_media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultiMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TypeMultiMedia type;

    @NotNull(message = "id_lesson is required!")
    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private LessonEntity lessonEntity;
}
