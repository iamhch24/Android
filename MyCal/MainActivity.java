package com.example.MyCal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText number1;
    private EditText number2;
    private TextView text_result;

    private String number1_str;
    private String number2_str;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.number1 = (EditText) this.findViewById(R.id.number1);
        this.number2 = (EditText) this.findViewById(R.id.number2);
        Button digit0 = (Button) this.findViewById(R.id.digit0);
        Button digit1 = (Button) this.findViewById(R.id.digit1);
        Button digit2 = (Button) this.findViewById(R.id.digit2);
        Button digit3 = (Button) this.findViewById(R.id.digit3);
        Button digit4 = (Button) this.findViewById(R.id.digit4);
        Button digit5 = (Button) this.findViewById(R.id.digit5);
        Button digit6 = (Button) this.findViewById(R.id.digit6);
        Button digit7 = (Button) this.findViewById(R.id.digit7);
        Button digit8 = (Button) this.findViewById(R.id.digit8);
        Button digit9 = (Button) this.findViewById(R.id.digit9);

        Button btn_add = (Button) this.findViewById(R.id.btn_add);
        Button btn_sub = (Button) this.findViewById(R.id.btn_sub);
        Button btn_mul = (Button) this.findViewById(R.id.btn_mul);
        Button btn_div = (Button) this.findViewById(R.id.btn_div);

        this.text_result = (TextView) this.findViewById(R.id.text_result);

        digit0.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '0';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '0';
                number2.setText(number2_str);
            }
        });

        digit1.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '1';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '1';
                number2.setText(number2_str);
            }
        });

        digit2.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '2';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '2';
                number2.setText(number2_str);
            }
        });

        digit3.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '3';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '3';
                number2.setText(number2_str);
            }
        });

        digit4.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '4';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '4';
                number2.setText(number2_str);
            }
        });

        digit5.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '5';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '5';
                number2.setText(number2_str);
            }
        });

        digit6.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '6';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '6';
                number2.setText(number2_str);
            }
        });

        digit7.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '7';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '7';
                number2.setText(number2_str);
            }
        });

        digit8.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '8';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '8';
                number2.setText(number2_str);
            }
        });

        digit9.setOnClickListener(v -> {
            if(number1.isFocused()){
                number1_str = number1.getText().toString();
                number1_str += '9';
                number1.setText(number1_str);
            }else if(number2.isFocused()){
                number2_str = number2.getText().toString();
                number2_str += '9';
                number2.setText(number2_str);
            }
        });


        btn_add.setOnClickListener(v -> {
            String str1 = number1.getText().toString();
            String str2 = number2.getText().toString();
            Integer val1 = Integer.valueOf(str1);
            Integer val2 = Integer.valueOf(str2);
            Integer val_result = val1 + val2;
            this.text_result.setText(val_result.toString());

        });

        btn_sub.setOnClickListener(v -> {
            String str1 = number1.getText().toString();
            String str2 = number2.getText().toString();
            Integer val1 = Integer.valueOf(str1);
            Integer val2 = Integer.valueOf(str2);
            Integer val_result = val1 - val2;
            this.text_result.setText(val_result.toString());

        });

        btn_mul.setOnClickListener(v -> {
            String str1 = number1.getText().toString();
            String str2 = number2.getText().toString();
            Integer val1 = Integer.valueOf(str1);
            Integer val2 = Integer.valueOf(str2);
            Integer val_result = val1 * val2;
            this.text_result.setText(val_result.toString());

        });

        btn_div.setOnClickListener(v -> {
            String str1 = number1.getText().toString();
            String str2 = number2.getText().toString();
            Integer val1 = Integer.valueOf(str1);
            Integer val2 = Integer.valueOf(str2);
            Integer val_result = val1 / val2;
            this.text_result.setText(val_result.toString());

        });

    }
}