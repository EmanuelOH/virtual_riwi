package com.riwi.virtual_riwi.repositories.interfaces;

import com.riwi.virtual_riwi.entities.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    //Page<ClassEntity> pageAllElement(String name, String description, Pageable pageable);

    @Query("SELECT c FROM ClassEntity c WHERE c.name LIKE %:name% AND c.description LIKE %:description% AND c.active = true")
    Page<ClassEntity> pageAllElement(
            @Param("name") String name,
            @Param("description") String description,
            Pageable pageable
    );
}
