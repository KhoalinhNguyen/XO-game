package Service;

import Entity.Board;
import Entity.Game;
import Entity.Player;

public class GameService {

    public Game startNewGame(Player player1, Player player2) {
        Board board = new Board();
        initBoard(board);

        return new Game(player1, player2, board);
    }

    private void initBoard(Board board) {
        for(char i : board.getBoardCells()) {
            if(i%3 == 0) {
                System.out.println();
                System.out.print("|");
            }
            System.out.print(i + "|");
        }
    }

    public void playMove(char move, Game game) {
        Board board = game.getBoard();
        char mark = game.getCurrentPlayer().getMark();
        board.getBoardCells()[Character.getNumericValue(move)] = mark;
        //System.out.println(board.getBoardCells()[Character.getNumericValue(move)]);

        for(int i = 0; i < board.getBoardCells().length; i++) {
            if(i%3 == 0) {
                System.out.println();
                System.out.print("|");
            }
            System.out.print( board.getBoardCells()[i]+ "|");
        }

        System.out.println();
        // switch turn
        if(game.getCurrentPlayer() == game.getPlayer1()) {
            game.setCurrentPlayer(game.getPlayer2());
        } else {
            game.setCurrentPlayer(game.getPlayer1());
        }
    }

    public boolean checkWinner(Game game) {
        char[] board = game.getBoard().getBoardCells();
        // check rows
        for(int i = 0; i < 3; i++) {
            if(board[i*3] == board[i*3 + 1] && board[i*3 + 1] == board[i*3 + 2] ) {
                return true;
            }
        }
        // check col
        for(int i = 0; i < 3; i++) {
            if(board[i] == board[i+3] && board[i+3] == board[i+6]) {
                return true;
            }
        }
        // check diagonal
        return (board[0] == board[4] && board[4] == board[8])
                || (board[2] == board[4] && board[4] == board[6]);
    }

}
