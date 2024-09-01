package com.riwi.virtual_riwi.dtos.response.multi_media;

import com.riwi.virtual_riwi.entities.LessonEntity;
import com.riwi.virtual_riwi.enums.TypeMultiMedia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultiMediaResponse {
    private Long id;

    private TypeMultiMedia type;

    private String url;

    private LessonEntity lessonEntity;
}
