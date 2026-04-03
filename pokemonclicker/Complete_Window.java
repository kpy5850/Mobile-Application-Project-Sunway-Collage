package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Complete_Window extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_window);

        //complete_window_music
        backgroundMusic = new BackgroundMusic();
        backgroundMusic.start(this, R.raw.complete_window_music, true);

        //toothless_dance GIF
        ImageView imageview = findViewById(R.id.toothless_dance);

        Glide.with(this)
                .asGif()
                .load(R.raw.toothless)
                .into(imageview);

        //button yes(reset)
        Button reset = findViewById(R.id.yes_button);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("action", "reset");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        //button no(close)
        Button close = findViewById(R.id.no_button);
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("action", "close");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
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