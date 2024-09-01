package com.riwi.virtual_riwi.controllers.implement;

import com.riwi.virtual_riwi.controllers.interfaces.IStudentController;
import com.riwi.virtual_riwi.dtos.request.student.StudentRequest;
import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;
import com.riwi.virtual_riwi.services.interfaces.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Students", description = "This is the students controller!")
public class StudentController implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @Override
    @PostMapping("/students")
    /*@Operation(
            summary = "This endpoint is to create!",
            description = "This endpoint requires you to send the students information!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "This error occurs when an attribute is missing or the type is invalid!",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            }
    )*/
    public ResponseEntity<StudentEntitys> create(@RequestBody @Valid StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(studentRequest));
    }

    @Override
    @GetMapping("/students")
    public ResponseEntity<List<StudentResponse>> readAll() {
        List<StudentResponse> studentResponses = studentService.readAll();
        return ResponseEntity.ok(studentResponses);
    }

    @Override
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponse> readById(@PathVariable Long id) {
        try {
            StudentResponse studentResponse = studentService.readById(id);

            return ResponseEntity.ok(studentResponse);
        } catch (EntityActionVetoException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @PutMapping("/students")
    public ResponseEntity<StudentEntitys> update(StudentRequest studentRequest, Long id) {
        return ResponseEntity.ok(studentService.update(studentRequest, id));
    }

    @Override
    @PatchMapping("/students/{id}/disable")
    public ResponseEntity<Void> archiveController(Long id) {
        try {
            studentService.archive(id);
            return ResponseEntity.ok().build(); // Returns a 200 OK status if all goes well
        } catch (EntityActionVetoException error) {
            return ResponseEntity.notFound().build(); // Returns a 404 Not Found status if the student doesn't exist
        }
    }

    @Override
    @GetMapping("/page")
    public ResponseEntity<Page<StudentEntitys>> pageAllElementName(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (page < 0 || size <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Page<StudentEntitys> result = studentService.pageAllElementName(name, page, size);
        return ResponseEntity.ok(result);
    }
}
