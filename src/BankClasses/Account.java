package BankClasses;

public class Account {

    private int balance;
    private final String accountID;
    private final Person accountHolder;
    private final String password;

    public Account(String ID, Person person,String password ,int balance){
        this.accountID = ID;
        this.accountHolder = person;
        this.balance = balance;
        this.password = password;
    }

    public void DepositMoney(int amount){
        balance += amount;
        GetBalance();
    }

    public  void  WithdrawMoney(int amount){
        balance -= amount;
        GetBalance();
    }

    public void GetBalance(){
        System.out.printf("Your current balance is %s", balance);
    }

    public boolean isAccountHolder(Person person) {return accountHolder.equals(person);}

    public boolean isPasswordCorrect(String input_password) {return password.equals(input_password);}
}
