package Blackjack;

public interface Money {

    int getTotal();

    int totalAfterBet(int ammount);

    int differenceFromStart();

    void winBet();
    
    void loseBet();

    void tie();

}
