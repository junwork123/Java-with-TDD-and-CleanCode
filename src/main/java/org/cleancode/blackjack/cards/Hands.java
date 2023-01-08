package org.cleancode.blackjack.cards;

import java.util.List;

public class Hands{
    private final List<Card> cards;
    public Hands(List<Card> cards) {
        this.cards = cards;
    }
    public void add(Card card) {
        this.cards.add(card);
    }
    public int getCount(){
        return this.cards.size();
    }
    public int getSum() {
        return cards.stream().mapToInt(Card::getRank).sum();
    }
}
