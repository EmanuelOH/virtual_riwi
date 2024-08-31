package com.riwi.virtual_riwi.services.crud;

import com.riwi.virtual_riwi.dtos.response.student.StudentResponse;

import java.util.List;

public interface ReadAllService <Entity>{
    public List<Entity> readAll();
}
