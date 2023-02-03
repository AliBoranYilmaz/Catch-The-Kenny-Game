package com.aby.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{
    TextView welcomeText;
    Button startButton;
    Button settingsButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcomeText = findViewById(R.id.welcomeText);
        startButton = findViewById(R.id.startButton);
        settingsButton = findViewById(R.id.settingsButton);
        quitButton = findViewById(R.id.quitButton);
    }

    public void start(View view)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void settings(View view)
    {
        Intent intent = new Intent(MainActivity2.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void quit(View view)
    {
        // code for shutting down the app
        finish();
        System.exit(0);
    }
}