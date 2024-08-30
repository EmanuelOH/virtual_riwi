package com.riwi.virtual_riwi.services.crud;

import org.springframework.data.domain.Page;

public interface PageAllElementService <Entity, Name, Description, Pages , Size>{
    public Page<Entity> pageAllElement(Name name, Description description, Pages pages, Size size);
}
