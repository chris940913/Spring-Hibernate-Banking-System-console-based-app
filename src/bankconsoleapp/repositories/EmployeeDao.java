/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.repositories;

import bankconsoleapp.models.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chris940913
 */
@Repository
public class EmployeeDao {
    
    @PersistenceContext
      EntityManager em;
    
    public List <Employee>getAllEmp(){
        
        Query q= em.createQuery("FROM Employee");
        List<Employee> emp = q.getResultList();
        return emp;
        
    }
}
