package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultGradeQueryService implements GradeQueryService {

    Students students;

    @Autowired
    public DefaultGradeQueryService(Students students) {
        this.students = students;
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        return students
                .findAll()
                .stream()
                .filter(student -> student.getName().equals(name))
                .map(Student::getScore)
                .collect(Collectors.toList());
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
            // TODO 6 : 학생 번호로 점수를 반환합니다.
        return students
                .findAll()
                .stream()
                .filter(student -> student.getStudentSeq() == seq)
                .map(Student::getScore)
                .collect(Collectors.toList())
                .get(0);
   }
}