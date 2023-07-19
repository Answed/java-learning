package BankClasses;
import java.util.*;

public class Bank {
       private Map<String ,Account> customers = new HashMap<>();
       private final Scanner input = new Scanner(System.in);
       int max_overdraw_amount = 5000;
       private Account tempUser;

       public Bank(int max_overdraw){
              this.max_overdraw_amount = max_overdraw;
       }

       public void LogIn(){
              System.out.println("Bitte geben Sie Ihre AccountID an");
              String accountID = input.nextLine();
              if(customers.containsKey(accountID)) {
                     tempUser = customers.get(accountID);
                     if(CheckPassword()){LoggedIn();}
              }
              else{
                     System.out.println("Es gibt leider kein Account mit dieser ID.\nWollen Sie einen neuen Account erstellen ?\n[Y]es/[N]o");
                     if(input.nextLine().equals("Y")){CreateAccount();}
                     else {System.out.println("Ich wünsche Ihnen einen schönen Tag");}
              }
       }

       private void LoggedIn(){
              boolean loggedin = true;
              while (loggedin){
                     System.out.println("""
                             Um Geld abzuheben geben Sie bitte Abheben ein.
                             Um Geld einzuzahlen geben Sie bitte Einzahlen ein
                             Um sich auszuloggen geben Sie bitte Exit ein.""");
                     String operator = input.nextLine();
                     switch (operator){
                            case "Abheben" -> {
                                   tempUser.WithdrawMoney(GetWithDraw());
                                   input.nextLine();
                            }
                            case "Einzahlen" -> {
                                   tempUser.DepositMoney(GetDeposit());
                                   input.nextLine();
                            }
                            case "Exit" -> {
                                   return;
                            }
                     }
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
                     input.nextLine();
                     tempUser = new Account(newUser, password, balance);
                     customers.put(tempUser.accountID, tempUser);
                     System.out.println("Ihre Account ID ist Ihr Vorname und Nachname klein und zusammengeschrieben.\n" +
                             "Diese wird benötigt um sich im Account wieder anzumelden");
                     LoggedIn();
              }
       }

       private boolean CheckPassword(){
              System.out.printf("Guten Tag %s %s bitte geben Sie Ihr passwort ein\n", tempUser.accountHolder.first_name, tempUser.accountHolder.last_name);
              String password = input.nextLine();
              if(tempUser.isPasswordCorrect(password)){return true;}
              else {System.out.println("Das Password ist incorrect."); return  false;}
       }

       private String[] CreateListOfNames(){
              System.out.println("Bitte geben Sie Ihren vollen Namen ein");
              String full_name = input.nextLine();
              return full_name.trim().split("\\s+");
       }
       private int GetAge(){
              System.out.println("Bitte geben Sie Ihr Alter an");
              int age = input.nextInt();
              input.nextLine();
              if(age < 18){
                     System.out.println("Sie sind zu jung");
                     return 0;
              }
              else {return age;}
       }

       private String GetSSN(){
              System.out.println("Bitte geben Sie Ihre Social Security Nummer ein");
              return input.nextLine();
       }

       private int GetDeposit(){
              System.out.println("Bitte geben Sie an wieviel Geld Sie einzahlen wollen");
              return input.nextInt();
       }

       private int GetWithDraw(){
              System.out.println("Bitte geben Sie an wie viel Geld Sie abheben wollen");

              return  input.nextInt();
       }

       private String GetPassword(){
              System.out.println("Bitte geben Sie Ihr Passwort ein");
              return input.nextLine();
       }
}
