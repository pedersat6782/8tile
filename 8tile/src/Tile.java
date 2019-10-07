public class Tile {
    private char tileNum;
    public Tile(char tileNum) {
        this.tileNum = tileNum;
    }

    public int getTileNum() {
        return tileNum;
    }

    public void setTileNum(char tileNum) {
        this.tileNum = tileNum;
    }

    @Override
    public String toString() {
        return "" + tileNum;
    }
}
