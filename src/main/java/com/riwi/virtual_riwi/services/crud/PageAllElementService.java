package com.riwi.virtual_riwi.services.crud;

import org.springframework.data.domain.Page;

public interface PageAllElementService <Entity, Name, Pages , Size>{
    public Page<Entity> pageAllElement(Name name, Pages pages, Size size);
}
