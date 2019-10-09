import java.util.Scanner;
import java.util.Stack;

public class BoardUtils {
    public static Board createBoard(String msg) {
        Tile[] board = new Tile[9];
        boolean correct = false;
        while (!correct) {
            System.out.println(msg);
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase().trim();

            if (inputValidator(userInput)) {
                for(int i = 0; i < 9; i++){
                    board[i] = new Tile(userInput.charAt(i));
                }
                correct = true;
            } else {
                System.out.println("Incorrect input");
            }
        }
        return new Board(board, null, 'n');
    }

    public static boolean inputValidator(String userInput){
        if(userInput.length() != 9){
            return false;
        }else if(!userInput.contains("b")){
            return false;
        }
        for(int i = 1; i < 9; i++){
            if(!userInput.contains(""+i)){
                return false;
            }
        }
        return true;
    }

    public static Board createChild(Board parent, char move){
        int blankIndex = parent.getBlankIndex();
        if(move == 'U'){
            blankIndex -= 3;
        }else if(move == 'R'){
            if(blankIndex != 2 && blankIndex != 5) {
                blankIndex++;
            } else {
                blankIndex = -1;
            }
        }  else if(move == 'D') {
            blankIndex += 3;
        } else {//move == 'L'
            if(blankIndex != 3 && blankIndex != 6) {
                blankIndex--;
            } else {
                blankIndex = -1;
            }
        }
        if(blankIndex < 0 || blankIndex > 8) {
            return null;
        }
        return swap(parent, move, blankIndex, parent.getBlankIndex());
    }

    public static Board swap(Board parent, char move, int newBlank, int oldBlank) {
        Tile[] newBoard = parent.getBoard().clone();
        Tile temp = newBoard[oldBlank];
        newBoard[oldBlank] = newBoard[newBlank];
        newBoard[newBlank] = temp;
        return new Board(newBoard, parent, move);
    }

    public static boolean boardEquals(Board board1, Board goalBoard){
        if(board1 != null){
            return board1.toString().equals(goalBoard.toString());
        }
        return false;
    }

    public static void boardPrintToRoot(Board board, Stack<Character> moves){
        if(board.getLastMove() != 'n') {
            moves.push(board.getLastMove());
            boardPrintToRoot(board.getParent(), moves);
        }else{
            while(!moves.empty()){
                System.out.print(moves.pop());
            }
        }
    }
}
