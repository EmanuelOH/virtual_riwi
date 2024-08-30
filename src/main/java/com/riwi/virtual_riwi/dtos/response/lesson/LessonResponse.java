package com.riwi.virtual_riwi.dtos.response.lesson;

import com.riwi.virtual_riwi.entities.ClassEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
    private Long id;

    private String title;

    private String description;

    private ClassEntity classEntity;

    private Boolean active = true;
}
