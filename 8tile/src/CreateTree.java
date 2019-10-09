import java.util.Stack;

public class CreateTree {
    /**
     * This is the depth first tree search that contains repeats and sends back the final board
     * @param boardStack This takes in the stack containing the board solutions
     * @param goalStateBoard This is the goal board for the initial board to end up at
     * @return This returns either the board state if the solution is found or null if it is not
     */
    public static Board createDepthFirstTreeRepeat(Stack<Board> boardStack, Board goalStateBoard) {
        while (!boardStack.empty()) {
            Board tempBoard = boardStack.pop();
            if (BoardUtils.boardEquals(tempBoard, goalStateBoard)) {
                return tempBoard;
            }
            if (tempBoard.getDepth() < 10) {
                pushKids(boardStack, tempBoard, 'L');
                pushKids(boardStack, tempBoard, 'D');
                pushKids(boardStack, tempBoard, 'R');
                pushKids(boardStack, tempBoard, 'U');
            }
        }
        System.out.println("No Solution Found");
        return null;
    }

    public static void createDepthFirstTreeNoRepeat() {
    }

    /**
     *
     * @param boardStack
     * @param parent
     * @param move
     */
    public static void pushKids(Stack<Board> boardStack, Board parent, char move) {
        Board newBoard = BoardUtils.createChild(parent, move);
        if (newBoard != null) {
            boardStack.push(newBoard);
        }
    }


    public static void createBreadthFirstTreeRepeat() {

    }

    public static void createBreadthFirstTreeNoRepeat() {

    }

    public static void createAStarTree() {

    }

}
