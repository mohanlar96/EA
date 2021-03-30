/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.service;

import exam3.exam.entities.Author;
import exam3.exam.reposisty.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohan
 */
@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authRepo;
    
    public List<Author> findAll() {
        
        return authRepo.findAll();
        
    }

    public void addAuthor(Author author) {
        
        authRepo.save(author);
    }    
    public Author replaceAuthor(Author author, Long id) {
        return authRepo.findById(id)
            .map(auth -> {
              auth.setAddress(author.getAddress());
              auth.setBooks(author.getBooks());
              auth.setName(author.getName());
              auth.setExperience(author.getExperience());
              return authRepo.save(auth);
            }).get();
    }

    public Author editAuthor(Author author, Long id) {
        return authRepo.findById(id)
            .map(auth -> {
                if(author.getName()!= null)
                    auth.setName(author.getName());
                if(author.getExperience()!=null)                   
                    auth.setExperience(author.getExperience());
                 if(author.getAddress()!= null)
                    auth.setAddress(author.getAddress());
                if(author.getBooks()!=null)                   
                    auth.setBooks(author.getBooks());
               
              return authRepo.save(auth);
            }).get();         
    }
    public void deleteAuthor(Long id) {
        authRepo.deleteById(id);
        
    }    

    public Author getAnAuthor(Long id) {
        return authRepo.findById(id).get();
    }
}
