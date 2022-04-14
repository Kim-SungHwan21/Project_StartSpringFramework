package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {

    Students students;

    @Autowired
    public DefaultStudentService(Students students) {
        this.students = students;
    }

    @Override
    public Collection<Student> getPassedStudents() {
        Students studentRepository = students;
        // TODO 1 : pass 한 학생만 반환하도록 수정하세요.
        System.out.println("test2");
        return studentRepository
            .findAll().stream()
            .filter(student -> !student.getScore().isFail())
            .collect(Collectors.toList());
    }
    @Override
    public Collection<Student> getStudentsOrderByScore() {
        Students studentRepository = students;         // Comparator.reverseOrder(Student::getScore) 1. 성적 -> 2. 반환 // try to generify
        // TODO 4 : 성적 순으로 학생 정보를 반환합니다.
        System.out.println("test3");
        return studentRepository
                .findAll()
                .stream()
                .sorted().collect(Collectors.toList());

    }

}
