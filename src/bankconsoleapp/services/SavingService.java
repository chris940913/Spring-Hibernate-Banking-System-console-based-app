/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.services;

import bankconsoleapp.models.SavingAccount;
import bankconsoleapp.repositories.SavingDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris940913
 */
@Service("SavingService")
public class SavingService {

    @Autowired
    private SavingDao sd;

    public void deposit(String acnum, int amount) {
        sd.deposit(acnum, amount);
    }

    public void withdraw(String acnum, int amount) {
        sd.withdraw(acnum, amount);
    }

    public List<SavingAccount> getAllSA() {
        return sd.getAllSA();
    }

}
