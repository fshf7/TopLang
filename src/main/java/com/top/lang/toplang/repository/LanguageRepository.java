package com.top.lang.toplang.repository;

import com.top.lang.toplang.entity.LanguageEntity;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<LanguageEntity, Integer> {
    LanguageEntity findByCode(String code);
}
