package com.riwi.virtual_riwi.services.crud;

public interface ReadByIdService <Entity, ID>{
    public Entity readById(ID id);
}
