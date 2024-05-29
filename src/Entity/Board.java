package Entity;

public class Board {

    private char[] boardCells = new char[] {'0','1','2','3','4','5','6','7','8'};

    public Board() {
        this.boardCells = boardCells;
    }

    public char[] getBoardCells() {
        return boardCells;
    }

    public void setBoardCells(char[] boardCells) {
        this.boardCells = boardCells;
    }
}
