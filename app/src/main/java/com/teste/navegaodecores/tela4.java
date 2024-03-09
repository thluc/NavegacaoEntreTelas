package com.teste.navegaodecores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class tela4 extends AppCompatActivity {

    Button botaovermelho;
    Button botaoverde;
    Button botaoazul;
    Button botaoaleatorio;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);

        //Padrão
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        botaovermelho = findViewById(R.id.botaovermelho);
        botaoverde = findViewById(R.id.botaoverde);
        botaoazul = findViewById(R.id.botaoazul);
        botaoaleatorio = findViewById(R.id.botaoaleatorio);
        layout = findViewById(R.id.linearlayout3);

        //"cordefundo" significa em qual cor a atividade e somente nessa atividade
        // a cor irá permanecer
        layout.setBackgroundColor(preferences.getInt("cordofundo4", Color.WHITE));

        botaovermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaCor(Color.RED);
            }
        });
        botaoverde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaCor(Color.GREEN);
            }
        });
        botaoazul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudaCor(Color.BLUE);
            }
        });
        botaoaleatorio.setOnClickListener(new View.OnClickListener() {
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

    //Função que muda a cor do layout
    public void mudaCor(int cor) {
        layout = findViewById(R.id.linearlayout3);
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        layout.setBackgroundColor(cor);
        editor.putInt("cordofundo4", cor);
        editor.apply();
    }

    //Muda para a tela quatro
   public void telaanterior4(View view) {
    Intent in = new Intent(tela4.this, tela3.class);
    startActivity(in);
}}



