public class Main {
	public static void main(String[] args) {
		Board rootBoard = BoardUtils.createBoard("Please enter the STARTING board, Enter \'b\' for a blank space ex. \"b12345678\"");
		Board goalStateBoard = BoardUtils.createBoard("Please enter the GOAL board, Enter \'b\' for a blank space ex. \"b12345678\"");
        Searches.depthFirstRepeats(rootBoard,goalStateBoard);
	}
}
