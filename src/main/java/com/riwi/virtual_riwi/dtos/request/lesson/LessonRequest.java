package com.riwi.virtual_riwi.dtos.request.lesson;

import com.riwi.virtual_riwi.entities.ClassEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Class is required")
    private ClassEntity classEntity;
}
