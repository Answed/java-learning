import java.util.Scanner;
public class TikTakToe {
    private String board ="012345678";
    Scanner input = new Scanner(System.in);
    public void StartGame(){
        GenerateBoard();
        for (int i = 0; i < 9; i++){
            int nextPlayer = (i % 2 == 0) ? 0: 1;
            System.out.println(nextPlayer);
            Turn(nextPlayer);
            GenerateBoard();
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
}
