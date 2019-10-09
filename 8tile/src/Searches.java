import java.util.Stack;

public class Searches {
    public static void depthFirstRepeats(Board startBoard, Board goalState) {
        Stack<Board> boardStack = new Stack<>();
        boardStack.push(startBoard);

        Board sol = CreateTree.createDepthFirstTreeRepeat(boardStack, goalState);
        if (sol != null) {
            Stack<Character> moves = new Stack<>();
            BoardUtils.boardPrintToRoot(sol, moves);
        }
    }
}
