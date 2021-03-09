package miu.mohan.exam2.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;



@Aspect
public class TraceAdvice {
  @After("execution(* miu.mohan.exam2.service.*.*(..))")  
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
