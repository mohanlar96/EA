/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.controller;

import exam3.exam.entities.Author;
import exam3.exam.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohan
 */
@RestController
@RequestMapping("/api/authors/")
public class AuthorController {
     
    
    @Autowired
    private AuthorService authService;
    
    @GetMapping(path="test")
    public String home(){
        return "working as testing author controller ";
    }
    
    @GetMapping(path="/", produces="application/json")
    public List<Author> allAuthor(){        
        return  authService.findAll();
    }
    
    @PostMapping(path="/", consumes="application/json", produces="application/json")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        System.out.println("POST METHOD TRIGGER");
       authService.addAuthor(author);
       return ResponseEntity.status(201).build();        
    }
    
    @PutMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Author> replaceAuthor(@PathVariable Long id,@RequestBody Author author){ 
        System.out.println("Put trigger and id is "+id);
       Author updatedAuthor=authService.replaceAuthor(author,id);
       return ResponseEntity.status(201).build();
    }
    
    @PatchMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id,@RequestBody Author author){
                System.out.println("Patch trigger and id is "+id);

       Author updatedAuthor=authService.editAuthor(author,id);
       return ResponseEntity.status(201).build();    
    }
    
   @DeleteMapping(path="/{id}",  produces="application/json")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id){
       authService.deleteAuthor(id);
       return ResponseEntity.status(204).build();        
    }
    
    
    
    
    
}
