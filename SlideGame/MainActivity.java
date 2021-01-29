package com.example.slidegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private SlideView slideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 가로 모드 고정하기
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 가로로 됨
//        setContentView(R.layout.activity_main);
//        this.sensorManager.getDefaultSensor(SensorManager.SENSOR_DELAY_FASTEST);
        this.slideView = new SlideView(this);
        setContentView(slideView);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        this.slideView.onSensorEvent(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}