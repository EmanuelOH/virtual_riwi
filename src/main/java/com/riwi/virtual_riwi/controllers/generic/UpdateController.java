package com.riwi.virtual_riwi.controllers.generic;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;
import org.springframework.http.ResponseEntity;

public interface UpdateController<EntityRequest, Entity, ID>{
    public ResponseEntity<Entity> update(EntityRequest request, ID id);
}
