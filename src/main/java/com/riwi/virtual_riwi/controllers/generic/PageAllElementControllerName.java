package com.riwi.virtual_riwi.controllers.generic;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface PageAllElementControllerName<Entity, Name, Pages , Size>{
    public ResponseEntity<Page<Entity>> pageAllElementName(Name name, Pages pages, Size size);
}
