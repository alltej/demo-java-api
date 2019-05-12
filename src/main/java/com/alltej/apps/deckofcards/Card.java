package com.alltej.apps.deckofcards;

public class Card {

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return DeckOfCards.SUITS[suit];
    }

    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {

        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return DeckOfCards.RANKS[rank] + " of " + DeckOfCards.SUITS[suit];
    }
}
