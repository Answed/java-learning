package BankClasses;

public class Account {

    private int balance;
    private final String accountID;
    public final Person accountHolder;
    private final String password;

    public Account(Person person,String password ,int balance){
        this.accountID = (person.first_name + person.last_name).toLowerCase();
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

    public boolean isPasswordCorrect(String input_password) {return password.equals(input_password);}

    public boolean equals(String accountID){
        return this.accountID.equals(accountID);
    }
}
