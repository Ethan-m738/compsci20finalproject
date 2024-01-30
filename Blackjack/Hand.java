package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class AbstractHand {
    protected List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract int score();

    public abstract String status();
}

class Hand extends AbstractHand {

    public int aceCount;

    public List<Card> getCards(){
        return cards;
    }

    public int score() {
        int value = 0;
        aceCount = 0;

        for (Card card : cards) {
            int rank = card.getRank();
            if (rank == 1) {
                aceCount++;
                value += 11;
            } else if (rank > 10) {
                value += 10;
            } else {
                value += rank;
            }
        }
        // If we have aces and our value is too high, reduce the value
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public String status() {
        //Cards should call toString() automatically
        StringBuilder cardsString = new StringBuilder();
        for(Card card : cards){
            cardsString.append(card.toString()).append(", ");
    }
        
        return "Hand{" + 
                "cards=" + cardsString.toString() +
                ", score=" + score() +
                '}';
    }

    public boolean hasCard(String suit, int rank) {
        for (Card card : cards) {
            if (card.getSuit().equals(suit) && card.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

    public int getAceCount(){
        return aceCount;
    }

    public void clear(){
        cards.clear();
    }
}