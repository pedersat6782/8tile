import java.util.ArrayList;
import java.util.Stack;

 class DepthFirstSearchingNoRepeat {
	/**
	 * This is the depth first tree search that does not contain repeats and if it can
	 * be solved in 10 moves or less sends back the solved board
	 *
	 * @param boardStack     this take sin the stack containing all currently created children
	 * @param goalStateBoard this is the board that we want to solve to
	 * @param createdBoards  this is an array list of all the board that have been created
	 * @return this returns a null board if no solution or the solved board
	 */
	private static Board searchDepthFirstTreeNoRepeat(Stack<Board> boardStack, Board goalStateBoard, ArrayList<Board> createdBoards) {
		while (!boardStack.empty()) {
			Board tempBoard = boardStack.pop();
			if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
				return tempBoard;
			}
			if (tempBoard.getDepth() < 10) {
				// CREATE ALGORITHM FOR CREATING NON REPEATED CHILDREN AND

			}

		}
		System.out.println("No Solution Found");
		return null;
	}

	 /**
	  * depthFirstNoRepeats takes in a start board and an end board prints out the steps to get to the end board
	  * @param startBoard the board you want solved
	  * @param goalState what the solved state of the board looks like
	  */
	static void depthFirstNoRepeats(Board startBoard, Board goalState) {
		Stack<Board> boardStack = new Stack<>();
		ArrayList<Board> createdBoards = new ArrayList<>();
		createdBoards.add(startBoard);
		boardStack.push(startBoard);
		Board sol = searchDepthFirstTreeNoRepeat(boardStack, goalState, createdBoards);
		if (sol != null) {
			Stack<Character> moves = new Stack<>();
			BoardUtils.boardPrintToRoot(sol, moves);
		}
	}
}
