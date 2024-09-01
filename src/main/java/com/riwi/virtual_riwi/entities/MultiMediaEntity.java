package com.riwi.virtual_riwi.entities;

import com.riwi.virtual_riwi.enums.TypeMultiMedia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "multi_media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultiMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TypeMultiMedia type;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_lesson", nullable = false)
    private LessonEntity lessonEntity;
}
