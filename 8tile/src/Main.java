import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Tile[] board = new Tile[9];
		createBoard(board);
		System.out.println(Arrays.toString(board));

	}

	private static void createBoard(Tile[] board) {
		boolean correct = false;
		while (!correct) {
			System.out.println("Please enter the board, Enter \'b\' for a blank space ex. \"b12345678\"");
			Scanner scan = new Scanner(System.in);
			String userInput = scan.nextLine().toLowerCase().strip();

			if (inputValidator(userInput)) {
				for(int i = 0; i < 9; i++){
					board[i] = new Tile(i, userInput.charAt(i));
				}
				correct = true;
			} else {
				System.out.println("Incorrect input");
			}
		}
	}

	private static boolean inputValidator(String userInput){
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
}
