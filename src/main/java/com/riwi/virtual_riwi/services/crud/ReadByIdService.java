package com.riwi.virtual_riwi.services.crud;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;

public interface ReadByIdService <Entity, ID>{
    public Entity readById(ID id);
}
