package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.CardDeck;
import org.cleancode.blackjack.cards.Hands;

public abstract class PlayerState implements Playable {
    public static final int MAX_RANK = 21;
    public static final double DEFAULT_EARNING_RATE = 1.0;
    protected final Hands hands;
    protected PlayerState(Hands hands) {
        this.hands = hands;
    }

    @Override
    public PlayerState stay() {
        return new Finished(hands);
    }

    @Override
    public PlayerState draw(CardDeck cardDeck) {
        hands.add(cardDeck.draw());
        if(isBusted()){
            return new Busted(hands);
        }
        if(isBlackjacked()){
            return new BlackJacked(hands);
        }
        return new Running(hands);
    }

    public boolean isBlackjacked() { return hands.getSum() == MAX_RANK; }

    public boolean isBusted(){
        return hands.getSum() > MAX_RANK;
    }

    public int getScore(){ return hands.getSum(); }

    public abstract double earningRate();
}
