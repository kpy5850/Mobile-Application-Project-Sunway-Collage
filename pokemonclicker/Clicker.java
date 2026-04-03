package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

public class Clicker extends AppCompatActivity {

    BackgroundMusic backgroundMusic;
    private ProgressBar progressBar;
    int CurrentProgressBar = 0;
    private Button btnClick;


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        //egg_music
        backgroundMusic = new BackgroundMusic();
        backgroundMusic.start(this, R.raw.egg_music, true);

        //Setting_Window
        Button setting = (Button) findViewById(R.id.Setting);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clicker.this, Pop_Setting.class);
                startActivityForResult(intent, 1);
            }
        });

        //GIF Image
        ImageView Egg_GIF = findViewById(R.id.eggs);
        Glide.with(this)
                .asGif()
                .load(R.raw.egg)
                .into(Egg_GIF);

        //Button ID
        btnClick = findViewById(R.id.BtnClick);

        progressBar = findViewById((R.id.Number));

        //Button_Click
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrentProgressBar = CurrentProgressBar + 1;
                progressBar.setProgress(CurrentProgressBar);
                progressBar.setMax(10);

                if(CurrentProgressBar == 10) {
                    startActivity(new Intent(Clicker.this, Evolve.class));
                    finish();
                }
            }
        });
    }

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


    //Reset Result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            boolean shouldReset = data.getBooleanExtra("reset", false);
            if (shouldReset) {
                CurrentProgressBar = 0;
                progressBar.setProgress(0);
            }
        }
    }
}
