package com.riwi.virtual_riwi.services.crud;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;
import com.riwi.virtual_riwi.entities.StudentEntitys;

public interface UpdateService <EntityRequest, Entity, ID>{
    public StudentEntitys<Entity> update(EntityRequest request, ID id);
}
