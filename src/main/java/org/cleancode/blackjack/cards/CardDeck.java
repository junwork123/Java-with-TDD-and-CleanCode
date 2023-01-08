package org.cleancode.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    List<Card> cards;
    public CardDeck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }
    private void shuffle() {

    }
    public List<Card> draw(int count) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(draw());
        }
        return cards;
    }
    public Card draw() {
        if (!this.hasCards()) {
            throw new IllegalStateException("No more cards");
        }
        return cards.remove(0);
    }
    public boolean hasCards() {
        return cards.isEmpty();
    }
}
