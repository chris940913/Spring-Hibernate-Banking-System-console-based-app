/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ECES Assignment 2 
 *
 * @author Chris Yap Fui Yang <s3466760@student.rmit.edu.au>
 * 
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name ="E_ID")
    private String eID;
    
    @Column(name="FIRST_NAME")
    private String FN;
    
    @Column(name="LAST_NAME")
    private String LN;
    
    @Column(name="PASSWORD")
    private String Password;

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public String getFN() {
        return FN;
    }

    public void setFN(String FN) {
        this.FN = FN;
    }

    public String getLN() {
        return LN;
    }

    public void setLN(String LN) {
        this.LN = LN;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
