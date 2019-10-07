import java.util.Arrays;

public class Board {
    private int depth;
    private Board parent;
    private char lastMove;
    private Tile[] board;

    public Board(Tile[] board,Board parent, char lastMove){
        this.board = board;
        if(parent == null){
            depth = 0;
        }else{
            depth = parent.getDepth()+1;
        }
        this.parent = parent;
        this.lastMove = lastMove;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Board getParent() {
        return parent;
    }

    public void setParent(Board parent) {
        this.parent = parent;
    }

    public char getLastMove() {
        return lastMove;
    }

    public void setLastMove(char lastMove) {
        this.lastMove = lastMove;
    }

    public Tile[] getBoard() {
        return board;
    }

    public void setBoard(Tile[] board) {
        this.board = board;
    }

    public int getBlankIndex(){
        for(int i = 0; i < 9; i++){
            if(board[i].getTileNum() == 'b'){
             return i;
            }
        }
        return -1;
    }

    public String toString() {
        return board[0] + ", " + board[1] + ", " + board[2] + "\n" + board[3] + ", " + board[4] + ", " + board[5] + "\n"+ board[6] + ", " + board[7] + ", " + board[8];
    }
}
