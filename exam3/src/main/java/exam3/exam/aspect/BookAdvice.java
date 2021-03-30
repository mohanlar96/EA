package exam3.exam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class BookAdvice {
  @After("execution(* exam3.exam.controller.BookController.*(..))")  
  
  public void tracebeforemethod(JoinPoint joinpoint){
      
     Object[] args = joinpoint.getArgs();
       
        System.out.println("Book OPeration Perform with Method = "+joinpoint.getSignature().getName());
        
  }  
}
