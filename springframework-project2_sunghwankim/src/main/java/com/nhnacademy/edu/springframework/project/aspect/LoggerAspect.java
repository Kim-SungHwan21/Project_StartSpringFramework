package com.nhnacademy.edu.springframework.project.aspect;

import com.nhnacademy.edu.springframework.project.Main;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {

    private static final Log log = LogFactory.getLog(Main.class);

//    @Around("execution(* com.nhnacademy.edu.springframework.project.service..*.*(..))")
    @Around("execution(public * loadAndMerge(..))")
    public Object loadAndMergeLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: loadAndMerge");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * getScoreByStudentName(..))")
    public Object getScoreByStudentNameLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: getScoreByStudentName");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * getScoreByStudentSeq(..))")
    public Object getScoreByStudentSeqLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: getScoreByStudentSeq");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * getPassedStudents(..))")
    public Object getPassedStudentsLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: getPassedStudents");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println("getPassedStudentsLogging");
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * getStudentsOrderByScore(..))")
    public Object getStudentsOrderByScoreLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: getStudentsOrderByScore");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }



}


