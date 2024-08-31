package com.riwi.virtual_riwi.controllers.implement;

import com.riwi.virtual_riwi.controllers.interfaces.IClassController;
import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.services.interfaces.IClassServices;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/class")
public class ClassController implements IClassController {

    @Autowired
    private IClassServices classServices;

    @Override
    @PostMapping
    public ResponseEntity<ClassEntity> create(@RequestBody @Valid ClassRequest classRequest) {
        return ResponseEntity.ok(classServices.create(classRequest));
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<ClassEntity>> pageAllElement(@PathVariable String name,
                                                            @PathVariable String description,
                                                            @PathVariable Integer pages,
                                                            @PathVariable Integer size) {
        if (pages < 0 || size <= 0) {
            throw new IllegalArgumentException("Error");
        }
        return ResponseEntity.ok(classServices.pageAllElement(name,description,pages,size));
    }

    @Override
    @GetMapping("readAll")
    public ResponseEntity<List<ClassResponse>> readAll() {
        return ResponseEntity.ok(classServices.readAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClassResponse> readById(@PathVariable Long id) {
        try {
            ClassResponse eventFound = classServices.readById(id);
            //Sera codigo 200 de ok
            return ResponseEntity.ok(eventFound);
        }
        catch (EntityNotFoundException e){
            //Sera el codigo 404 not found
            return ResponseEntity.notFound().build();
        }
    }
}
