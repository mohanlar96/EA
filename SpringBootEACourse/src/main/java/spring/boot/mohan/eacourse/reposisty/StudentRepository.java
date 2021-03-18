/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.boot.mohan.eacourse.reposisty;

import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.mohan.eacourse.entities.Student;

/**
 *
 * @author Mohan
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    public List<Student> findByName(String name);    
    
}
