package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v->{
            Intent intent = new Intent(this, ResultActivity.class);
            String height = ((EditText)findViewById(R.id.editText_height)).getText().toString();
            String weight = ((EditText)findViewById(R.id.editText_weight)).getText().toString();
            intent.putExtra("height",height);
            intent.putExtra("weight",weight);
            this.startActivity(intent);
        });
    }
}