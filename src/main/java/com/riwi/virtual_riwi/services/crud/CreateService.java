package com.riwi.virtual_riwi.services.crud;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;

public interface CreateService <EntityRequest, Entity>{
    public Entity create(EntityRequest request);
}
