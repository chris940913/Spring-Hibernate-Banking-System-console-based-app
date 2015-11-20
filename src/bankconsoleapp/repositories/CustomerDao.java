/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.repositories;

import bankconsoleapp.models.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chris940913
 */
@Repository
public class CustomerDao {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createCustomer(Customer c) {
        // Saves the data to the database
        em.persist(c);
        em.flush();
    }

    public List<Customer> getAllCust() {

        Query q = em.createQuery("FROM Customer as c LEFT JOIN FETCH c.savingAccounts");
        List<Customer> cust = q.getResultList();

        for (Customer c : cust) {
            if (c.getSavingAccounts().size() > 0) {
                c.setSA(c.getSavingAccounts().get(0).getAccNum());
            }
        }

        return cust;

    }

}
