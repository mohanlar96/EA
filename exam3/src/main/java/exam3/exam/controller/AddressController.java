/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.controller;

import exam3.exam.entities.Address;
import exam3.exam.service.AddressService;

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
@RequestMapping("/api/addresses/")
public class AddressController {
    
   
    @Autowired
    private AddressService addService;
    
    @GetMapping(path="test")
    public String home(){
        return "working as testing address controller ";
    }
    
    @GetMapping(path="/", produces="application/json")
    public List<Address> allAddress(){        
        return  addService.findAll();
    }
    @GetMapping(path="/{id}", produces="application/json")
    public Address allAddress(@PathVariable Long id){        
        return  addService.getAnAddress(id);
    }
    
    @PostMapping(path="/", consumes="application/json", produces="application/json")
    public ResponseEntity<Address> addAddress(@RequestBody Address student){
        System.out.println("POST METHOD TRIGGER");
       addService.addAddress(student);
       return ResponseEntity.status(201).build();        
    }
    
    @PutMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Address> replaceAddress(@PathVariable Long id,@RequestBody Address student){ 
        System.out.println("Put trigger and id is "+id);
       Address updatedAddress=addService.replaceAddress(student,id);
       return ResponseEntity.status(204).build();
    }
    
    @PatchMapping(path="/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<Address> editAddress(@PathVariable Long id,@RequestBody Address student){
                System.out.println("Patch trigger and id is "+id);

       Address updatedAddress=addService.editAddress(student,id);
       return ResponseEntity.status(204).build();    
    }
    
   @DeleteMapping(path="/{id}",  produces="application/json")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id){
       addService.deleteAddress(id);
       return ResponseEntity.status(204).build();        
    }
    
    
    
    
    
}
