package Blackjack;

public class House extends Hand implements Money {

    private Hand hand;
    private Bet currentBet;
    private Player player = new Player();
    private int money;
    private int currentPlayerBet;
    private int startMoney = 10000;

    public House() {
        initializeMoney();
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

    public int getDealerBet(){
        if (player.getBetAmount() == null) {
            return 0;
        }
        else{
            return player.getBetAmount().getAmount();
        }
    }

    public void initializeMoney() {
        money = startMoney;
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

    public void winBet() {
        this.money += currentPlayerBet;
    }

    public void loseBet() {
        this.money -= currentPlayerBet;
    }

    public void tie(){
        
    }

    public void looseBlackJack(){
        this.money -= (int)Math.ceil(currentPlayerBet * 1.5);
    }
    
}
