package com.riwi.virtual_riwi.services.implement;

import com.riwi.virtual_riwi.dtos.request.lesson.LessonRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.dtos.response.lesson.LessonResponse;
import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.entities.LessonEntity;
import com.riwi.virtual_riwi.repositories.interfaces.ClassRepository;
import com.riwi.virtual_riwi.repositories.interfaces.LessonRepository;
import com.riwi.virtual_riwi.services.interfaces.ILessonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonImpl implements ILessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    @Transactional //una transacción es una secuencia de operaciones que deben ejecutarse
    // de manera atómica: o todas se completan con éxito o ninguna se realiza.
    public void archive(Long id) {
        LessonEntity lessonEntity = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson with ID " + id + " not found"));

        lessonEntity.setActive(false);

        lessonRepository.save(lessonEntity);
    }

    @Override
    @Transactional
    public LessonEntity create(LessonRequest lessonRequest) {
        Long classId = lessonRequest.getClassEntity().getId();

        System.out.println(classId);
        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new EntityNotFoundException("Class with ID " + classId + " not found"));

        LessonEntity lessonEntity = LessonEntity.builder()
                .title(lessonRequest.getTitle())
                .description(lessonRequest.getDescription())
                .classEntity(classEntity)
                .active(true)
                .build();

        return lessonRepository.save(lessonEntity);
    }


    @Override
    public LessonResponse readById(Long id) {
        LessonEntity lessonEntity = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson with ID " + id + " not found"));

        LessonResponse lessonResponse = new LessonResponse();

        lessonResponse.setId(lessonEntity.getId());
        lessonResponse.setTitle(lessonEntity.getTitle());
        lessonResponse.setDescription(lessonEntity.getDescription());
        lessonResponse.setActive(lessonEntity.getActive());
        lessonResponse.setClassEntity(lessonEntity.getClassEntity());
        lessonResponse.setMultiMediaEntities(lessonEntity.getMultiMediaEntities());

        return lessonResponse;
    }
}
