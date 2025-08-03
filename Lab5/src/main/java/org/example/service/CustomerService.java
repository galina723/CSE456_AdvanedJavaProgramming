package org.example.service;

import org.example.repository.CustomerRepo;
import org.example.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public void createCustomer(Customer cus) {
        CustomerRepo.addCustomer(cus);
    }
}
