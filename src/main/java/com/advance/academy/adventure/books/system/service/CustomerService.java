package com.advance.academy.adventure.books.system.service;

import com.advance.academy.adventure.books.system.model.Customer;
import com.advance.academy.adventure.books.system.model.enums.UserType;
import com.advance.academy.adventure.books.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()){
            throw new RuntimeException("Customer not fount");
        }
        return  customer.get();
    }

    public void createOrUpdateCustomer(Customer customer) {
        if (null == customer.getId()) {
            //todo create
            createCustomer(customer);
            return;
        }
        //todo update
        updateCustomer(customer);
    }

    private void createCustomer(Customer customer){
       customerRepository.save(customer);
    }

    private void updateCustomer(Customer customer){
        customerRepository.save(customer);
        //customerRepository.getByUserType(UserType.ADMINISTRATOR);
    }

    //Validation method without spring
    /*
    private void valitateCustomer(Customer customer){


    }
    */

    public void deleteCustomer(Integer customerId){
        customerRepository.deactivateCustomer(customerId);

    }

}
