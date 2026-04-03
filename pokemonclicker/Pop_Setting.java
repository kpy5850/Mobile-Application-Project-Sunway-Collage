package com.example.pokemonclicker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Pop_Setting extends AppCompatActivity {

    SwitchCompat switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popsetting);

        //window setting
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * .9),(int)(height * .8));

        //button reset
        Button reset = (Button) findViewById(R.id.Reset_Button);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pop_Setting.this, Exit_Window.class);
                startActivityForResult(intent, 2);
            }
        });

        //button close
        Button close = (Button) findViewById(R.id.Close_Button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Handle result from Exit_Window
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Close Pop_Setting.java and return result to Clicker.java
        if (requestCode == 2 && resultCode == RESULT_OK) {
            boolean shouldReset = data.getBooleanExtra("reset", false);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("reset", shouldReset);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}
