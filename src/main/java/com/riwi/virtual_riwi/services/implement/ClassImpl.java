package com.riwi.virtual_riwi.services.implement;

import com.riwi.virtual_riwi.services.interfaces.IClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.repositories.interfaces.ClassRepository;

@Service
public class ClassImpl implements IClassServices {

    @Autowired
    private ClassRepository classRepository;

    @Transactional
    @Override
    public ClassEntity create(ClassRequest classRequest) {
        ClassEntity classEntity = ClassEntity.builder()
                .name(classRequest.getName())
                .description(classRequest.getDescription())
                .active(true)
                .build();
        return classRepository.save(classEntity);
    }

    @Override
    public List<ClassResponse> readAll() {
        List<ClassEntity> listClass = classRepository.findAll();

        List<ClassResponse> listClassResponse = new ArrayList<>();

        for (ClassEntity classEntity : listClass) {
            ClassResponse classResponse = new ClassResponse();
            classResponse.setId(classEntity.getId());
            classResponse.setName(classEntity.getName());
            classResponse.setDescription(classEntity.getDescription());
            classResponse.setActive(classEntity.getActive());
            listClassResponse.add(classResponse);
        }
        return listClassResponse;
    }

    @Override
    public ClassResponse readById(Long id) {
        ClassEntity classEntity = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        ClassResponse classResponse = new ClassResponse();
        classResponse.setId(classEntity.getId());
        classResponse.setName(classEntity.getName());
        classResponse.setDescription(classEntity.getDescription());
        classResponse.setActive(classEntity.getActive());
        return classResponse;
    }

    @Override
    public Page<ClassEntity> pageAllElement(String name, String description, Integer page, Integer size) {
        return classRepository.pageAllElement(name, description, PageRequest.of(page, size));
    }
}

