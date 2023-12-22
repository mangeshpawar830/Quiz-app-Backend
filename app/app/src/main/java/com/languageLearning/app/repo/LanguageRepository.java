package com.languageLearning.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.languageLearning.app.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
