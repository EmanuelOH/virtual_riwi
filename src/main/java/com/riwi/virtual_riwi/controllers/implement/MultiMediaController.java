package com.riwi.virtual_riwi.controllers.implement;

import com.riwi.virtual_riwi.controllers.interfaces.IMultiMediaController;
import com.riwi.virtual_riwi.dtos.request.multi_media.MultiMediaRequest;
import com.riwi.virtual_riwi.dtos.response.multi_media.MultiMediaResponse;
import com.riwi.virtual_riwi.entities.MultiMediaEntity;
import com.riwi.virtual_riwi.services.interfaces.IMultiMediaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
public class MultiMediaController implements IMultiMediaController {
    @Autowired
    private IMultiMediaService multiMediaService;

    @Override
    @PostMapping("/createMultimedia")
    public ResponseEntity<MultiMediaEntity> create(@Valid @RequestBody MultiMediaRequest multiMediaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(multiMediaService.create(multiMediaRequest));
    }

    @Override
    @GetMapping("/{id}/multimedia")
    public ResponseEntity<MultiMediaResponse> readById(@PathVariable Long id) {
        try {
            MultiMediaResponse multiMediaResponse = multiMediaService.readById(id);
            return ResponseEntity.ok((multiMediaResponse));
        } catch (EntityNotFoundException error) {
            return ResponseEntity.notFound().build();
        }
    }
}
