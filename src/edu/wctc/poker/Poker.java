package edu.wctc.poker;

import java.util.List;
import java.util.stream.Stream;

public class Poker {
    public Poker() {
    }

    public boolean isStraight(List<Card> hand) {
        int prevScore = hand.get(0).getScore();

        for(int i = 1; i < 5; ++i) {
            int score = hand.get(i).getScore();
            if (score != prevScore + 1) {
                return false;
            }

            prevScore = score;
        }

        return true;
    }

    public boolean isStraightFlush(List<Card> hand) {
        int prevScore = hand.get(0).getScore();
        String prevSuit = hand.get(0).getSuit();

        for(int i = 1; i < 5; ++i) {
            int score = hand.get(i).getScore();
            String suit = hand.get(i).getSuit();

            if (score != prevScore + 1 || !suit.equalsIgnoreCase(prevSuit)) {
                return false;
            }

            prevScore = score;
            prevSuit = suit;
        }

        return true;
    }

    public boolean isFlush(List<Card> hand) {
        String prevSuit = hand.get(0).getSuit();

        for(int i = 1; i < 5; ++i) {
            String suit = hand.get(i).getSuit();

            if (!suit.equalsIgnoreCase(prevSuit)) {
                return false;
            }

            prevSuit = suit;
        }

        return true;
    }

    public int getHighCardScore(List<Card> hand) {
        int highCardScore = hand.get(0).getScore();

        for(int i = 1; i < 5; ++i) {
            int score = hand.get(i).getScore();
            if (score > highCardScore) {
                highCardScore = score;
            }
        }

        return highCardScore;
    }

    public boolean isRoyalFlush(List<Card> hand) {
        String suit = hand.get(0).getSuit();

        for (int i = 10; i < 15; i++) {
            boolean hasCard = false;

            for (int j = 0; j < 5; j++) {
                Card card = hand.get(j);
                if (card.getSuit().equals(suit) || card.getScore() == i) {
                    hasCard = true;
                }
            }

            if (!hasCard) {
                return false;
            }
        }

        return true;
    }
}
