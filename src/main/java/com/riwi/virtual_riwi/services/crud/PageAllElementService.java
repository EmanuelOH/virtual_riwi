package com.riwi.virtual_riwi.services.crud;

import org.springframework.data.domain.Page;

<<<<<<< HEAD
public interface PageAllElementService <Entity, Name, Pages , Size>{
    public Page<Entity> pageAllElement(Name name, Pages pages, Size size);
=======
public interface PageAllElementService <Entity, Name, Description, Pages , Size>{
    public Page<Entity> pageAllElement(Name name, Description description, Pages pages, Size size);
>>>>>>> 8852860eaa02c0d2c57b5eba5fad780077a80df1
}
