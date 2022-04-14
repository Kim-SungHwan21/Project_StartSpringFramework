package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    CsvScores scores;
    CsvStudents students2;

    @BeforeEach
    void setUp() {
        scores = new CsvScores();
        students2 = new CsvStudents();
    }

    @Test
    void getPassedStudents() {
        Students studentRepository = students2;
        assertThat(studentRepository
            .findAll().stream()
            .filter(student -> !student.getScore().isFail())
            .collect(Collectors.toList())).isNotNull();

        assertThat(studentRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    void getStudentsOrderByScore() {
        Students studentRepository = students2;
        assertThat(studentRepository
            .findAll()
            .stream()
            .sorted().collect(Collectors.toList())).isNotNull();

        assertThat(studentRepository.findAll().size()).isEqualTo(0);
    }
}