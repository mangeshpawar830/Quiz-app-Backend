package com.languageLearning.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "QUESTION_BANK")
public class QuestionBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "QUESTIONS", length = 400)
    private String questions;

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_ID")
    private Language language;

    @Column(name = "OPTIONS")
    private String options;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "LEVEL")
    private int level;

}
