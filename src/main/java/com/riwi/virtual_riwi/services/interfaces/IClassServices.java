package com.riwi.virtual_riwi.services.interfaces;

import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.entities.ClassEntity;
import com.riwi.virtual_riwi.services.crud.CreateService;
import com.riwi.virtual_riwi.services.crud.ReadAllService;
import com.riwi.virtual_riwi.services.crud.ReadByIdService;

public interface IClassServices extends
        CreateService<ClassRequest, ClassEntity>,
        ReadAllService<ClassResponse>,
        ReadByIdService<ClassResponse, Long> {
}
