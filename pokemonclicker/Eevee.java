package com.example.pokemonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

public class Eevee extends AppCompatActivity {

    BackgroundMusic backgroundMusic;
    private ProgressBar progressBar;
    int CurrentProgressBar = 0;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eevee);

        //Music
        backgroundMusic = new BackgroundMusic();
        backgroundMusic.start(this, R.raw.eevee_music, true);

        //Setting_Window
        Button setting = (Button) findViewById(R.id.Setting);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eevee.this, Pop_Setting.class);
                startActivityForResult(intent, 1);

            }
        });

        //GIF Image: Eevee
        ImageView imageview = findViewById(R.id.eevee);

        Glide.with(this)
                .asGif()
                .load(R.raw.eevee)
                .into(imageview);

        //Button ID
        btnClick = findViewById(R.id.BtnClick);

        progressBar = findViewById((R.id.Number));

        //Check reset from Complete_Window
        Intent intent = getIntent();
        if(intent != null && intent.getBooleanExtra("reset", false)){
            CurrentProgressBar = 0;
            progressBar.setProgress(0);
        }

        //Button_Click
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrentProgressBar = CurrentProgressBar + 1;
                progressBar.setProgress(CurrentProgressBar);
                progressBar.setMax(15);

                if(CurrentProgressBar == 15) {
                    startActivity(new Intent(Eevee.this, Eevee_Evolve.class));
                    finish();
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


    //Reset Result from Pop_Setting
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