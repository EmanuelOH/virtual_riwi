package com.riwi.virtual_riwi.controllers.generic;

import org.springframework.http.ResponseEntity;

public interface CreateController<EntityRequest, Entity>{
    public ResponseEntity<Entity> create(EntityRequest request);
}
