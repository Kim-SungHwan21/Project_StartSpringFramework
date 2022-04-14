package com.nhnacademy.edu.springframework.project.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/** TODO 2 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
@Component
@Repository
public class CsvScores implements Scores {

//    private static final Scores INSTANCE = new CsvScores();

    private final List<Score> scores = new ArrayList<>();

//    private CsvScores(){
//
//    }

    private static boolean isLoading;

    public static boolean getIsLoading() {
        return isLoading;
    }

    //    public static Scores getInstance() {
//        return INSTANCE;
//    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        isLoading = true;
        String line = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/score.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.;
                scores.add(new Score(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        isLoading = false;
    }

    @Override
    public List<Score> findAll() {
        if(isLoading) {
            throw new IllegalStateException();
        }
        return this.scores;
    }
}
