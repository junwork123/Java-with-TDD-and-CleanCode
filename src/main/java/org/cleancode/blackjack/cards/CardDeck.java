package org.cleancode.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    List<Card> cards;
    public static CardDeck create() {
        return new CardDeck(DefaultCardSet());
    }
    private static List<Card> DefaultCardSet() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }
    public CardDeck(List<Card> cards) {
        this.cards = cards;
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
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards");
        }
        return cards.remove(0);
    }
}
