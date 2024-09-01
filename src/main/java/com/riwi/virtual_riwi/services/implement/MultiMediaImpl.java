package com.riwi.virtual_riwi.services.implement;

import com.riwi.virtual_riwi.dtos.request.multi_media.MultiMediaRequest;
import com.riwi.virtual_riwi.dtos.response.multi_media.MultiMediaResponse;
import com.riwi.virtual_riwi.entities.LessonEntity;
import com.riwi.virtual_riwi.entities.MultiMediaEntity;
import com.riwi.virtual_riwi.repositories.interfaces.LessonRepository;
import com.riwi.virtual_riwi.repositories.interfaces.MultiMediaRepository;
import com.riwi.virtual_riwi.services.interfaces.IMultiMediaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MultiMediaImpl implements IMultiMediaService {
    @Autowired
    private MultiMediaRepository multiMediaRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    @Transactional //Una transacción es una secuencia de operaciones que deben ejecutarse
    // de manera atómica: o todas se completan con éxito o ninguna se realiza.
    public MultiMediaEntity create(MultiMediaRequest multiMediaRequest) {
        Long lessonId = multiMediaRequest.getLessonEntity().getId();

        System.out.println(lessonId);
        LessonEntity lessonEntity = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("Class with ID " + lessonId + " not found!"));

        MultiMediaEntity multiMediaEntity = MultiMediaEntity.builder()
                .type(multiMediaRequest.getType())
                .url(multiMediaRequest.getUrl())
                .lessonEntity(lessonEntity)
                .build();

        return multiMediaRepository.save(multiMediaEntity);
    }

    @Override
    public MultiMediaResponse readById(Long id) {
        MultiMediaEntity multiMediaEntity = multiMediaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson with ID " + id + " not found!"));

        MultiMediaResponse multiMediaResponse = new MultiMediaResponse();

        multiMediaResponse.setId(multiMediaEntity.getId());
        multiMediaResponse.setType(multiMediaEntity.getType());
        multiMediaResponse.setUrl(multiMediaEntity.getUrl());
        multiMediaResponse.setLessonEntity(multiMediaEntity.getLessonEntity());

        return multiMediaResponse;
    }
}
