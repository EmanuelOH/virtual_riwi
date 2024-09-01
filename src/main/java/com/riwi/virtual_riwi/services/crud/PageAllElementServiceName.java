package com.riwi.virtual_riwi.services.crud;

import org.springframework.data.domain.Page;

public interface PageAllElementServiceName <Entity, Name, Pages , Size>{
    public Page<Entity> pageAllElementName(Name name, Pages pages, Size size);

}
