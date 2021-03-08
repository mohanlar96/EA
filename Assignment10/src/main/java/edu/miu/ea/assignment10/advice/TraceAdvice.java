package edu.miu.ea.assignment10.advice;

import edu.miu.ea.assignment10.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TraceAdvice {
  @Before("execution(* edu.miu.ea.assignment10.service.PersistenceService.*(..))&&args(student)")
      public void tracebeforemethod(JoinPoint joinPoint, Student student){
    if(student.getFirstName().equals("Nam")){
    System.out.println("***************************************************************************before execution of method "+
        joinPoint.getSignature().getName());
    System.out.println(student.toString());}
  }

  @After("execution(* edu.miu.ea.assignment10.service.PersistenceService.*(..))&&args(student)")
  public void traceaftermethod(JoinPoint joinPoint, Student student){
    System.out.println("***************************************************************************after execution of method "+
        joinPoint.getSignature().getName() + "arg" + joinPoint.getArgs().toString());
    System.out.println(student.toString());
  }
}
