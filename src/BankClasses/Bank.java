package BankClasses;

import java.util.*;

public class Bank {
       private List<Account> customers = new ArrayList<Account>();
       private final Scanner input = new Scanner(System.in);
       int max_overdraw_amount = 5000;

       public void CreateAccount(){
              Person newUser;
              String[] all_names = CreateListOfNames();
              int age = GetAge();
              String ssn = GetSSN();
              if(age >= 18){
                     if(all_names.length == 3) { newUser = new Person(all_names[0],all_names [1], all_names[2], age,ssn); }
                     else if (all_names.length == 2) {newUser = new Person(all_names[0],all_names [1], age,ssn);}
                     else {System.out.println("Ihr Name ist zu lang/kurz");}
              }

       }

       private String[] CreateListOfNames(){
              System.out.println("Bitte geben Sie Ihren vollen Namen ein\n");
              String full_name = input.nextLine();
              return full_name.trim().split("\\s+");
       }
       private int GetAge(){
              System.out.println("Bitte geben Sie Ihr Alter an\n");
              int age = input.nextInt();
              if(age < 18){
                     System.out.println("Sie sind zu jung");
                     return 0;
              }
              else {return age;}
       }

       private String GetSSN(){
              System.out.println("Bitte geben Sie Ihre Social Security Nummer ein\n");
              return input.nextLine();
       }
}
