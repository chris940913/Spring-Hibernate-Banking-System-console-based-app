/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.services;

import bankconsoleapp.models.Customer;
import bankconsoleapp.repositories.CustomerDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * /**
 *
 * @author chris940913
 */
@Service("CustomerService")
public class CustomerService {

    @Autowired
    private CustomerDao cD;

    public void createCustomer(Customer c) {
        cD.createCustomer(c);
    }

    public List<Customer> getAllCust() {
        return cD.getAllCust();
    }

}
