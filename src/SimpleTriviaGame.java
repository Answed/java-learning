import java.util.Scanner;
import java.util.Random;
public class SimpleTriviaGame {

    public void StartGame(){
        byte score = 0;
        String answer;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("You will get 3 Questions. You have to Type the answer in the console\n For each right answer u get one point");
        for (int i = 1; i <= 3; i++){
            System.out.printf("Question Number %s: Yes or No ?", i);
            answer = input.nextLine();
            score += Question(random.nextInt(2), answer);
        }
        System.out.println("Your Score is " + score);

    }

    private byte Question(int answer_index, String answer){
        String[] answers = {"Yes", "No"};
        if (answer.equals(answers[answer_index])) {
            System.out.println("That is correct");
            return 1;
        }
        else{
            System.out.printf("That is wrong the right answer is %s %n", answers[answer_index]);
            return 0;
        }
    }

}
