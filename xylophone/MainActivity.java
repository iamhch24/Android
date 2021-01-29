package com.example.xylophone;

import androidx.appcompat.app.AppCompatActivity;


import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;

    public MainActivity() {
        this.soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Pair<Integer,Integer>> sounds = new ArrayList<>();
        sounds.add(new Pair<Integer,Integer>(R.id.do1, R.raw.do1));
        sounds.add(new Pair<Integer,Integer>(R.id.do2, R.raw.do2));
        sounds.add(new Pair<Integer,Integer>(R.id.re, R.raw.re));
        sounds.add(new Pair<Integer,Integer>(R.id.mi, R.raw.mi));
        sounds.add(new Pair<Integer,Integer>(R.id.fa, R.raw.fa));
        sounds.add(new Pair<Integer,Integer>(R.id.sol, R.raw.sol));
        sounds.add(new Pair<Integer,Integer>(R.id.la, R.raw.la));
        sounds.add(new Pair<Integer,Integer>(R.id.ti, R.raw.ti));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            sounds.forEach(this::tune);
        }
    }
    private void tune(Pair<Integer,Integer> pitch){
        Integer soundId = soundPool.load(this, pitch.second, 1);
        this.findViewById(pitch.first).setOnClickListener(view->{
            soundPool.play(soundId, 1.0f, 1.0f, 0,0,1.0f);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.soundPool.release();
    }
}