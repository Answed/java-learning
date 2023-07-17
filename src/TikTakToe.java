import java.util.Scanner;
public class TikTakToe {
    private String board ="012345678";
    boolean gameIsRunning = true;
    Scanner input = new Scanner(System.in);
    public void StartGame(){
        GenerateBoard();
        for (int i = 0; i < 9; i++){
            int nextPlayer = (i % 2 == 0) ? 0: 1;
            Turn(nextPlayer);
            GenerateBoard();
            CheckBoard(nextPlayer);
            if(!gameIsRunning){
                break;
            }
        }
    }

    private void Turn(int player){
        if(player == 0){
            System.out.println("Player 1 please select ur field");
            PlaceSymbol(0, input.nextInt());
        }
        else {
            System.out.println("Player 2 please select ur field");
            PlaceSymbol(1, input.nextInt());
        }
    }

    private void GenerateBoard(){
        int boardIndex = 0;
        for(int i = 0; i < 3; i++){
            System.out.printf("| %s | %s | %s |\n", board.charAt(boardIndex), board.charAt(boardIndex+1),board.charAt(boardIndex+2));
            boardIndex += 3;
        }
    }

    private void PlaceSymbol(int symbol_to_place,int position){
        Character[] symbols = {'O', 'X'};
        if(board.charAt(position) != 'O' && board.charAt(position) != 'X') {
            board = board.replace(board.charAt(position), symbols[symbol_to_place]);
        }
        else {
            System.out.println("This place is already taken");
            Turn(symbol_to_place);
        }
    }

    private void CheckBoard(int player){
        for (int i = 0; i < 9; i += 3){
            if(i < 3 && CheckIfTheSame(i, 3)){
                System.out.printf("Game Over. Player %s has won", player + 1);
                gameIsRunning = false;
                break;
            }
            else if(i % 3 == 0 && CheckIfTheSame(i, 1)) {
                System.out.printf("Game Over. Player %s has won", player + 1);
                gameIsRunning = false;
                break;
            }
            else if(i == 0 && CheckIfTheSame(i, 4)){
                System.out.printf("Game Over. Player %s has won", player + 1);
                gameIsRunning = false;
                break;
            }
            else if(i == 2 && CheckIfTheSame(i, 2)){
                System.out.printf("Game Over. Player %s has won", player + 1);
                gameIsRunning = false;
                break;
            }
        }
    }
    private boolean CheckIfTheSame(int start_point,int distance){
        int temp_position = start_point;
        boolean result = false;
        for (int i = 0; i < 2; i++) {
            result = board.charAt(temp_position) == board.charAt(temp_position + distance);
            temp_position += distance;
        }
        return result;
    }
}
