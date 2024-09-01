package com.riwi.virtual_riwi.controllers.interfaces;

import com.riwi.virtual_riwi.controllers.generic.CreateController;
import com.riwi.virtual_riwi.controllers.generic.PageAllElementController;
import com.riwi.virtual_riwi.controllers.generic.ReadAllController;
import com.riwi.virtual_riwi.controllers.generic.ReadByIdController;
import com.riwi.virtual_riwi.dtos.request.clas.ClassRequest;
import com.riwi.virtual_riwi.dtos.response.clas.ClassResponse;
import com.riwi.virtual_riwi.entities.ClassEntity;

public interface IClassController extends
        CreateController<ClassRequest, ClassEntity>,
        ReadAllController<ClassResponse>,
        ReadByIdController<ClassResponse, Long>,
        PageAllElementController<ClassEntity, String, String, Integer, Integer> {
}
