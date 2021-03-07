/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment9_2.main;

import edu.miu.mohan.assignment9_2.configuration.AppConfig;
import edu.miu.mohan.assignment9_2.entities.Student;
import edu.miu.mohan.assignment9_2.services.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohan
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("1");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("2");
        StudentService service = context.getBean("studentService",StudentService.class);
        System.out.println("3");
        Student mohan =new Student();
        mohan.setFirstName("mohan");
        service.save(mohan);
        System.out.println("4");
        
    }
    
}
