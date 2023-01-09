package org.cleancode.blackjack;

import org.cleancode.blackjack.cards.*;
import org.cleancode.blackjack.state.PlayerState;
import org.cleancode.blackjack.state.Started;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class BlackJackTest {
    private Hands normalHands;
    private Hands blackjackedHands;
    private CardDeck deck;
    @BeforeEach
    public void setUp() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.SPADE, Rank.EIGHT)); // 8
        cards.add(new Card(Suit.DIAMOND, Rank.QUEEN)); // 10
        normalHands = new Hands(cards);

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card(Suit.SPADE, Rank.ACE)); // 1 or 11
        cards2.add(new Card(Suit.DIAMOND, Rank.QUEEN)); // 10
        blackjackedHands = new Hands(cards2);

        List<Card> cards3 = new ArrayList<>();
        cards3.add(new Card(Suit.SPADE, Rank.KING)); // 10
        cards3.add(new Card(Suit.DIAMOND, Rank.KING)); // 10
        deck = new CardDeck(cards3);
    }
    @Test
    public void started(){
        Started started = new Started(normalHands);
        assertThat(started.getScore()).isEqualTo(normalHands.getSum());
    }
    @Test
    public void busted(){
        Started started = new Started(normalHands);
        PlayerState busted = started.draw(deck);
        assertThat(busted.getScore()).isEqualTo(28);
        assertThat(busted.isBusted()).isTrue();
        assertThat(busted.earningRate()).isEqualTo(-1);
    }
    @Test
    public void blackjacked(){
        Started started = new Started(blackjackedHands);
        assertThat(started.getScore()).isEqualTo(21);
        assertThat(started.isBlackjacked()).isTrue();
        assertThat(started.earningRate()).isEqualTo(1.5);
    }
}
