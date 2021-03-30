/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.service;

import exam3.exam.entities.Address;
import exam3.exam.entities.Book;
import exam3.exam.reposisty.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @bk Mohan
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository boRepo;
    
    
    public List<Book> findAll() {
        
        return boRepo.findAll();
        
    }

    public void addBook(Book bk) {
        
        boRepo.save(bk);
    }    
    public Book replaceBook(Book bk, Long id) {
        return boRepo.findById(id)
            .map(b -> {
              b.setTitle(bk.getTitle());
              b.setNumberOfPages(bk.getNumberOfPages());
              return boRepo.save(b);
            }).get();
    }

    public Book editBook(Book bk, Long id) {
        return boRepo.findById(id)
            .map(b -> {
                if(bk.getTitle()!= null)
                    b.setTitle(bk.getTitle());
                if(bk.getNumberOfPages()!=0)                   
                    b.setNumberOfPages(bk.getNumberOfPages());
               
              return boRepo.save(b);
            }).get();         
    }
    public void deleteBook(Long id) {
        boRepo.deleteById(id);
        
    }    

    public Book getABook(Long id) {
        return boRepo.findById(id).get();
    }
}
