package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {

    CsvScores scores;
    CsvStudents students;


    @BeforeEach
    void setUp() {
        scores = new CsvScores();
        students = new CsvStudents();
    }

    @Test
    void load() {
        final List<Score> scores2 = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("./data/score.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.;
                scores2.add(new Score(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(scores2.isEmpty()).isFalse();
    }

    @Test
    void findAll() {
        final List<Score> scores2 = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("./data/score.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.;
                scores2.add(new Score(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(scores2.containsAll(scores.findAll())).isTrue();
    }


}
