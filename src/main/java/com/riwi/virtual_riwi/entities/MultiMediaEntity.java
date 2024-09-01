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

<<<<<<< HEAD
    @NotNull(message = "id_lesson is required!")
    @ManyToOne
=======
    @NotNull(message = "type is required")
    private String url;

    @NotNull(message = "id_lesson is required")
    @OneToOne
>>>>>>> 8852860eaa02c0d2c57b5eba5fad780077a80df1
    @JoinColumn(name = "id_lesson")
    private LessonEntity lessonEntity;
}
