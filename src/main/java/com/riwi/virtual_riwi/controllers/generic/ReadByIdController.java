package com.riwi.virtual_riwi.controllers.generic;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import org.springframework.http.ResponseEntity;

public interface ReadByIdController<Entity, ID>{
    public ResponseEntity<Entity> readById(ID id);
}
