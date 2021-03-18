/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.boot.mohan.eacourse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.mohan.eacourse.entities.Student;
import spring.boot.mohan.eacourse.service.StudentService;
/**
 *
 * @author Mohan
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private StudentService stdService;
    
    @GetMapping(path="test")
    public String home(){
        return "working as a home MOHAN ";
    }
    
    @GetMapping(path="/", produces="application/json")
    public List<Student> allStudent(){        
        return  stdService.findAll();
    }
    
    @PostMapping(path="/", consumes="application/json", produces="application/json")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        System.out.println("POST METHOD TRIGGER");
       stdService.addStudent(student);
       jmsTemplate.convertAndSend("studentQueue",student.toString());
       return ResponseEntity.status(201).build();        
    }
    
    @PutMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Student> replaceStudent(@PathVariable Long id,@RequestBody Student student){ 
        System.out.println("Put trigger and id is "+id);
       Student updatedStudent=stdService.replaceStudent(student,id);
       return ResponseEntity.status(201).build();
    }
    
    @PatchMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Student> editStudent(@PathVariable Long id,@RequestBody Student student){
                System.out.println("Patch trigger and id is "+id);

       Student updatedStudent=stdService.editStudent(student,id);
       return ResponseEntity.status(201).build();    
    }
    
   @DeleteMapping(path="/{id}",  produces="application/json")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
       stdService.deleteStudent(id);
       return ResponseEntity.status(204).build();        
    }
    
    
    
    
    
}
