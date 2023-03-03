/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;


/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * modified by squad group March 2023
 */

public class Player {
    // instance variable to store the name of the player
    private final String name;

    // instance variable to store the score of the player
    private int score;

    // instance variable to store the player's hand (cards)
    private final ArrayList<Card> hand;

    /**
     * Constructor that sets the name of the player and initializes the score and hand.
     * @param name 
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * Getter method for the player's name.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the player's score.
     * @return the score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to add a point to the player's score.
     */
    public void addPoint() {
        score++;
    }

    /**
     * Method to add a card to the player's hand.
     * @param card the card to be added to the hand
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Getter method for the player's hand.
     * @return the player's hand (list of cards)
     */
    public ArrayList<Card> getHand() {
        return hand;
    }
}
