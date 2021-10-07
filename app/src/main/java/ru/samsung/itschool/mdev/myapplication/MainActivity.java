package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doPlay(View v) {
        switch(v.getId()) {
            case R.id.start:
                if(mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.canon);
                    mediaPlayer.start();
                } else {
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                    } else {
                        mediaPlayer.start();
                    }
                }
                break;
            case R.id.stop:
                mediaPlayer.stop();
                mediaPlayer.release(); // очистка памяти
                mediaPlayer = null;
                break;
        }
    }
}