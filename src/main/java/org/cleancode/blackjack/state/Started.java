package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.CardDeck;
import org.cleancode.blackjack.cards.Hands;

public class Started extends PlayerState {
    public static final int START_DRAW_COUNT = 2;
    public static Started create(CardDeck deck) {
        Hands hands = new Hands(deck.draw(START_DRAW_COUNT));
        return new Started(hands);
    }

    public Started(final Hands hands) {
        super(hands);
        if(hands.getCount() != START_DRAW_COUNT){
            throw new IllegalArgumentException("Hands must have " + START_DRAW_COUNT + " cards");
        }
    }

    @Override
    public double earningRate() {
        return DEFAULT_EARNING_RATE;
    }
}
