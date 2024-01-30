package Blackjack;

public class Bet {
    private int amount;

    public Bet(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void doubleAmount() {
        amount *= 2;
    }
}
