package BankClasses;

import java.util.*;

public class Bank {
       private List<Account> customers = new ArrayList<Account>();
       private final Scanner input = new Scanner(System.in);
       int max_overdraw_amount = 5000;
       private Account tempUser;


       public void LogIn(){
              System.out.println("Bitte geben Sie Ihre AccountID an\n");
              String accountID = input.nextLine();
              if(customers.contains(accountID)) {
                     tempUser = customers.get(customers.indexOf(customers.contains(accountID)));
              }
              else{
                     System.out.println("Es gibt leider kein Account mit dieser ID.\nWollen Sie einen neuen Account erstellen ?\n [Y]es/[N]o");
                     if(input.nextLine().equals("Y")){CreateAccount();}
                     else {System.out.println("Ich wünsche Ihnen einen schönen Tag");}
              }

       }

       private void CreateAccount(){
              Person newUser;
              String[] all_names = CreateListOfNames();
              int age = GetAge();
              String ssn = GetSSN();
              if(age >= 18){
                     if(all_names.length == 3) { newUser = new Person(all_names[0],all_names [1], all_names[2], age,ssn); }
                     else if (all_names.length == 2) {newUser = new Person(all_names[0],all_names [1], age,ssn);}
                     else {
                            System.out.println("Ihr Name ist zu lang/kurz");
                            return;
                     }
                     String password = GetPassword();
                     int balance = GetDeposit();
                     customers.add(new Account(newUser, password, balance));
                     System.out.println("Ihre Account ID ist Ihr Vorname und Nachname klein und zusammengeschrieben.\n" +
                             "Diese wird benötigt um sich im Account wieder anzumelden");
              }
       }

       private boolean CheckPassoword(){
              System.out.printf("Guten Tag %s %s bitte geben Sie Ihr passwort ein", tempUser.accountHolder.first_name, tempUser.accountHolder.last_name);
              
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

       private int GetDeposit(){
              System.out.println("Bitte geben Sie an wieviel Geld Sie einzahlen wollen\n");
              return input.nextInt();
       }
       private String GetPassword(){
              System.out.println("Bitte geben Sie Ihr Passwort ein");
              return input.nextLine();
       }
}
