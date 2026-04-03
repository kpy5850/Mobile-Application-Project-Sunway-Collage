package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer Loading_Screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GIF Image: Loading page
        ImageView imageview = findViewById(R.id.load);

        Glide.with(this)
                .asGif()
                .load(R.raw.loading)
                .into(imageview);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Clicker.class));
                finish();
            }

        };
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}