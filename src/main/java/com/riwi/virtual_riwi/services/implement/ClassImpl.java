package com.riwi.virtual_riwi.services.implement;

import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.repositories.interfaces.ClassRepository;
import com.riwi.virtual_riwi.services.interfaces.IClassServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClassImpl implements IClassServices {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public ClassEntity create(ClassRequest classRequest) {

        ClassEntity classEntity = new ClassEntity();

        classEntity.builder()
                .name(classRequest.getName())
                .description(classRequest.getDescription());

        return classRepository.save(classEntity);
    }

    @Override
    public List<ClassResponse> readAll() {
        List<ClassEntity> listClass = classRepository.findAll();

        List<ClassResponse> listClasResponse = new ArrayList<>();

        for (ClassEntity classEntity: listClass) {
            ClassResponse classResponse = new ClassResponse();

            classResponse.setId(classEntity.getId());
            classResponse.setName(classEntity.getName());
            classResponse.setDescription(classResponse.getDescription());
            classResponse.setActive(classEntity.getActive());

            listClasResponse.add(classResponse);
        }

        return listClasResponse;
    }

    @Override
    public ClassResponse readById(Long id) {

        ClassEntity classEntity = classRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));

        ClassResponse classResponse = new ClassResponse();

        classResponse.setId(classEntity.getId());
        classResponse.setName(classEntity.getName());
        classResponse.setDescription(classResponse.getDescription());
        classResponse.setActive(classEntity.getActive());

        return classResponse;
    }
}
