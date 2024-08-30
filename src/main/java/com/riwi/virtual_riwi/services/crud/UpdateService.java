package com.riwi.virtual_riwi.services.crud;

public interface UpdateService <EntityRequest, Entity, ID>{
    public Entity update(EntityRequest request, ID id);
}
