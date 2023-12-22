package com.languageLearning.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.languageLearning.app.model.Language;
import com.languageLearning.app.model.QuestionBank;

@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Integer>{
    List<QuestionBank> findByLanguage(Language language);

}
