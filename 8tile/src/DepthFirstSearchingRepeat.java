import java.util.Stack;

class DepthFirstSearchingRepeat {

	/**
	 * This is the depth first tree search that contains repeats and sends back the final board
	 *
	 * @param boardStack     This takes in the stack containing the board solutions
	 * @param goalStateBoard This is the goal board for the initial board to end up at
	 * @return This returns either the board state if the solution is found or null if it is not
	 */
	private static Board searchDepthFirstTreeRepeat(Stack<Board> boardStack, Board goalStateBoard) {
		while (!boardStack.empty()) {
			Board tempBoard = boardStack.pop();
			if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
				return tempBoard;
			}
			if (tempBoard.getDepth() < 10) {
				pushKidsWithRepeats(boardStack, tempBoard, 'L');
				pushKidsWithRepeats(boardStack, tempBoard, 'D');
				pushKidsWithRepeats(boardStack, tempBoard, 'R');
				pushKidsWithRepeats(boardStack, tempBoard, 'U');
			}
		}
		System.out.println("No Solution Found");
		return null;
	}

	/**
	 * Helper method that creates a child and if the child is valid adds it to the stack
	 *
	 * @param boardStack the stack to add the children to
	 * @param parent     used to know which the current board and how to create its children
	 * @param move       accepts the char 'U', 'D', 'L', 'R' for which child to create
	 */
	private static void pushKidsWithRepeats(Stack<Board> boardStack, Board parent, char move) {
		Board newBoard = BoardUtils.createChild(parent, move);
		if (newBoard != null) {
			boardStack.push(newBoard);
		}
	}

	/**
	 * DepthFirstRepeats calls the sort method and then prints the moves it did to get to the solution
	 *
	 * @param startBoard takes in the board you want sorted
	 * @param goalState  takes in the board you want to sort to
	 */
	static void depthFirstRepeats(Board startBoard, Board goalState) {
		Stack<Board> boardStack = new Stack<>();
		boardStack.push(startBoard);
		Board sol = searchDepthFirstTreeRepeat(boardStack, goalState);
		if (sol != null) {
			Stack<Character> moves = new Stack<>();
			BoardUtils.boardPrintToRoot(sol, moves);
		}
	}
}
