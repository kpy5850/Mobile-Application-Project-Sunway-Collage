package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Eevee_Evolve extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eevee_evolve);

        //Music
        backgroundMusic = new BackgroundMusic();
        backgroundMusic.start(this, R.raw.evolve_music, true);

        //GIF Image: Eevee_Evolve
        ImageView imageview = findViewById(R.id.eevee_evolve);

        Glide.with(this)
                .asGif()
                .load(R.raw.eevee_evolve)
                .into(imageview);

        //Eevee evolution
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Random r = new Random();
                int choice = r.nextInt(8);

                Intent intent = null;

                switch (choice){


                    case 0:
                        intent = new Intent(Eevee_Evolve.this, Sylveon.class);
                        break;

                    case 1:
                        intent = new Intent(Eevee_Evolve.this, Umbreon.class);
                        break;



                    case 2:
                        intent = new Intent(Eevee_Evolve.this, Espeon.class);
                        break;



                    case 3:
                        intent = new Intent(Eevee_Evolve.this, Leafeon.class);
                        break;

                    case 4:
                        intent = new Intent(Eevee_Evolve.this, Glaceon.class);
                        break;

                    case 5:
                        intent = new Intent(Eevee_Evolve.this, Vaporeon.class);
                        break;

                    case 6:
                        intent = new Intent(Eevee_Evolve.this, Flareon.class);
                        break;

                    case 7:
                        intent = new Intent(Eevee_Evolve.this, Jolteon.class);
                        break;



                }
                if(intent != null) {
                    startActivity(intent);
                    finish();
                }
            }
        }, 5500);
    }

    //Music Control
    @Override
    protected void onPause() {
        super.onPause();
        backgroundMusic.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundMusic.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backgroundMusic.stop();
    }
}