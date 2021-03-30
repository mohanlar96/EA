/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.controller;

import exam3.exam.entities.Address;
import exam3.exam.entities.Book;
import exam3.exam.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohan
 */
@RestController
@RequestMapping("/api/books/")
public class BookController {
    

    
    @Autowired
    private BookService bookService;
    
    @GetMapping(path="test")
    public String home(){
        return "working as testing address controller ";
    }
    
    @GetMapping(path="/", produces="application/json")
    public List<Book> allBook(){        
        return  bookService.findAll();
    }
    
    @GetMapping(path="/{id}", produces="application/json")
    public Book  allAddress(@PathVariable Long id){        
        return  bookService.getABook(id);
    }
    
    @PostMapping(path="/", consumes="application/json", produces="application/json")
    public ResponseEntity<Book> addBook(@RequestBody Book student){
        System.out.println("POST METHOD TRIGGER");
       bookService.addBook(student);
       return ResponseEntity.status(201).build();        
    }
    
    @PutMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Book> replaceBook(@PathVariable Long id,@RequestBody Book student){ 
        System.out.println("Put trigger and id is "+id);
       Book updatedBook=bookService.replaceBook(student,id);
       return ResponseEntity.status(204).build();
    }
    
    @PatchMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Book> editBook(@PathVariable Long id,@RequestBody Book student){
                System.out.println("Patch trigger and id is "+id);

       Book updatedBook=bookService.editBook(student,id);
       return ResponseEntity.status(204).build();    
    }
    
   @DeleteMapping(path="/{id}",  produces="application/json")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
       bookService.deleteBook(id);
       return ResponseEntity.status(204).build();        
    }
    
    
    
    
    
}
