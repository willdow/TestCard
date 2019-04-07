package com.example.testcard.models;

import com.example.testcard.views.CardView;

public class Memory {
    CardView selectCard;

    public Memory() {
        selectCard = null;
    }

    public void setSelectCard(CardView c) {
        if (selectCard == null) {
            selectCard = c;
            selectCard.setTurn(false);
        } else {

        }
    }

    public boolean isBlack(CardView c) {
        return (c.getCardColor().equals("TREFLE") || c.getCardColor().equals("PIQUE"));
    }

    public boolean isSame(CardView c1, CardView c2) {
        return (isBlack(c1) && isBlack(c2) && c1.getCardValue().equals(c2.getCardValue())) ||
                (!isBlack(c1) && !isBlack(c2) && c1.getCardValue().equals(c2.getCardValue()));
    }
}


//choix du nombre de card avec les bonnes pairs
//ajouter un chrono, dès qu'on gagne on arrete le chrono
