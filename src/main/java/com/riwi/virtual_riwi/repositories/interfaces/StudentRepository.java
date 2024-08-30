package com.riwi.virtual_riwi.repositories.interfaces;

import com.riwi.virtual_riwi.entities.StudentEntitys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntitys, Long> {
}
