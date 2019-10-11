import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearching {
	public static Board searchBreathFirstTree(Queue<Board> boardQueue, Board goalStateBoard, boolean allowRepeats,boolean verbose) {
		ArrayList<Board> createdBoards = new ArrayList<>();
		createdBoards.add(boardQueue.peek());
		while (!boardQueue.isEmpty()) {
			Board tempBoard = boardQueue.remove();
			if(verbose) {
				System.out.println(tempBoard.toString());
			}
			if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
				return tempBoard;
			}
			if (tempBoard.getDepth() < 10) {
				addKids(createdBoards, boardQueue, tempBoard, 'L', allowRepeats);
				addKids(createdBoards, boardQueue, tempBoard, 'D', allowRepeats);
				addKids(createdBoards, boardQueue, tempBoard, 'R', allowRepeats);
				addKids(createdBoards, boardQueue, tempBoard, 'U', allowRepeats);
			}
		}
		System.out.println("No Solution Found");
		return null;
	}

	private static void addKids(ArrayList<Board> createdBoards, Queue<Board> boardQueue, Board parent, char move, boolean allowRepeats) {
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

	static void breadthFirst(Board startBoard, Board goalState, boolean allowRepeats,boolean verbose) {
		System.out.println("BFS " + (allowRepeats ? "repeats: " : "no repeats: "));
		Queue<Board> boardQueue = new LinkedList<>();
		boardQueue.add(startBoard);
		Board sol = searchBreathFirstTree(boardQueue, goalState, allowRepeats,verbose);
		if (sol != null) {
			Stack<Character> moves = new Stack<>();
			BoardUtils.boardPrintToRoot(sol, moves);
		}
	}
}
