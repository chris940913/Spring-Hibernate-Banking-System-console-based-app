/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.repositories;

import bankconsoleapp.models.SavingAccount;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chris940913
 */
@Repository
public class SavingDao {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void deposit(String acnum, int amount) {

        int newBalance = 0;

        Query q1 = em.createQuery("From SavingAccount SA WHERE SA.accNum='" + acnum + "'");
        List<SavingAccount> SA = q1.getResultList();
        for (SavingAccount sav : SA) {
            newBalance = sav.getBalance() + amount;
        }

        Query q = em.createQuery("update SavingAccount set balance=:bal where accNum=:an");
        q.setParameter("an", acnum);
        q.setParameter("bal", newBalance);
        q.executeUpdate();

        em.flush();

    }

    @Transactional
    public void withdraw(String acnum, int amount) {

        int newBalance = 0;

        Query q1 = em.createQuery("From SavingAccount SA WHERE SA.accNum='" + acnum + "'");
        List<SavingAccount> SA = q1.getResultList();
        for (SavingAccount sav : SA) {
            newBalance = sav.getBalance() - amount;
        }

        Query q = em.createQuery("update SavingAccount set balance=:bal where accNum=:an");
        q.setParameter("an", acnum);
        q.setParameter("bal", newBalance);
        q.executeUpdate();

        em.flush();

    }

    public List<SavingAccount> getAllSA() {

        Query q = em.createQuery("FROM SavingAccount");
        List<SavingAccount> sa = q.getResultList();

        for (SavingAccount sav : sa) {

            System.out.println("Account Number: " + sav.getAccNum() + " Balance :" + sav.getBalance());
        }

        return sa;

    }

}
