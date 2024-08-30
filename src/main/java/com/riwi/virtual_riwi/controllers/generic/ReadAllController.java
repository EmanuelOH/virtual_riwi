package com.riwi.virtual_riwi.controllers.generic;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReadAllController<Entity>{
    public ResponseEntity<List<Entity>> readAll();
}
