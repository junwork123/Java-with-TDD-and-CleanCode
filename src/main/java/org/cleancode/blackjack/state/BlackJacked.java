package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.Hands;

public class BlackJacked extends PlayerState {
    public BlackJacked(final Hands hands) {
        super(hands, earningRate());
    }
    public static double earningRate() {
        return 1.5;
    }
}
