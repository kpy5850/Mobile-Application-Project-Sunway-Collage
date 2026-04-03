package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class Evolve extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolve);

        //complete_window_music
        backgroundMusic = new BackgroundMusic();
        backgroundMusic.start(this, R.raw.evolve_music, true);

        //GIF Image: Egg evolve
        ImageView imageview = findViewById(R.id.egg_evolve);

        Glide.with(this)
                .asGif()
                .load(R.raw.egg_evolve)
                .into(imageview);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Evolve.this, Eevee.class));
                finish();
            }

        };
        Timer opening = new Timer();
        opening.schedule(task, 4900);
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