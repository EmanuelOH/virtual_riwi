package com.riwi.virtual_riwi.repositories.interfaces;

import com.riwi.virtual_riwi.entities.StudentEntitys;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<StudentEntitys, Long> {
    //Page<ClassEntity> pageAllElement(String name, String description, Pageable pageable);

    @Query("SELECT c FROM StudentEntitys c WHERE c.name LIKE %:name% AND c.active = true")
    Page<StudentEntitys> pageAllElement(
            @Param("name") String name,
            Pageable pageable
    );
}
