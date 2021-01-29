package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button button_return = findViewById(R.id.button_return);
        button_return.setOnClickListener(v->{
//            Toast.makeText(this,"리턴", Toast.LENGTH_LONG).show();
            this.finish();
        });
        Double height = Double.valueOf(this.getIntent().getStringExtra("height"));
        Double weight = Double.valueOf(this.getIntent().getStringExtra("weight"));

        double BMI = weight / Math.pow(height/100, 2);
//        Toast.makeText(this,String.valueOf(BMI),Toast.LENGTH_LONG).show();
        TextView textView_result = findViewById(R.id.textView_result);
        ImageView imageView = findViewById(R.id.imageView);
        if (BMI >= 35.0){
            textView_result.setText("고도 비만");
            imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
            imageView.setColorFilter(Color.parseColor("#55ff0000"));
        }else if (BMI >= 30.0){
            textView_result.setText("2단계 비만");
            imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24);
            imageView.setColorFilter(Color.parseColor("#55ff0000"));
        }else if (BMI >= 25.0){
            textView_result.setText("1단계 비만");
            imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24);
            imageView.setColorFilter(Color.parseColor("#55ff0000"));
        }else if (BMI >= 23.0){
            textView_result.setText("과체중");
            imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24);
//            imageView.setColorFilter(Color.parseColor("#55ff0000"));
        }else if (BMI >= 18.0){
            textView_result.setText("정상");
            imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_24);
//            imageView.setColorFilter(Color.parseColor("#FF8BC34A"));
        }else {
            textView_result.setText("저체중");
            imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24);
//            imageView.setColorFilter(Color.parseColor("#55ff0000"));
        }
    }
}