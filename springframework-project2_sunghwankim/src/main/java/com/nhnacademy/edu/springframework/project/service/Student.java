package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.nio.file.Path;

public class Student implements Comparable<Student> {
    private final int seq;
    private final String name;
    private Score score;

    public Student(int seq, String name) {
        this.seq = seq;
        this.name = name;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Score getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}'+ '\n';
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score.getScore() == o.score.getScore()) {
            return 0;
        }
        return this.score.getScore() > o.score.getScore() ? 1 : -1;
    }

    public int getStudentSeq() {
        return this.seq;
    }
}
