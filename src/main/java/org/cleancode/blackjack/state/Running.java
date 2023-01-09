package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.Hands;

public class Running extends PlayerState {
    public Running(final Hands hands) {
        super(hands);
    }

    @Override
    public double earningRate() {
        return DEFAULT_EARNING_RATE;
    }
}
