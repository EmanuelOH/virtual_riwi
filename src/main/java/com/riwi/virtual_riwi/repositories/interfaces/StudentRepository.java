package com.riwi.virtual_riwi.repositories.interfaces;

import com.riwi.virtual_riwi.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
