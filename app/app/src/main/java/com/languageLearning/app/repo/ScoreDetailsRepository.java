package com.languageLearning.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.languageLearning.app.model.Language;
import com.languageLearning.app.model.ScoreDetails;
import com.languageLearning.app.model.User;

@Repository
public interface ScoreDetailsRepository extends JpaRepository<ScoreDetails, Integer>{
    List<ScoreDetails> findByUserAndLanguage(User user, Language language);

}
