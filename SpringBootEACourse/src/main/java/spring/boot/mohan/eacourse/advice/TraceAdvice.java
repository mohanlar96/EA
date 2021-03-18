package spring.boot.mohan.eacourse.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TraceAdvice {
  @After("execution(* spring.boot.mohan.eacourse.controller.*.*(..))")  
   public void tracebeforemethod(JoinPoint joinpoint){
       
        System.out.println("LOG FROM ASPECCT STARTED ****************** ");
        Object[] args = joinpoint.getArgs();
        
        
        System.out.println("method ="+joinpoint.getSignature().getName()+" is called ");

        for(Object o : args){
            System.out.println("Method Parameters are "+o);   
            
        }
        System.out.println("LOG FROM ASPECCT ENDED ****************** ");    
        
  }  
}
