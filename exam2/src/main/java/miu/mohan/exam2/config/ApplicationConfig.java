package miu.mohan.exam2.config;

import miu.mohan.exam2.advice.TraceAdvice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
//@Async
public class ApplicationConfig {
@Bean
  public TraceAdvice traceAdvice(){
  TraceAdvice traceAdvice = new TraceAdvice();
  return traceAdvice;
}

}
