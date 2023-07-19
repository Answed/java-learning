import BankClasses.Bank;

import java.util.*;

public class BankSystem {

    Map<String, Bank> saved_banks = new HashMap<>();
    private final Scanner input = new Scanner(System.in);

    public void OpenBankSystem(){
        boolean system_open = true;
        while (system_open){
            System.out.println("Bitte geben Sie den Namen Ihrer Bank ein.\nMit Exit können Sie das Fenster wieder schließen");
            String operator = input.nextLine();
            System.out.println(operator);
            if(operator.equals("Exit")) {system_open = false;}
            else {OpenBank(operator);}
        }
    }

    private void CreateBank(String bankName){
        System.out.println("Bitte geben Sie an vieviel maximal überzogen werden darf.");
        int max_overdraw = input.nextInt();
        input.nextLine();
        saved_banks.put(bankName, new Bank(max_overdraw));
        saved_banks.get(bankName).LogIn();
    }

    private void OpenBank(String name_of_bank){
        if(saved_banks.containsKey(name_of_bank)) {saved_banks.get(name_of_bank).LogIn();}
        else {
            System.out.println("Diese Bank gibt es nicht es nicht, möchten Sie sie zu dem System hinzufügen ?\n[Y]es/[N]o");
            String createNewBank = input.nextLine();
            if(createNewBank.equals("Y")){CreateBank(name_of_bank);}
        }
    }

}
