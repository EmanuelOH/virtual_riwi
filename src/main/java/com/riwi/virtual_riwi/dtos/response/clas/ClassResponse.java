package com.riwi.virtual_riwi.dtos.response.clas;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


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
}
