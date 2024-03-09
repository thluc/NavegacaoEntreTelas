package com.teste.navegaodecores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Random;
import android.content.SharedPreferences;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button botaovermelho;
    Button botaoverde;
    Button botaoazul;
    Button botaoaleatorio;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        botaovermelho = findViewById(R.id.botaovermelho);
        botaoverde = findViewById(R.id.botaoverde);
        botaoazul = findViewById(R.id.botaoazul);
        botaoaleatorio = findViewById(R.id.botaoaleatorio);
        layout = findViewById(R.id.linearlayout);

        layout.setBackgroundColor(preferences.getInt("cordofundo", Color.WHITE));


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

    public void mudaCor(int cor) {
        layout = findViewById(R.id.linearlayout);
       SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
       SharedPreferences.Editor editor = preferences.edit();
       layout.setBackgroundColor(cor);
       editor.putInt("cordofundo", cor);
       editor.apply();
    }


    public void proxtela(View view) {
        Intent in = new Intent(MainActivity.this, tela2.class);
        startActivity(in);
    }

}