package com.aby.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    TextView scoreText;
    TextView timeText;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    ImageView[] imageViews;

    Handler handler;
    Runnable runnable;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageViews = new ImageView[] {imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        score = 0;

        hideImages();

        new CountDownTimer(10000, 1000) // 10 saniye geriye dogru saysin
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                timeText.setText("Time: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish()
            {
                timeText.setText("Time's up!");
                handler.removeCallbacks(runnable);

                for (ImageView image : imageViews) //imageViews[] icindeki tum imagelari gezen for loop
                {
                    image.setVisibility(View.INVISIBLE); // hepsini gorunmez yaptik
                }

                // play again kismi
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Want to play again?");

                alert.setPositiveButton("YES", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // restart
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                        // burasi genelde kullanilmayan bi kod snippet
                    }
                });

                alert.setNegativeButton("NO", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                        System.exit(0);
                    }
                });

                alert.setCancelable(false); // ekranda baska bir yere tiklanirsa mesaj kutusu gitmeyecek
                alert.show();
            }
        }.start();
    }

    public void increaseScore(View view)
    {
        score++;
        scoreText.setText("Score: " + score);
    }

    public void hideImages()
    {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageViews) //imageViews[] icindeki tum imagelari gezen for loop
                {
                    image.setVisibility(View.INVISIBLE); // hepsini gorunmez yaptik
                }

                Random random = new Random(); // image arrayinin icinden rastgele bir image'i visible yapmak icin random modulu kullandik
                int index = random.nextInt(9); // index 0 ile 8 arasi
                imageViews[index].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 300); // bu işlemi yarim saniyede bir tekrarla dedik
            }
        };
        handler.post(runnable);
    }
}