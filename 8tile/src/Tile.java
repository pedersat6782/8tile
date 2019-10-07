public class Tile {
    private int position;
    private char tileNum;

    public Tile(int position, char tileNum) {
        setPosition(position);
        setTileNum(tileNum);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTileNum() {
        return tileNum;
    }

    public void setTileNum(char tileNum) {
        this.tileNum = tileNum;
    }

    @Override
    public String toString() {
        return "(" + position + ", " + tileNum +")";
    }
}
