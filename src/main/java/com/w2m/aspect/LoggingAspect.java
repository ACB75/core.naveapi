package com.w2m.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* com.w2m.naves.service.NaveEspacialService.findById(..)) && args(id)")
    public void logBefore(JoinPoint joinPoint, Long id) {
        if (id < 0) {
            System.out.println("Attempted to fetch spaceship with negative id: " + id);
        }
    }
}