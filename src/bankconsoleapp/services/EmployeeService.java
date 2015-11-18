/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.services;

import bankconsoleapp.models.Employee;
import bankconsoleapp.repositories.EmployeeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris940913
 */

@Service("EmployeeService")
public class EmployeeService {
    
    @Autowired
    private EmployeeDao empDao;
    
    public List<Employee>getAllEmp()
    {
        return empDao.getAllEmp();
    }
    
}
