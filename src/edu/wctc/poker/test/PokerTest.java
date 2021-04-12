package edu.wctc.poker.test;

import edu.wctc.poker.Card;
import edu.wctc.poker.Deck;
import edu.wctc.poker.Poker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {
    Deck deck = new Deck();
    List<Card> hand = new ArrayList();
    Poker poker = new Poker();

    PokerTest() {
    }

    @BeforeEach
    void runIt() {
        this.hand.add(this.deck.getCard(0));
        this.hand.add(this.deck.getCard(1));
        this.hand.add(this.deck.getCard(2));
        this.hand.add(this.deck.getCard(3));
        this.hand.add(this.deck.getCard(4));
    }

    @Test
    void isStraight() {
        Assertions.assertTrue(this.poker.isStraight(this.hand));
    }

    @Test
    void isStraightFlush() {
        Assertions.assertTrue(this.poker.isStraightFlush(this.hand));
    }

    @Test
    void isFlush() {
        Assertions.assertTrue(this.poker.isFlush(this.hand));
    }

    @Test
    void getHighCardScore() {
        Assertions.assertTrue(this.poker.getHighCardScore(this.hand) == 6);
    }

    @Test
    void isRoyalFlush() {
        this.hand.clear();
        this.hand.add(this.deck.getCard(8));
        this.hand.add(this.deck.getCard(9));
        this.hand.add(this.deck.getCard(10));
        this.hand.add(this.deck.getCard(11));
        this.hand.add(this.deck.getCard(12));
        Assertions.assertTrue(this.poker.isRoyalFlush(this.hand));
    }
}
