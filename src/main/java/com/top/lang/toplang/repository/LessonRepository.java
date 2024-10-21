package com.top.lang.toplang.repository;

import com.top.lang.toplang.entity.LessonEntity;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<LessonEntity, Integer> {
    LessonEntity findBySlug(String slug);
}