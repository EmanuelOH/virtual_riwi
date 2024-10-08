package com.riwi.virtual_riwi.controllers.generic;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


public interface PageAllElementController<Entity, Name, Description, Pages , Size>{
    public ResponseEntity<Page<Entity>> pageAllElement(Name name, Description description, Pages pages, Size size);
}
