package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    CsvScores scores;
    CsvStudents students2;
    Map<Integer,Student> students;

    @BeforeEach
    void setUp() {
        scores = new CsvScores();
        students2 = new CsvStudents();
        students = new HashMap<>();
        students2.load();
        scores.load();
    }

    @Test
    void getScoreByStudentName() {
        String name = "A";
        assertThat(students2
            .findAll()
            .stream()
            .filter(student -> student.getName().equals(name))
            .map(Student::getScore)
            .collect(Collectors.toList())).isNotNull();
    }

    @Test
    void getScoreByStudentSeq() {
        int seq = 1;
        students2.merge(scores.findAll());
        assertThat(students2
            .findAll()
            .stream()
            .filter(student -> student.getStudentSeq() == seq)
            .map(Student::getScore)
            .collect(Collectors.toList())
            .get(0)).isNotNull();
    }
}