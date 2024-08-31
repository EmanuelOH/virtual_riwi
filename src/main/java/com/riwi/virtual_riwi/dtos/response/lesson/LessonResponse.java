package com.riwi.virtual_riwi.dtos.response.lesson;

import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.entities.MultiMediaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    private Long id;

    private String title;

    private String description;

    private ClassEntity classEntity;

    private Boolean active = true;

    private List<MultiMediaEntity> multiMediaEntities;
}
