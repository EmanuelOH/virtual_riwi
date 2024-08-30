package com.riwi.virtual_riwi.services.crud;

public interface CreateService <EntityRequest, Entity>{
    public Entity create(EntityRequest request);
}
