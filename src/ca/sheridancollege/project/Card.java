/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * modified by Squad Group March 2023
 */
public class Card {
    // instance variable to store the rank of the card
    private final String rank;

    // instance variable to store the suit of the card
    private final String suit;

    /**
     * Constructor that sets the rank and suit of the card.
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Getter method for the rank of the card.
     * @return the rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Getter method for the suit of the card.
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Overridden method to return a string representation of the card.
     * @return the string representation of the card
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

