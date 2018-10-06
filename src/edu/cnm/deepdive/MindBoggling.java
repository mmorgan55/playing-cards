package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MindBoggling {
  ArrayList<Card> gameDeck = new ArrayList<>();
  LinkedList<Card> redCards = new  LinkedList<>();
  LinkedList<Card> blackCards = new  LinkedList<>();
  List<Card> discard = new ArrayList<>();
  Color color = null;
  Deck deck;


  public MindBoggling () {
    deck = new Deck();
    gameDeck = deck.getDeck();
  }

  private void separateCards() {
    for (int i = gameDeck.size(); i > 0; i--) {
      Card card = gameDeck.get(i - 1);
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

  public void playGame() {
    separateCards();
    swapCards();
    System.out.println(checkMagic());
  }

  private void swapCards () {
    List<Card> redInter = new  ArrayList<>();
    List<Card> blackInter = new  ArrayList<>();
    int lowerCardAmt;

    if (redCards.size() > blackCards.size()) {
      lowerCardAmt = blackCards.size();
    } else if (blackCards.size() > redCards.size()) {
      lowerCardAmt = redCards.size();
    } else {
      lowerCardAmt = 13;
    }

    int randInt = (((int) Math.floor(Math.random() * lowerCardAmt)));

    for (int i = 0; i < randInt; i++) {
      redInter.add(redCards.removeLast());
      blackInter.add(blackCards.removeLast());
    }

    blackCards.addAll(redInter);
    redCards.addAll(blackInter);
  }

  private boolean checkMagic () {
    int redTotal = 0;
    int blackTotal = 0;

    for (Card card : redCards) {
      if (card.getSuit().getColor() == Color.RED) {
        redTotal++;
      }
    }

    for (Card card : blackCards) {
      if (card.getSuit().getColor() == Color.BLACK) {
        blackTotal++;
      }
    }
    
    return (redTotal == blackTotal);
  }
}
