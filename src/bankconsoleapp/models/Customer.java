/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author chris940913
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID")
    private int C_ID;

    @Column(name = "FIRST_NAME")
    private String FIRST_NAME;
    @Column(name = "LAST_NAME")
    private String LAST_NAME;
    @Column(name = "DOB")
    private String DoB;

    @Transient
    private String savingAccount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SavingAccount> savingAccounts = new ArrayList<SavingAccount>();

    public int getcID() {
        return C_ID;
    }

    public void setcID(int cID) {
        this.C_ID = cID;
    }

    public String getFname() {
        return FIRST_NAME;
    }

    public void setFname(String Fname) {
        this.FIRST_NAME = Fname;
    }

    public String getLname() {
        return LAST_NAME;
    }

    public void setLname(String Lname) {
        this.LAST_NAME = Lname;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public List<SavingAccount> getSavingAccounts() {
        return savingAccounts;
    }

    public void setSavingAccounts(String SA) {
        SavingAccount tempSA = new SavingAccount(SA);
        tempSA.setCustomer(this);
        savingAccounts.add(tempSA);
        this.savingAccount = SA;
    }

    public String getSA() {
        return savingAccount;
    }

    public void setSA(String SA) {
        this.savingAccount = SA;
    }

}
