package com.advance.academy.adventure.books.system.service;

import com.advance.academy.adventure.books.system.model.Customer;
import com.advance.academy.adventure.books.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Integer customerId) {
        return null;
    }

    public void createOrUpdateCustomer(Customer customer) {
        if (null == customer.getId()) {
            //todo create
            valitateAndCreateCustomer(customer);
            return;
        }
        //todo update
        valitateAndUpdateCustomer(customer);
    }

    private void valitateAndCreateCustomer(Customer customer){
       valitateCustomer(customer);
       customerRepository.save(customer);
    }

    private void valitateAndUpdateCustomer(Customer customer){
        valitateCustomer(customer);
        customerRepository.save(customer);
    }

    private void valitateCustomer(Customer customer){

    }

    public void deleteCustomer(Integer customerId){

    }

}
