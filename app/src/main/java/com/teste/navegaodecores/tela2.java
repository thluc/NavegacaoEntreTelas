package com.teste.navegaodecores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.SharedPreferences;
import android.widget.TextView;

import java.util.Random;

public class tela2 extends AppCompatActivity {

    LinearLayout layout1;
    Button botaovermelho1;
    Button botaoverde1;
    Button botaoazul1;
    Button botaoaleatorio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        botaovermelho1 = findViewById(R.id.botaovermelho1);
        botaoverde1 = findViewById(R.id.botaoverde1);
        botaoazul1 = findViewById(R.id.botaoazul1);
        botaoaleatorio1 = findViewById(R.id.botaoaleatorio1);
        layout1 = findViewById(R.id.linearlayout1);

        layout1.setBackgroundColor(preferences.getInt("cordofundo2", Color.WHITE));

        botaovermelho1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaCor(Color.RED);
            }
        });
        botaoverde1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaCor(Color.GREEN);
            }
        });
        botaoazul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaCor(Color.BLUE);
            }
        });
        botaoaleatorio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);

                int corAleatoria = Color.rgb(red, green, blue);

                mudaCor(corAleatoria);
            }
        });

    }

    public void mudaCor(int cor) {
        layout1 = findViewById(R.id.linearlayout1);
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        layout1.setBackgroundColor(cor);
        editor.putInt("cordofundo2", cor);
        editor.apply();
    }

    public void telaanterior2(View view) {
        Intent in = new Intent(tela2.this, MainActivity.class);
        startActivity(in);
    }
    public void proxtela2(View view) {
        Intent in = new Intent(tela2.this, tela3.class);
        startActivity(in);
    }


}