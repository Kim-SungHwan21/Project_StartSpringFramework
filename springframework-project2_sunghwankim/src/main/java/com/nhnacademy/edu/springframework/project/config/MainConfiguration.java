package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import com.nhnacademy.edu.springframework.project.service.GradeQueryService;
import com.nhnacademy.edu.springframework.project.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.project")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainConfiguration {

    @Bean
    public Scores scores() {
        return new CsvScores();
    }
    @Bean
    public Students students() {
        return new CsvStudents();
    }

    @Bean
    public DataLoadService DataLoadService(Scores scores, Students students) {
        return new CsvDataLoadService(scores, students);
    }

    @Bean
    public GradeQueryService gradeQueryService(Students students) {
        return new DefaultGradeQueryService(students);
    }

    @Bean
    public StudentService StudentService(Students students) {
        return new DefaultStudentService(students);
    }
}
