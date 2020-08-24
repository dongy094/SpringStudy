package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.service.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("start : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();
            long timeMs = end - start;
            System.out.println("end :"+joinPoint.toString()+" "+timeMs+"ms");
        }

    }
    
}
