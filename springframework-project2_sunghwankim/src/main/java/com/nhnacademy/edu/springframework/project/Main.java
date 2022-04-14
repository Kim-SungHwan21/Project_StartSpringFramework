package com.nhnacademy.edu.springframework.project;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework")) {
            context.getBean("csvDataLoadService", CsvDataLoadService.class).loadAndMerge();
            context.getBean("defaultStudentService", DefaultStudentService.class).getPassedStudents();
            context.getBean("defaultStudentService", DefaultStudentService.class).getStudentsOrderByScore();
            context.getBean("defaultGradeQueryService", DefaultGradeQueryService.class).getScoreByStudentName("A");
            context.getBean("defaultGradeQueryService", DefaultGradeQueryService.class).getScoreByStudentSeq(10);

        }
    }
}
