package com.riwi.virtual_riwi.dtos.response.clas;

import com.riwi.virtual_riwi.entities.StudentEntitys;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassResponse {
    private Long id;

    private String name;

    private String description;

    private Boolean active = true;

    private List<StudentEntitys> students;
}
