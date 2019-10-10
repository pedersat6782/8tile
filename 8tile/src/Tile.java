public class Tile {
    private char tileNum;

    /**
     * constructor that sets what the tile value is ex. 'b' or '5'
     * @param tileNum parameter that takes in what it is
     */
    Tile(char tileNum) {
        this.tileNum = tileNum;
    }

    /**
     * getter for tileNum
     * @return returns the tiles value ex. 'b' or '5'
     */
    int getTileNum() {
        return tileNum;
    }

    /**
     * toSrting method that prints out the tiles value ex. 'b' or '5'
     * @return returns the value of tile as a string
     */
    @Override
    public String toString() {
        return "" + tileNum;
    }

    public boolean equals(Tile compare) {
            return tileNum == compare.tileNum;
    }
}
