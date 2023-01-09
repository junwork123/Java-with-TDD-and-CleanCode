package org.cleancode.blackjack.state;

import org.cleancode.blackjack.cards.CardDeck;

public interface Playable {
    public Playable draw(CardDeck cardDeck);
    public Playable stay();
}
