package org.cleancode.blackjack.cards;

import java.util.Objects;

public class Card {
    private final Rank rank;
    private final Suit suit;
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit.getSymbol() + rank.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank);
    }

    public int getRank() {
        return this.rank.getScore();
    }
}
