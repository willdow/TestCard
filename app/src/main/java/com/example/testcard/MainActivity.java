package com.example.testcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.testcard.models.Card;
import com.example.testcard.models.Deck;
import com.example.testcard.views.CardView;
import com.google.android.flexbox.FlexboxLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewPseudo;
    String pseudo;
    Deck deck;
    FlexboxLayout flexboxLayout;
    Chronometer simpleChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPseudo = (TextView) findViewById(R.id.textViewPseudo);

        //recuperation des donnees de la page precedante
        pseudo = getIntent().getStringExtra("pseudo").toString();
        textViewPseudo.setText("Bienvenue " + pseudo);


        //chrono
        simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
        simpleChronometer.start();

        deck = new Deck();
        deck.shuffle();
        flexboxLayout = (FlexboxLayout) findViewById(R.id.FlexboxLayoutCards);

        while (deck.count() > 0) {
            Card c = deck.draw();
            CardView cardView = new CardView(this, c);
            cardView.setOnClickListener(this);
            flexboxLayout.addView(cardView);
        }
    }

    @Override
    public void onClick(View v) {
        CardView cardView = (CardView) v;
        cardView.setTurn(!cardView.isTurn());
    }
}
