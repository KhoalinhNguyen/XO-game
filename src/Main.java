import Entity.Game;
import Entity.Player;
import Service.GameService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GameService gameService = new GameService();

        Player player1 = new Player();
        Player player2 = new Player();
        Player[] players = new Player[] {player1, player2};

        for(int x = 0; x < 2; x++) {
            System.out.print("Player " + (x+1) +":" );
            players[x].setPlayerName(scan.next());
            System.out.print("Player " + (x+1) + " mark:");
            players[x].setMark(scan.next().charAt(0));
        }

        Game game = gameService.startNewGame(players[0], players[1]);
        System.out.println();

        for( int i = 0; i < 9; i++) {
            System.out.println("round" + (i+1));
            if(i % 2 == 0) {
                System.out.print("Player 1 move:");
                char move = scan.next().charAt(0);
                gameService.playMove(move, game);
            } else {
                System.out.print("Player 2 move:");
                char move = scan.next().charAt(0);
                gameService.playMove(move, game);
            }
            if(gameService.checkWinner(game)) {
                if(game.getCurrentPlayer() == game.getPlayer1()) {
                    System.out.println("The winner is: " + game.getPlayer2().getPlayerName());
                } else {
                    System.out.println("The winner is: " + game.getPlayer1().getPlayerName());
                }
                return;
            }
        }
        System.out.println("The game is tie!");
        scan.close();
    }

}