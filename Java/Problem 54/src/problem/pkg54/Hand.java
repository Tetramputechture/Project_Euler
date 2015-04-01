/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg54;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class Hand implements Comparable<Hand> {

    private class Card implements Comparable<Card> {

        private final int value;
        private final int suit;

        public Card(int value, int suit) {
            this.value = value;
            this.suit = suit;
        }

        @Override
        public int compareTo(Card c) {
            if (value > c.value) {
                return 1;
            }
            if (value < c.value) {
                return -1;
            }

            // values are equal, so compare suits
            if (suit > c.suit) {
                return 1;
            }
            if (suit < c.suit) {
                return -1;
            }

            return 0;
        }

        @Override
        public String toString() {
            String suitString;
            switch (suit) {
                case 1:
                    suitString = "Spades";
                    break;
                case 2:
                    suitString = "Hearts";
                    break;
                case 3:
                    suitString = "Diamons";
                    break;
                default:
                    suitString = "Clubs";
            }
            return String.format("%s of %s", value, suitString);
        }
    }

    private final Card[] cards;

    private final int numPairs;
    private final boolean straight;
    private final boolean flush;

    private final int rank;

    private int highCard;

    public Hand(String cardString) {

        cards = new Card[5];

        String[] hand = cardString.split(" ");

        int cIndex = 0;
        for (String s : hand) {
            int value;
            switch (s.charAt(0)) {
                case 'T':
                    value = 10;
                    break;
                case 'J':
                    value = 11;
                    break;
                case 'Q':
                    value = 12;
                    break;
                case 'K':
                    value = 13;
                    break;
                case 'A':
                    value = 14;
                    break;
                default:
                    value = Character.getNumericValue(s.charAt(0));
            }
            int suit = 0;
            switch (s.charAt(1)) {
                case 'S':
                    suit = 1;
                    break;
                case 'H':
                    suit = 2;
                    break;
                case 'D':
                    suit = 3;
                    break;
                case 'C':
                    suit = 4;
                    break;
            }
            cards[cIndex] = new Card(value, suit);

            cIndex++;
        }
        Arrays.sort(cards);

        highCard = cards[4].value;

        numPairs = getNumPairs();
        flush = isFlush();
        straight = isStraight();
        rank = getRank();
    }

    private boolean isFlush() {
        int c0suit = cards[0].suit;
        return c0suit == cards[1].suit
                && c0suit == cards[2].suit
                && c0suit == cards[3].suit
                && c0suit == cards[4].suit;
    }

    private boolean isStraight() {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].value + 1 != cards[i + 1].value) {
                return false;
            }
        }
        return true;
    }

    private int getNumPairs() {
        int[] vals = new int[cards.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = cards[i].value;
        }

        int numDistinctPairs = 0;
        int valOfPairFound = 0;
        for (int i = 0; i < vals.length - 1; i++) {
            if (vals[i] != valOfPairFound && vals[i] == vals[i + 1]) {
                if (valOfPairFound == 0) {
                    highCard = vals[i];
                }
                valOfPairFound = vals[i];
                numDistinctPairs++;
            }
        }

        return numDistinctPairs;
    }

    private int getRank() {
        if (isRoyalFlush()) {
            return 10;
        }
        if (isStraightFlush()) {
            return 9;
        }
        if (isFourOfAKind()) {
            return 8;
        }
        if (isFullHouse()) {
            return 7;
        }
        if (flush) {
            return 6;
        }
        if (straight) {
            return 5;
        }
        if (isThreeOfAKind()) {
            return 4;
        }
        if (isTwoPair()) {
            return 3;
        }
        if (isOnePair()) {
            return 2;
        }
        return 1;
    }

    public boolean isOnePair() {
        return numPairs >= 1;
    }

    public boolean isTwoPair() {
        return numPairs == 2;
    }

    public boolean isRoyalFlush() {
        return flush
                && straight
                && cards[0].value == 10;
    }

    public boolean isStraightFlush() {
        return flush && straight;
    }

    public boolean isFourOfAKind() {
        int c0 = cards[0].value;
        int c1 = cards[1].value;
        int c2 = cards[2].value;
        int c3 = cards[3].value;
        int c4 = cards[4].value;
        return (c0 == c1
                && c0 == c2
                && c0 == c3)
                || c1 == c2
                && c2 == c3
                && c3 == c4;
    }

    public boolean isFullHouse() {
        int c0 = cards[0].value;
        int c1 = cards[1].value;
        int c2 = cards[2].value;
        int c3 = cards[3].value;
        int c4 = cards[4].value;
        if (c0 == c1
                && c2 == c3
                && c3 == c4) {
            highCard = c2;
            return true;
        }
        return false;
    }

    public boolean isThreeOfAKind() {
        int c0 = cards[0].value;
        int c1 = cards[1].value;
        int c2 = cards[2].value;
        int c3 = cards[3].value;
        int c4 = cards[4].value;
        return c0 == c1
                && c0 == c2
                || c1 == c2 && c2 == c3
                || c2 == c3 && c3 == c4;
    }

    public int getHighestValue() {
        return cards[4].value;
    }

    @Override
    public int compareTo(Hand h) {
        if (rank > h.rank) {
            return 1;
        }
        if (rank < h.rank) {
            return -1;
        }

        // ranks are equal, compare high cards
        if (highCard > h.highCard) {
            return 1;
        }
        if (highCard < h.highCard) {
            return -1;
        }

        // high cards are equal, compare next highest cards

        for (int i = 2; i >= 0; i--) {
            if (cards[i].value > h.cards[i].value) {
                return 1;
            }
            if (cards[i].value < h.cards[i].value) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.nanoTime();

        int totalWins = 0;
        
        Scanner f = new Scanner(new File("poker.txt"));
        
        while (f.hasNext()) {
            String s = f.nextLine();
            Hand h1 = new Hand(s.substring(0, 14));
            Hand h2 = new Hand(s.substring(15, s.length()));
            if (h1.compareTo(h2) > 0) {
                totalWins++;
            }
        }

        System.out.println(totalWins);

        System.out.println((System.nanoTime() - start) / 1e9);
    }

}
