import java.util.*;

public class AStarSearching {
    static Board createAStarTree(PriorityQueue<Board> boardPQ, Board goalStateBoard,boolean verbose) {
        ArrayList<Board> visitedBoards = new ArrayList<>();
        visitedBoards.add(boardPQ.peek());


        while (!boardPQ.isEmpty()) {
            Board tempBoard = boardPQ.remove();
            if(verbose) {
                System.out.println(tempBoard.toString());
            }
            if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
                return tempBoard;
            }
                pushKids(visitedBoards, boardPQ, tempBoard, 'L', goalStateBoard);
                pushKids(visitedBoards, boardPQ, tempBoard, 'D', goalStateBoard);
                pushKids(visitedBoards, boardPQ, tempBoard, 'R', goalStateBoard);
                pushKids(visitedBoards, boardPQ, tempBoard, 'U', goalStateBoard);

        }
        System.out.println("No Solution Found");
        return null;
    }

    private static void pushKids(ArrayList<Board> visitedBoards, PriorityQueue<Board> boardPQ, Board parent, char move, Board goalStateBoard) {
        Board newBoard = BoardUtils.createChild(parent, move);
        if (newBoard != null) {
            int i = 0;
            while (i < visitedBoards.size()) {
                if (newBoard.boardEquals(visitedBoards.get(i))) {
                    return;
                }
                i++;
            }
            newBoard.setGoalBoard(goalStateBoard);
            boardPQ.add(newBoard);
            visitedBoards.add(newBoard);
//			System.out.print("\r"+visitedBoards.size());
        }
    }

    static void aStar(Board startBoard, Board goalState,boolean verbose) {
        System.out.println("A* :");
        PriorityQueue<Board> boardQueue = new PriorityQueue<>();
        boardQueue.add(startBoard);
        Board sol = createAStarTree(boardQueue, goalState,verbose);
        if (sol != null) {
            Stack<Character> moves = new Stack<>();
            BoardUtils.boardPrintToRoot(sol, moves);
        }
    }

}
