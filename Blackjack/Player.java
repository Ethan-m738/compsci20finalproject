package Blackjack;

public class Player implements Money {
    
    private int money;
    private Hand hand;
    private Bet currentBet;
    private int startMoney = 100;

    public Player() {
        initializeMoney();
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public Bet getBetAmount() {
        return currentBet;
    }

    public void doubleBet() {
        if (money >= currentBet.getAmount()) {
            money -= currentBet.getAmount();
            currentBet.doubleAmount();
        } else {
            System.out.println("You don't have enough balance to double the bet.");
        }
    }

    public int getTotal(){
        return money;
    }

    public int totalAfterBet(int ammount){
        return money - ammount;
    }

    public int differenceFromStart(){
        return startMoney - money;
    }

    public void initializeMoney() {

        money = startMoney;

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

    public void winBlackJack(){
        this.money += (int)Math.ceil(currentBet.getAmount() * 2.5);
        this.currentBet = null;
    }

    public void tie(){
        this.money += currentBet.getAmount();
        this.currentBet = null;
    }

}
