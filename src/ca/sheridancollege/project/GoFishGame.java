/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 * 
 * 
 * Go Fish is a classic card game for 4 players. The objective of the game is to collect as many sets of 4 cards of the 
 * same rank as possible.
 * 
 * Each player starts with a hand of 5 cards. The remaining cards form a draw pile in the center of the table.
 * 
 * On a player's turn, they choose another player and ask them if they have any cards of a specific rank. For example, 
 * "Do you have any 6's?"
 * 
 * If the player being asked has any cards of the rank asked for, they must give all their cards of that rank to 
 * the player who asked. The player who asked then gets another turn.
 * 
 * If the player being asked does not have any cards of the rank asked for, they reply "Go Fish!" and the player 
 * who asked must draw a card from the draw pile.
 * 
 * If the player draws a card of the rank they asked for, they get another turn. If they do not, their turn is over.
 * 
 * The game continues until one player has collected four cards of the same rank, at which point they lay down 
 * the set and continue playing. The first player to lay down all their sets wins the game.
 *
 * The game continues until one player has collected four cards of the same rank, at which point they lay down 
 * the set and continue playing. The first player to lay down all their sets wins the game.
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * 
 * modified by Squad Group March 2023
 */



public class GoFishGame {
    // instance variable to store the list of players in the game
    private final ArrayList<Player> players;

    // instance variable to store the deck of cards used in the game
    private final Deck deck;

    /**
     * Constructor that initializes the list of players and the deck of cards.
     */
    public GoFishGame() {
        players = new ArrayList<>();
        deck = new Deck();
    }

    /**
     * Method to register a player for the game.
     * @param player the player to be registered
     */
    public void registerPlayer(Player player) {
        players.add(player);
    }

    /**
     * Method to start the Go Fish game.
     */
    public void startGame() {
        Scanner input = new Scanner(System.in);
        deck.shuffle();
        dealCards();

        while (true) {
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);

                System.out.println(currentPlayer.getName() + ", it's your turn.");
                System.out.println("Your current score is: " + currentPlayer.getScore());
                System.out.println("Your current hand is: " + currentPlayer.getHand());
                System.out.print("Enter the name of the player you want to ask: ");

                String opponentName = input.nextLine();
                Player opponent = getPlayerByName(opponentName);

                if (opponent == null) {
                    System.out.println("Invalid player name. Please try again.");
                    continue;
                }

                System.out.print("Enter the rank you want to ask for: ");
                String rank = input.nextLine();

                System.out.println("Do you have any " + rank + "'s?");
                System.out.print("Enter 'yes' or 'no': ");

                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("Congratulations! You got a match.");
                    currentPlayer.addPoint();
                } else {
                    System.out.println("Go Fish!");
                    Card drawnCard = deck.drawCard();
                    System.out.println("You drew a " + drawnCard.toString());

                    if (drawnCard.getRank().equals(rank)) {
                        System.out.println("Congratulations! You got a match.");
                        currentPlayer.addPoint();
                    } else {
                        System.out.println("Sorry, no match. Turn over.");
                    }
                }

                if (deck.isEmpty()) {
                    System.out.println("The deck is empty.");
                    break;
                }
            }

            Player winner = getWinner();
            if (winner != null) {
                System.out.println("The game is over! The winner is " + winner.getName() + " with a score of " + winner.getScore());
                break;
                        }
        }
    }

    /**
     * Method to deal cards to each player.
     */
    private void dealCards() {
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.addCard(deck.drawCard());
            }
        }
    }

    /**
     * Method to get a player by name.
     * @param name the name of the player to be retrieved
     * @return the player with the specified name, or null if the player does not exist
     */
    private Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Method to determine the winner of the game.
     * @return the player with the highest score, or null if no player has reached 5 points
     */
    private Player getWinner() {
        int maxScore = 0;
        Player winner = null;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winner = player;
            }
        }

        if (maxScore >= 5) {
            return winner;
        } else {
            return null;
        }
    }
}
