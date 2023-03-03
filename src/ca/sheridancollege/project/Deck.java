/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * modified by Squad Group
 */


public class Deck {
    // instance variable to store the list of cards in the deck
    private final ArrayList<Card> cards;

    /**
     * Constructor that initializes the deck of cards.
     */
    public Deck() {
        cards = new ArrayList<>();
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

        // loop through each rank and suit to create a new card and add it to the deck
        for (String rank : ranks) {
            for (String suit : suits) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Method to shuffle the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Method to draw a card from the deck.
     * @return the top card from the deck
     */
    public Card drawCard() {
        return cards.remove(0);
    }

    /**
     * Method to check if the deck is empty.
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
