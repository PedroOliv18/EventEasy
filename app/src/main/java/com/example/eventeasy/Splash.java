package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    // Tempo da splash screen
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
            new Handler().postDelayed(new Runnable() {
                /*
                 * Exibindo splash com um timer.
                 */
                @Override
                public void run() {
                    // Esse método será executado sempre que o tempo acabar
                    // E inicia a activity principal
                    Intent i = new Intent(Splash.this,
                            MainActivity.class);
                    startActivity(i);

                    // Fecha esta activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
    }
}
