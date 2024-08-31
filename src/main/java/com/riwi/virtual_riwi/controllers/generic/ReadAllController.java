package com.riwi.virtual_riwi.controllers.generic;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReadAllController<Entity>{
    public ResponseEntity<List<Entity>> readAll();
}
