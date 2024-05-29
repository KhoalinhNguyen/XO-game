package Entity;

public class Player {
    private String playerName;
    private char mark;



    public Player(String playerName, char mark) {
        this.playerName = playerName;
        this.mark = mark;
    }

    public Player() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
}
