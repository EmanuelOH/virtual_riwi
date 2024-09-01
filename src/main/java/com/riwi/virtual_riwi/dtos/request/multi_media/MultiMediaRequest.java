package com.riwi.virtual_riwi.dtos.request.multi_media;

import com.riwi.virtual_riwi.entities.LessonEntity;
import com.riwi.virtual_riwi.enums.TypeMultiMedia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultiMediaRequest {
    @NotBlank(message = "Type is required!")
    private TypeMultiMedia type;

    @NotBlank(message = "Url is required!")
    private String url;

    @NotNull(message = "Lesson is required!")
    private LessonEntity lessonEntity;
}
