public class Board {
    private int depth;
    private Board parent;
    private char lastMove;
    private Tile[] board;

    /**
     * constructor for the board object
     * @param board take in an array of 9 tiles that make up the board
     * @param parent reference to who created this child
     * @param lastMove a char of what move it took to get to this child from its parent ex 'U'
     */
    Board(Tile[] board,Board parent, char lastMove){
        this.board = board;
        if(parent == null){
            depth = 0;
        }else{
            depth = parent.getDepth()+1;
        }
        this.parent = parent;
        this.lastMove = lastMove;
    }

    /**
     * getter for the depth
     * @return returns the how many moves it took to get to it
     */
    int getDepth() {
        return depth;
    }

    /**
     * getter for parent board
     * @return returns this childs parents retuns null if its the start board
     */
    Board getParent() {
        return parent;
    }

    /**
     * getter for the previous move
     * @return returns the move that was taken from its parent to create this child
     */
    char getLastMove() {
        return lastMove;
    }

    /**
     * getter for array of tiles that make up this board
     * @return returns an array of 9 tiles that make up the board
     */
    Tile[] getBoard() {
        return board;
    }

    /**
     * gets the index of the blank tile on the board
     * @return the index of the blank
     */
    int getBlankIndex(){
        for(int i = 0; i < 9; i++){
            if(board[i].getTileNum() == 'b'){
             return i;
            }
        }
        return -1;
    }

    /**
     * prints out the tiles in rows of three
     * @return a string of three lines that represents the tiles of the board
     */
    public String toString() {
        return board[0] + ", " + board[1] + ", " + board[2] + "\n" + board[3] + ", " + board[4] + ", " + board[5] + "\n"+ board[6] + ", " + board[7] + ", " + board[8];
    }
}
