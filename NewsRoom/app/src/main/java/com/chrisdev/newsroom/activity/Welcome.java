package com.chrisdev.newsroom.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.chrisdev.newsroom.R;

public class Welcome extends Activity {
    MediaPlayer song = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        song = MediaPlayer.create(Welcome.this,R.raw.cantbebroken);
//        song.start();

        Thread timer = new Thread() {
            public void run() {
                int SLEEP_TIME= 3000;

                try {
                    sleep(SLEEP_TIME);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openLoginActivity= new Intent("com.chrisdev.newsroom.activity.LOGIN");
                    startActivity(openLoginActivity);

                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        song.release();
        finish();
    }
}
