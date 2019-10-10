import java.util.ArrayList;
import java.util.Stack;

class DepthFirstSearching {

    /**
     * This is the depth first tree search that contains repeats and sends back the final board
     *
     * @param boardStack     This takes in the stack containing the board solutions
     * @param goalStateBoard This is the goal board for the initial board to end up at
     * @return This returns either the board state if the solution is found or null if it is not
     */
    private static Board searchDepthFirstTree(Stack<Board> boardStack, Board goalStateBoard, boolean allowRepeats) {
        ArrayList<Board> createdBoards = new ArrayList<>();
        createdBoards.add(boardStack.peek());
        while (!boardStack.empty()) {
            Board tempBoard = boardStack.pop();
            if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
                return tempBoard;
            }
            if (tempBoard.getDepth() < 10) {
                pushKids(createdBoards, boardStack, tempBoard, 'L', allowRepeats);
                pushKids(createdBoards, boardStack, tempBoard, 'D', allowRepeats);
                pushKids(createdBoards, boardStack, tempBoard, 'R', allowRepeats);
                pushKids(createdBoards, boardStack, tempBoard, 'U', allowRepeats);
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
    private static void pushKids(ArrayList<Board> createdBoards, Stack<Board> boardStack, Board parent, char move, boolean allowRepeats) {
        Board newBoard = BoardUtils.createChild(parent, move);
        if (newBoard != null) {
            int i = 0;
            while (i < createdBoards.size() && !allowRepeats) {
                if (newBoard.boardEquals(createdBoards.get(i))) {
                    return;
                }
                i++;
            }
            boardStack.push(newBoard);
            if(!allowRepeats) {
                createdBoards.add(newBoard);
            }
        }
    }

    /**
     * DepthFirstRepeats calls the sort method and then prints the moves it did to get to the solution
     *
     * @param startBoard takes in the board you want sorted
     * @param goalState  takes in the board you want to sort to
     */
    static void depthFirst(Board startBoard, Board goalState,boolean allowRepeats) {
        Stack<Board> boardStack = new Stack<>();
        boardStack.push(startBoard);
        Board sol = searchDepthFirstTree(boardStack, goalState,allowRepeats);
        if (sol != null) {
            Stack<Character> moves = new Stack<>();
            System.out.println(sol.toString());
            BoardUtils.boardPrintToRoot(sol, moves);
        }
    }
}
