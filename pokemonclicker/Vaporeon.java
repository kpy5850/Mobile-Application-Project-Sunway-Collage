package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

public class Vaporeon extends AppCompatActivity {

    BackgroundMusic backgroundMusic;
    private ProgressBar progressBar;
    int CurrentProgressBar = 0;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaporeon);

        //Music
        backgroundMusic = new BackgroundMusic();
        backgroundMusic.start(this, R.raw.vaporeon_music, true);

        //Setting_Window
        Button setting = (Button) findViewById(R.id.Setting);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vaporeon.this, Pop_Setting.class);
                startActivityForResult(intent, 1);
            }
        });

        //GIF Image: Bubble
        ImageView imageview = findViewById(R.id.Bubble);

        Glide.with(this)
                .asGif()
                .load(R.raw.bubble_up)
                .into(imageview);

        ImageView imageview2 = findViewById(R.id.Vaporeon);

        Glide.with(this)
                .asGif()
                .load(R.raw.vaporeon)
                .into(imageview2);

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
                    Intent intent = new Intent(Vaporeon.this, Complete_Window.class);
                    startActivityForResult(intent, 2);
                }
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


    //Reset Result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Reset progressbar in reset button
        if (requestCode == 1 && resultCode == RESULT_OK) {
            boolean shouldReset = data.getBooleanExtra("reset", false);
            if (shouldReset) {
                CurrentProgressBar = 0;
                progressBar.setProgress(0);
            }
        }

        //Close the activity after reset
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            String action = data.getStringExtra("action");
            if ("reset".equals(action)) {
                Intent intent = new Intent(Vaporeon.this, Eevee.class);
                startActivity(intent);
                finish();
            }
            else if ("close".equals(action)) {
                finish();
            }
        }
    }
}
