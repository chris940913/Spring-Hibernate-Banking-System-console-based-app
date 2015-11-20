/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankconsoleapp.console;

import bankconsoleapp.models.Customer;
import bankconsoleapp.models.Employee;
import bankconsoleapp.services.CustomerService;
import bankconsoleapp.services.EmployeeService;
import bankconsoleapp.services.SavingService;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ECES Assignment 2
 *
 * @author Chris Yap Fui Yang <s3466760@student.rmit.edu.au>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Injecting applicationContext to main
        ApplicationContext context = new ClassPathXmlApplicationContext("bankconsoleapp/applicationContext.xml");

        
        EmployeeService eS = context.getBean("EmployeeService", EmployeeService.class);
        CustomerService cS = context.getBean("CustomerService", CustomerService.class);
        SavingService sS = context.getBean("SavingService", SavingService.class);

        String userName, pass;
        Scanner in = new Scanner(System.in);
        boolean user = false;
         boolean savingRedo = false;
         
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
        long end = start + 60 * 1000; // 60 seconds * 1000 ms/sec
        int operation = 0;
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
            System.out.print("Operation count: " + operation + "(Shut down at 5)");
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:

                   //create customer, then saving account regard to existing customer( maximum 2 SA per Customer)
                    System.out.println("Create Customer :");
                    String FirstN,
                     LastN,
                     DoB,
                     accNum,
                     answer;

                    Scanner sc = new Scanner(System.in);
                    Customer c = new Customer();
                    int saID = 0;

                    System.out.println("Enter First Name:");
                    FirstN = sc.nextLine();
                    c.setFname(FirstN);
                    System.out.println("Enter Last Name:");
                    LastN = sc.nextLine();
                    c.setLname(LastN);
                    System.out.println("Enter Date of Birth:");
                    DoB = sc.nextLine();
                    c.setDoB(DoB);

                    do {

                        System.out.println("Creating saving acount, Enter Account Number:");
                        accNum = sc.nextLine();
                        c.setSA(accNum);
                        c.setSavingAccounts(c.getSA());
                        saID++;
                        System.out.println("Create another SA? Y/N?");
                        answer = sc.nextLine();
                        if (answer.equals("n")) {
                            savingRedo = true;
                        }
                        if (saID == 2) {
                            System.out.println("Maximum Saving account reached!");
                        }
                    } while (!savingRedo && saID != 2);

                    cS.createCustomer(c);
                    operation++;

                    break;
                case 2:
                    // deposit

                     String acNum;
                    int amt;
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Enter Saving Account number u wish to do deposit.");
                    acNum= sc1.nextLine();
                    System.out.println("Enter amount :");
                    amt = sc1.nextInt();
                    
                    sS.deposit(acNum, amt);
                    operation++;
                    
                    
                    break;
                case 3:
                     String acNums;
                    int amts;
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Enter Saving Account number u wish to do withdraw.");
                    acNums= sc2.nextLine();
                    System.out.println("Enter amount :");
                    amts = sc2.nextInt();
                    
                    sS.withdraw(acNums, amts);
                    operation++;
                    break;

                    
                case 4:
                    // view
                     System.out.println("Saving Account Balance:");
                    System.out.println(sS.getAllSA());
                    operation++;
                    break;

                    
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }
            System.out.println();
            if (operation == 5) {
                System.out.println("5 operation reached, System shutdown.");
            }
            if (System.currentTimeMillis() > end) {
                System.out.println("Session Expired.");
            }
        } while (!quit && operation != 5 && System.currentTimeMillis() < end);
        System.out.println("Bye!");

    }

}
