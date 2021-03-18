/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.boot.mohan.eacourse.service;

import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.mohan.eacourse.entities.Student;
import spring.boot.mohan.eacourse.reposisty.StudentRepository;

/**
 *
 * @author Mohan
 */
@Service
public class StudentService {
    
    @Autowired
    private StudentRepository stdRepo;

    public List<Student> findAll() {
        
        return stdRepo.findByName("chandrama Panday Wagle");
        
    }

    public void addStudent(Student student) {
        
        stdRepo.save(student);
    }    
    public Student replaceStudent(Student student, Long id) {
        return stdRepo.findById(id)
            .map(std -> {
              std.setName(student.getName());
              std.setGpa(student.getGpa());
              std.setAge(student.getAge());
              return stdRepo.save(std);
            }).get();
    }

    public Student editStudent(Student student, Long id) {
        return stdRepo.findById(id)
            .map(std -> {
                if(student.getName()!= null)
                    std.setName(student.getName());
                if(student.getGpa()!=null)                   
                    std.setGpa(student.getGpa());
                if(student.getAge()!=null)
                    std.setAge(student.getAge());
              return stdRepo.save(std);
            }).get();         
    }
    public void deleteStudent(Long id) {
        stdRepo.deleteById(id);
        
    }    
}
