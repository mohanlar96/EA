/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.service;

import exam3.exam.entities.Address;
import exam3.exam.reposisty.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @address Mohan
 */
@Service
public class AddressService {
    
    @Autowired
    private AddressRepository authRepo;
    
    
    public List<Address> findAll() {
        
        return authRepo.findAll();
        
    }

    public void addAddress(Address address) {
        
        authRepo.save(address);
    }    
    public Address replaceAddress(Address address, Long id) {
        return authRepo.findById(id)
            .map(add -> {
              add.setCity(address.getCity());
              add.setState(address.getState());
              return authRepo.save(add);
            }).get();
    }

    public Address editAddress(Address address, Long id) {
        return authRepo.findById(id)
            .map(add -> {
                if(address.getCity()!= null)
                    add.setCity(address.getCity());
                if(address.getState()!=null)                   
                    add.setState(address.getState());
               
              return authRepo.save(add);
            }).get();         
    }
    public void deleteAddress(Long id) {
        authRepo.deleteById(id);
        
    }    
}
