package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Switch music_player;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.music_player = findViewById(R.id.switch1);
        this.mediaPlayer = MediaPlayer.create(this,R.raw.file_example_mp3_700kb);
        this.music_player.setOnClickListener( v -> {
            if(music_player.isChecked()) {
                mediaPlayer.start();
            }else{
                mediaPlayer.pause();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mediaPlayer.release();

    }
}