package Blackjack;

public class House extends Hand implements Money {

    private Hand hand;

    public House() {
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public boolean shouldHit() {
        // Dealer follows the rule of hitting until they have at least 17
        return hand.score() < 17;
    }

    public int getTotal(){
        return 1;
    }

    public int totalAfterBet(){
        return 1;
    }

    public int differenceFromStart(){
        return 1;
    }
    
}
