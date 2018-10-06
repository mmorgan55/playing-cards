package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;



public class Deck {

  private ArrayList<Card> deck;

  public  Deck () {
    deck = new ArrayList<>();
    deck = this.createDeck();
  }

  private ArrayList createDeck () {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }

    Collections.shuffle(deck);

    return deck;
  }

  public ArrayList<Card> getDeck() {
    return deck;
  }
}
