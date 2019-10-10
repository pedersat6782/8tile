import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSeatching {
	public static Board searchDepthFirstTree(Queue<Board> boardQueue, Board goalStateBoard, boolean allowRepeats) {
		ArrayList<Board> createdBoards = new ArrayList<>();
		createdBoards.add(boardQueue.peek());
		while (!boardQueue.isEmpty()) {
			Board tempBoard = boardQueue.remove();
			if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
				return tempBoard;
			}
			if (tempBoard.getDepth() < 10) {
				pushKids(createdBoards, boardQueue, tempBoard, 'L', allowRepeats);
				pushKids(createdBoards, boardQueue, tempBoard, 'D', allowRepeats);
				pushKids(createdBoards, boardQueue, tempBoard, 'R', allowRepeats);
				pushKids(createdBoards, boardQueue, tempBoard, 'U', allowRepeats);
			}
		}
		System.out.println("No Solution Found");
		return null;
	}

	private static void pushKids(ArrayList<Board> createdBoards, Queue<Board> boardQueue, Board parent, char move, boolean allowRepeats) {
		Board newBoard = BoardUtils.createChild(parent, move);
		if (newBoard != null) {
			int i = 0;
			while (i < createdBoards.size() && !allowRepeats) {
				if (newBoard.boardEquals(createdBoards.get(i))) {
					return;
				}
				i++;
			}
			boardQueue.add(newBoard);
			if(!allowRepeats) {
				createdBoards.add(newBoard);
			}
		}
	}

	static void breadthFirst(Board startBoard, Board goalState, boolean allowRepeats) {
		Queue<Board> boardQueue = new LinkedList<>();
		boardQueue.add(startBoard);
		Board sol = searchDepthFirstTree(boardQueue, goalState, allowRepeats);
		if (sol != null) {
			Stack<Character> moves = new Stack<>();
			System.out.println(sol.toString());
			BoardUtils.boardPrintToRoot(sol, moves);
		}
	}
}
