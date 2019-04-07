package com.example.testcard.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>(); //plus propre de déclaré dans le constructeur
        String[] colors = {"PIQUE", "TREFLE", "COEUR", "CARREAU"};
        for (String c : colors) {
            for (int i = 13; i > 0; i--) {
                switch (i) {
                    case 1:
                        cards.add(new Card(c, "A"));
                        break;
                    case 11:
                        cards.add(new Card(c, "V"));
                        break;
                    case 12:
                        cards.add(new Card(c, "D"));
                        break;
                    case 13:
                        cards.add(new Card(c, "R"));
                        break;
                    case 2: //à partir du deux, tous les autres chiffres
                    default:
                        cards.add(new Card(c, i + ""));
                        break;
                }
            }
        }
    }


    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw(){
        Card c= cards.get(0);
        cards.remove(c);
        return c;
    }

    public int count(){
        return cards.size();
    }

}
