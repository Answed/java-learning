import java.util.Scanner;
public class Calculator {
    public static void StartCalculator(){
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning){
            System.out.println("Please select the operator: Addition, Subtraction, Multiplication, Division, Exit");
            String operator = scanner.nextLine();
            System.out.println("Please enter ur first input");
            int inp1 = Integer.parseInt(scanner.nextLine());
            System.out.println("Please enter ur second input");
            int inp2 = Integer.parseInt(scanner.nextLine());
            switch (operator) {
                case "Addition" -> System.out.println(inp1 + inp2);
                case "Subtraction" -> System.out.println(inp1 - inp2);
                case "Multiplication" -> System.out.println(inp1 * inp2);
                case "Division" -> System.out.println(inp1 / inp2);
                case "Exit" -> isRunning = false;
            }
        }
    }
}
