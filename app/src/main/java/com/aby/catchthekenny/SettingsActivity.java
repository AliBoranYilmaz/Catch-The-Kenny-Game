package com.aby.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity
{
    Switch soundButton;
    Switch notificationButton;
    Switch vibrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        soundButton = findViewById(R.id.soundButton);
        soundButton.setChecked(true); // default olarak acik geliyor

        vibrationButton = findViewById(R.id.vibrationButton);
        vibrationButton.setChecked(true);

        notificationButton = findViewById(R.id.notificationButton);
        notificationButton.setChecked(true);
    }

    public void howToPlay(View view)
    {
        Intent intent = new Intent(SettingsActivity.this, HowTo.class);
        startActivity(intent);
    }

}