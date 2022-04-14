package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {

    CsvScores scores;
    CsvStudents students2;


    @BeforeEach
    void setUp() {
        scores = new CsvScores();
        students2 = new CsvStudents();
    }

    @Test
    void load() {
        final Map<Integer,Student> students = new HashMap<>();
        String line = "";                                                                                       // ./target/classes/data/student.csv
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/student.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                students.put(Integer.parseInt(lineArr[0]), new Student(Integer.parseInt(lineArr[0]), lineArr[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(students.size()).isEqualTo(4);
    }

    @Test
    void findAll() {
        final Map<Integer,Student> students = new HashMap<>();
        String line = "";                                                                                       // ./target/classes/data/student.csv
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/student.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                students.put(Integer.parseInt(lineArr[0]), new Student(Integer.parseInt(lineArr[0]), lineArr[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(students.values().containsAll(students2.findAll())).isTrue();
    }

    @Test
    void merge() {
        final List<Score> scores = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("./data/score.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.;
                scores.add(new Score(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Map<Integer,Student> students = new HashMap<>();
        line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/student.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                students.put(Integer.parseInt(lineArr[0]), new Student(Integer.parseInt(lineArr[0]), lineArr[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        scores.stream().forEach(score-> students.get(score.getStudentSeq()).setScore(score));


        assertThat(students.get(1).getScore().getScore()).isEqualTo(scores.get(0).getScore());
        assertThat(students.get(2).getScore().getScore()).isEqualTo(scores.get(1).getScore());
        assertThat(students.get(3).getScore().getScore()).isEqualTo(scores.get(2).getScore());
    }
}

