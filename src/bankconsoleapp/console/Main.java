/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.console;

import bankconsoleapp.models.Employee;
import bankconsoleapp.services.EmployeeService;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chris940913
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Injecting applicationContext to main
        ApplicationContext context = new ClassPathXmlApplicationContext("bankconsoleapp/applicationContext.xml");
        
        EmployeeService eS= context.getBean("EmployeeService",EmployeeService.class);
        
        
         String userName,pass;
        Scanner in = new Scanner(System.in);
        boolean user = false;
        do {

            System.out.println("Enter Employee ID:");
            userName = in.nextLine();
            for (Employee emp : eS.getAllEmp()) {
                if (userName.equals(emp.geteID())) {
                    System.out.println("Password:");
                    pass = in.nextLine();
                    for (Employee em : eS.getAllEmp()) {
                        if (pass.equals(em.getPassword())) {
                            
                            user = true;
                        }
                    }
                }
            }

        } while (!user);

        long start = System.currentTimeMillis();
        long end = start + 60*1000; // 60 seconds * 1000 ms/sec
        int operation =0;
        int userChoice;
        
        
        boolean quit = false;
        do {
            System.out.println("ACME Bank Saving System:");
            System.out.println("------------------------");
            System.out.println("1. Create Customer & Saving Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Balance");
            System.out.println("5. Quit");
            System.out.print("Operation count: "+ operation+"(Shut down at 5)");
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:

                    break;
                case 2:
                    // deposit
                   
                   
                    
                    
                    break;
                case 3:
                    // withdraw
                  
                    break;
                case 4:
                    // view
                
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }
            System.out.println();
            if(operation==5)
            {
                System.out.println("5 operation reached, System shutdown.");
            }
            if(System.currentTimeMillis()> end)
            {
                System.out.println("Session Expired.");
            }
        } while (!quit && operation !=5 && System.currentTimeMillis() < end);
        System.out.println("Bye!");

    }

}

        
    

