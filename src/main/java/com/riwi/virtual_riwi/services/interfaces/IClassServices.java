package com.riwi.virtual_riwi.services.interfaces;

import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.services.crud.CreateService;

public interface IClassServices extends
        CreateService<ClassRequest, ClassEntity> {
}
