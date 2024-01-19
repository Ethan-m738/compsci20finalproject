package Blackjack;

public class Player implements Money {
    
    private int money;
    private Hand hand;
    private Bet currentBet;

    public Player() {
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
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

    public void placeBet(int amount) {
        if (amount > money) {
            throw new IllegalArgumentException("Bet amount cannot be greater than current money");
        }
        this.currentBet = new Bet(amount);
        this.money -= amount;
    }

    public void winBet() {
        this.money += currentBet.getAmount() * 2;
        this.currentBet = null;
    }

    public void winDoubleDown() {
        this.money += currentBet.getAmount() * 4;
        this.currentBet = null;
    }

    public void loseBet() {
        this.currentBet = null;
    }

}
