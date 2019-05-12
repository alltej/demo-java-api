package com.alltej.apps.deckofcards;


import java.util.Random;

/**
 * @author atejano
 */
public class DeckOfCards {

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
//        deckOfCards.Shuffle();
        deckOfCards.Shuffle2();
    }

    public final static String[] SUITS = {"C", "D", "H", "S"};
    public final static String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private Card[] deck;
    private int cardsUsed;

    public DeckOfCards() {
        int cardCount = SUITS.length * RANKS.length;
        deck = new Card[cardCount];

        for (int i = 0; i <SUITS.length ; i++) {
            for (int j = 0; j <RANKS.length ; j++) {
                deck[RANKS.length*i+j] = new Card(j, i);
            }
        }
    }

    public void Shuffle() {
        int cardCount = SUITS.length * RANKS.length;
        // shuffle
        for ( int i = 0; i < cardCount; i++ ) {
            int rand = i + (int) (Math.random() * (cardCount-i));
            System.out.println("rand:" + rand);
            //swap
            Card temp = deck[rand];
            deck[rand] = deck[i];
            deck[i] = temp;
        }
        cardsUsed = 0;
        // print shuffled deck
        for (int i = 0; i < cardCount ; i++) {
            System.out.println(deck[i]);
        }
    }

    public void Shuffle2() {
        int cardCount = SUITS.length * RANKS.length;
        Random random = new Random();
        random.nextInt();
        for ( int i = 0; i < cardCount; i++ ) {
            int rand = random.nextInt(cardCount - 1);
            System.out.println("rand:" + rand);
            //swap
            Card temp = deck[rand];
            deck[rand] = deck[i];
            deck[i] = temp;
        }
        cardsUsed = 0;
        // print shuffled deck
        for (int i = 0; i < cardCount ; i++) {
            System.out.println(deck[i]);
        }
    }

    public int cardsLeft() {
        // As cards are dealt from the deck, the number of cards left
        // decreases.  This function returns the number of cards that
        // are still left in the deck.
        return 52 - cardsUsed;
    }

    public Card dealCard() {
        // Deals one card from the deck and returns it.
        if (cardsUsed == 52)
            Shuffle();
        cardsUsed++;
        return deck[cardsUsed - 1];
    }

}


