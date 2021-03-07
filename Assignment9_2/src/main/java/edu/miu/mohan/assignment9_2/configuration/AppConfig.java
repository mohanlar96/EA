/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment9_2.configuration;

import edu.miu.mohan.assignment9_2.persisters.StudentPersister;
import edu.miu.mohan.assignment9_2.persisters.StudentPersisterImpl;
import edu.miu.mohan.assignment9_2.services.StudentService;
import edu.miu.mohan.assignment9_2.services.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mohan
 */
@Configuration
public class AppConfig {
    
    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }
    @Bean
    public StudentPersister studentPersister(){
        return new StudentPersisterImpl();
    }
}
