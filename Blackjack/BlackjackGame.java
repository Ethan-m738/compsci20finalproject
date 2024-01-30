package Blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {

    private Deck deck = new Deck();
    private Player player = new Player();
    private House House = new House();
    private Scanner scanner = new Scanner(System.in);
    private int roundNum = 0;


    public void play() {
        
        roundNum++;
        System.out.println("Round: " + roundNum);
        if(roundNum > 1){
        if (player.getTotal() > 0 && House.getTotal() > 0) {
            String playAgain;
            System.out.println("Do you want to play another round? (yes/no)");
            playAgain = scanner.nextLine().toLowerCase();

            if (playAgain.equals("no")) {
                exitGame();
            }
            else if(!playAgain.equals("yes")){
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        if (player.getTotal() <= 0) {
            System.out.println("You ran out of money! Game over.");
            exitGame();
        } else if (House.getTotal() <= 0) {
            System.out.println("The house ran out of money! You win the game.");
            exitGame();
        }
    }
    playRound();
    }

    public void playRound() {
        deck.shuffle();
        player.getHand().addCard(deck.deal());
        player.getHand().addCard(deck.deal());
        House.getHand().addCard(deck.deal());
        House.getHand().addCard(deck.deal());

        playerTurn();
        HouseTurn();
        checkWinner();
    }

    private void playerTurn() {
        System.out.println("Your balance: " + player.getTotal());
        System.out.println("Enter bet amount: ");
        int betAmount = scanner.nextInt();
        player.placeBet(betAmount);

        while (true) {
            System.out.println("Your hand: ");
            System.out.println(player.getHand().status());
            System.out.println("Your score: " + player.getHand().score());

            if (player.getHand().score() > 21) {
                System.out.println("You busted!");
                return;
            }

            System.out.println("Do you want to hit, double, or stand?");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("hit")) {
                player.getHand().addCard(deck.deal());
            } else if (action.equals("stand")) {
                return;
            } else if (action.equals("double")) {
                player.doubleBet();
                System.out.println(player.getBetAmount().getAmount() + " Is your new bet.");
                player.getHand().addCard(deck.deal());
            } else {
                System.out.println("Invalid action. Please enter 'hit', 'stand', or 'double'.");
            }
        }
    }

    private void HouseTurn() {
        while (House.getHand().score() < 17) {
            House.getHand().addCard(deck.deal());
        }
    }

    private void checkWinner() {
        int playerScore = player.getHand().score();
        int HouseScore = House.getHand().score();

        System.out.println("Dealer's hand: ");
        System.out.println(House.getHand().status());
        System.out.println("Dealer's score: " + HouseScore);

        if (playerScore == 21 && player.getHand().getAceCount() == 1
                && (player.getHand().hasCard("Clubs", 11) || player.getHand().hasCard("Spades", 11))) {

            System.out
                    .println("You win since you had an ace and a black jack, and your winnings are multiplied by 3/2!");
            House.looseBlackJack();
            player.winBlackJack();
            return;

        }

        if (playerScore > 21) {
            System.out.println("You busted! Dealer wins.");
            House.winBet();
            player.loseBet();
        } else if (HouseScore > 21) {
            System.out.println("Dealer busted! You win.");
            House.loseBet();
            player.winBet();
        } else if (playerScore > HouseScore) {
            System.out.println("You win!");
            House.loseBet();
            player.winBet();
        } else if (HouseScore > playerScore) {
            System.out.println("Dealer wins.");
            House.winBet();
            player.loseBet();
        } else {
            System.out.println("It's a tie!");
            House.tie();
            player.tie();
        }

        resetGame();
        play();
    }

    public void resetGame() {
        // Get the cards from the player's hand
        ArrayList<Card> playerCards = new ArrayList<>(player.getHand().getCards());
    
        // Get the cards from the house's hand
        ArrayList<Card> houseCards = new ArrayList<>(House.getHand().getCards());
    
        // Add the cards back to the deck
        for (Card card : playerCards) {
            deck.addCard(card);
        }
        for (Card card : houseCards) {
            deck.addCard(card);
        }
    
        // Clear the hands
        player.getHand().clear();
        House.getHand().clear();
    
        // Shuffle the deck
        deck.shuffle();
    }

    public void exitGame(){
        System.exit(0);
    }

}
