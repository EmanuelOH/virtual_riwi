package com.riwi.virtual_riwi.repositories.interfaces;

import com.riwi.virtual_riwi.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
