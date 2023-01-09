package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.Hands;

public class BlackJacked extends PlayerState {
    public BlackJacked(final Hands hands) {
        super(hands);
    }
    @Override
    public double earningRate() {
        return DEFAULT_EARNING_RATE * 1.5;
    }
}
