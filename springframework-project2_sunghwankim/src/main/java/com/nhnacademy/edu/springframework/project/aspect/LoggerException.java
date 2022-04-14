package com.nhnacademy.edu.springframework.project.aspect;


import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerException {

    @Around("execution(public * findAll(..))")
    public Object findAllLogging(ProceedingJoinPoint pjp) throws Throwable {

        if (CsvScores.getIsLoading() == true) {
            throw new IllegalStateException("findAll에러");
        }
        return pjp.proceed();
    }

    @Around("execution(public * findAll(..))")
    public Object findAll2Logging(ProceedingJoinPoint pjp) throws Throwable {

        if (CsvStudents.getIsLoading2() == true) {
            throw new IllegalStateException("findAll2에러");
        }
        return pjp.proceed();
    }
    @Around("execution(public * merge(..))")
    public Object mergeLogging(ProceedingJoinPoint pjp) throws Throwable {

        if (CsvStudents.getIsLoading2() == true) {
            throw new IllegalStateException("merge에러");
        }
        return pjp.proceed();
    }




}
