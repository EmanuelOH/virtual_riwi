package com.riwi.virtual_riwi.controllers.implement;

import com.riwi.virtual_riwi.controllers.interfaces.IClassController;
import com.riwi.virtual_riwi.services.interfaces.IClassServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.entities.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/v1/class")
public class ClassController implements IClassController{

    @Autowired
    private IClassServices classServices;

    @Override
    @PostMapping
    public ResponseEntity<ClassEntity> create(@Valid @RequestBody ClassRequest classRequest) {
        ClassEntity createdClass = classServices.create(classRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClass);
    }

    @Override
    @GetMapping("/page")
    public ResponseEntity<Page<ClassEntity>> pageAllElement(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "description", defaultValue = "") String description,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (page < 0 || size <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Page<ClassEntity> result = classServices.pageAllElement(name, description, page, size);
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/readAll")
    public ResponseEntity<List<ClassResponse>> readAll() {
        List<ClassResponse> classResponses = classServices.readAll();
        return ResponseEntity.ok(classResponses);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClassResponse> readById(@PathVariable Long id) {
        try {
            ClassResponse classResponse = classServices.readById(id);
            return ResponseEntity.ok(classResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

