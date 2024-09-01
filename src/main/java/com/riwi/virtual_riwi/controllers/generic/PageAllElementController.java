package com.riwi.virtual_riwi.controllers.generic;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

<<<<<<< HEAD
public interface PageAllElementController <Entity, Name,Pages , Size>{
    public ResponseEntity<Page<Entity>> pageAllElement(Name name, Pages pages, Size size);
=======
public interface PageAllElementController<Entity, Name, Description, Pages , Size>{
    public ResponseEntity<Page<Entity>> pageAllElement(Name name, Description description, Pages pages, Size size);
>>>>>>> 8852860eaa02c0d2c57b5eba5fad780077a80df1
}
