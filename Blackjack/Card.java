package Blackjack;

 interface Suitable {
     String getSuit();
}

interface Rankable {
    int getRank();
}

public class Card implements Rankable{
    private String suit;
    private int rank;

    public Card(String suit, int rank){
        this.rank = rank;
        this.suit = suit;
    }

     public String getSuit() {
         return suit;
     }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + Rank.fromValue(rank).getName() +
                '}';
    }

}
