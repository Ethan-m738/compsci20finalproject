package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface CardDeck {
    void shuffle();
    Card deal();
    int size();
}

public class Deck implements CardDeck {

    private List<Card> cards = new ArrayList<>();

    // Initialize the deck with 52 cards
    public Deck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        for (String suit : suits) {
            for (int rank = 1; rank <= 13; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        //Takes card off top, removes from array in deck
        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }

}
