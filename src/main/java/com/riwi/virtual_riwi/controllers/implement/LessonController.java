package com.riwi.virtual_riwi.controllers.implement;

import com.riwi.virtual_riwi.controllers.interfaces.ILessonController;
import com.riwi.virtual_riwi.dtos.request.lesson.LessonRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.dtos.response.lesson.LessonResponse;
import com.riwi.virtual_riwi.entities.LessonEntity;
import com.riwi.virtual_riwi.services.interfaces.ILessonService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController implements ILessonController {

    @Autowired
    private ILessonService lessonService;

    @Override
    @PatchMapping("/{id}/disable")
    public ResponseEntity<Void> archive(@PathVariable Long id) {
        try {
            lessonService.archive(id);
            return ResponseEntity.noContent().build();
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    @PostMapping
    public ResponseEntity<LessonEntity> create(@Valid @RequestBody LessonRequest lessonRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lessonService.create(lessonRequest));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> readById(@PathVariable Long id) {
        try {
            LessonResponse lessonResponse = lessonService.readById(id);
            return ResponseEntity.ok(lessonResponse);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
