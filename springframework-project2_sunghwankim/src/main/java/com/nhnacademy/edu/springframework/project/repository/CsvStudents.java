package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.*;
import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/** TODO 3 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/

/**
 * TODO 7 :
 * singleton 클래스를 만드세요.
 */
@Component
@Repository
public class CsvStudents implements Students {

    private final Map<Integer,Student> students = new HashMap<>();
//    private static final Students INSTANCE = new CsvStudents();
    private Student student;
    private int index;
    private static boolean isLoading2;

    public static boolean getIsLoading2() {
        return isLoading2;
    }

    //
//    private CsvStudents() {
//        if(isLoading) {
//            throw new IllegalStateException();
//        }
//    };
//
//    public static Students getInstance() {
//        return INSTANCE;
//    }

    // TODO 6 : student.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        isLoading2 = true;
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
        isLoading2 = false;
    }

    @Override
    public Collection<Student> findAll() {
        if(isLoading2) {
            throw new IllegalStateException();
        }
        return this.students.values();
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        if(isLoading2) {
            throw new IllegalStateException();
        }
        scores.stream().forEach(score-> students.get(score.getStudentSeq()).setScore(score));
    }
}
