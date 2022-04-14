package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {

    CsvScores scores;
    CsvStudents students2;

    @BeforeEach
    void setUp() {
        scores = new CsvScores();
        students2 = new CsvStudents();
        scores.load();
        students2.load();
    }

    @Test
    void loadAndMerge() {
        assertThat(scores.findAll()).isNotNull();
        assertThat(students2.findAll()).isNotNull();
    }
}