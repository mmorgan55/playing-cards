package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Card {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return rank.getSymbol() + suit.getSymbol();
  }

  public static void main(String[] args) {
    List<Card> deck = new LinkedList<>();
    List<Card> redCards = new LinkedList<>();
    List<Card> blackCards = new LinkedList<>();
    List<Card> discard = new LinkedList<>();
    List<Card> inter1 = new LinkedList<>();
    List<Card> inter2 = new LinkedList<>();

    Random rng;

    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }

    Collections.shuffle(deck);

    Color color = null;

    for (int i = deck.size(); i > 0 ; i--) {
      Card card = deck.get(i - 1);
      if (i % 2 == 0) {
        color = card.getSuit().getColor();
        discard.add(card);
      } else {
        if (color == Color.BLACK) {
          blackCards.add(card);
        } else {
          redCards.add(card);
        }
      }
    }

    
  }
}
