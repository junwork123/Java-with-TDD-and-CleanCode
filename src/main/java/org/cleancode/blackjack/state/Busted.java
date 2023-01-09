package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.Hands;

public class Busted extends PlayerState {
    public Busted(final Hands hands) {
        super(hands, earningRate());
    }
    public static double earningRate() {
        return -1;
    }
}
