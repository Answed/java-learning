import BankClasses.Bank;

import java.util.*;

public class BankSystem {

    Map<String, Bank> saved_banks = new HashMap<>();
    private final Scanner input = new Scanner(System.in);

    public void OpenBankSystem(){

    }

    private void CreateBank(String bankName){
        System.out.println("Bitte geben Sie an vieviel maximal überzogen werden darf.");
        int max_overdraw = input.nextInt();
        saved_banks.put(bankName, new Bank(max_overdraw));
        saved_banks.get(bankName).LogIn();
    }

    private void OpenBank(){
        System.out.println("Bitte geben Sie den Namen Ihrer Bank an");
        String name_of_bank = input.nextLine();

        if(saved_banks.containsKey(name_of_bank)) {saved_banks.get(name_of_bank).LogIn();}
        else {
            System.out.println("Diese Bank gibt es nicht es nicht, möchten Sie sie zu dem System hinzufügen ?\n[Y]es/[N]o");
            String createNewBank = input.nextLine();
            if(createNewBank.equals("Y")){CreateBank(name_of_bank);}
        }
    }

}
