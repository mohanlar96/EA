/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.mohan.exam2;

import miu.mohan.exam2.entities.*;
import miu.mohan.exam2.service.CourseService;
import miu.mohan.exam2.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 611517
 */
public class Main {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        
        
        StudentService stdService = context.getBean("studentService",StudentService.class);
        Student Mohan =new Student();
        Mohan.setName("Mohan");
        Mohan.setGpa(3.0f);
        stdService.create(Mohan);// Create 
        Mohan.setName("MOHAsN LAR");   
        stdService.update(Mohan); // update
        System.out.println(stdService.readAll()); //readall
        stdService.delete(Mohan); //delete 
        
        
        CourseService courseService = context.getBean("courseService",CourseService.class);
        Course EA =new Course();
        EA.setTitle("Enterprese Architecture");
        EA.setCapacity(25);
        courseService.create(EA);// Create 
        EA.setTitle("Enterprise Application Architecture");
        courseService.update(EA); // update
        System.out.println(courseService.readAll()); //readall
        courseService.delete(EA); //delete   
        
        
        
        
    }
    
     
    
}
