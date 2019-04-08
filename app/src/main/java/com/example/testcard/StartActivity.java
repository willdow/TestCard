package com.example.testcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextPseudo;
    Button btnPlay;
    RadioButton rdEasy, rdNormal, rdHard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editTextPseudo = (EditText) findViewById(R.id.editTextPseudo);
        rdEasy = (RadioButton) findViewById(R.id.radioButtonEasy);
        rdEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        rdNormal = (RadioButton) findViewById(R.id.radioButtonNormal);
        rdNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        rdHard = (RadioButton) findViewById(R.id.radioButtonHard);
        rdHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        btnPlay = (Button) findViewById(R.id.btnPlay);


        btnPlay.setEnabled(false);

        editTextPseudo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                btnPlay.setEnabled((s.toString().length()) != 0);
                //et setEnabled si un niveau n'est pas selectionné
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdEasy.isChecked() || rdNormal.isChecked() || rdHard.isChecked()) {
                    String pseudo = editTextPseudo.getText().toString();
                    Intent unIntent = new Intent(StartActivity.this, MainActivity.class);
                    unIntent.putExtra("pseudo", pseudo);
                    if(rdEasy.isChecked() == true){
                        unIntent.putExtra("rdEasy",rdEasy.isChecked());
                    }
                    else if(rdNormal.isChecked() ==true){
                        unIntent.putExtra("rdNormal",rdNormal.isChecked());
                    }
                    else {
                        unIntent.putExtra("rdHard", rdHard.isChecked());
                    }
                    startActivity(unIntent);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
