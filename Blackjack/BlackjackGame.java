package Blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class BlackjackGame {
    
    private Deck deck = new Deck();
    private Player player = new Player();
    private House House = new House();
    private Scanner scanner = new Scanner(System.in);

    public void play() {
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
        while (true) {
            System.out.println("Your hand: ");
            System.out.println(player.getHand().status());
            System.out.println("Your score: " + player.getHand().score());

            if (player.getHand().score() > 21) {
                System.out.println("You busted!");
                return;
            }

            System.out.println("Do you want to hit or stand?");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("hit")) {
                player.getHand().addCard(deck.deal());
            } else if (action.equals("stand")) {
                return;
            } else {
                System.out.println("Invalid action. Please enter 'hit' or 'stand'.");
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

        if(playerScore == 21 && player.getHand().getAceCount() == 1 && (player.getHand().hasCard("Clubs", 11) || player.getHand().hasCard("Spades", 11))){

            System.out.println("You win since you had an ace and a black jack, and your winnings are multiplied by 3/2!");
            return;

        }

        if (playerScore > 21) {
            System.out.println("You busted! Dealer wins.");
        } else if (HouseScore > 21) {
            System.out.println("Dealer busted! You win.");
        } else if (playerScore > HouseScore) {
            System.out.println("You win!");
        } else if (HouseScore > playerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
