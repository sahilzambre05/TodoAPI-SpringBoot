package com.example.TodoApiSpringApplication;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(com.example.TodoApiSpringApplication.TimeMonitor)")
    public Object logtime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logging time");

        return joinPoint.proceed(); // REQUIRED
    }
}
