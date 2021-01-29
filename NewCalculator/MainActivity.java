package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText number1, number2;
    private Button button_add, button_sub, button_mul, button_div, button_mod;
    private TextView textView_result;
    private List<Button> digits;
    private List<Integer> digitIDs;
    private String num1, num2;
    private Integer count;

    public MainActivity() {
        this.digits = new ArrayList<Button>(11);
        this.digitIDs = new ArrayList<Integer>(11);
        count = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("현충호");
        this.button_add = (Button)this.findViewById(R.id.button_add);
        this.button_sub = (Button)this.findViewById(R.id.button_sub);
        this.button_mul = (Button)this.findViewById(R.id.button_mul);
        this.button_div = (Button)this.findViewById(R.id.button_div);
        this.button_mod = (Button)this.findViewById(R.id.button_mod);
        this.number1 = (EditText)this.findViewById(R.id.number1);
        this.number2 = (EditText)this.findViewById(R.id.number2);
        this.textView_result = (TextView)this.findViewById(R.id.textView_result);

        // 버튼 아이디 등록
        this.digitIDs.add(Integer.valueOf(R.id.button_0));
        this.digitIDs.add(Integer.valueOf(R.id.button_1));
        this.digitIDs.add(Integer.valueOf(R.id.button_2));
        this.digitIDs.add(Integer.valueOf(R.id.button_3));
        this.digitIDs.add(Integer.valueOf(R.id.button_4));
        this.digitIDs.add(Integer.valueOf(R.id.button_5));
        this.digitIDs.add(Integer.valueOf(R.id.button_6));
        this.digitIDs.add(Integer.valueOf(R.id.button_7));
        this.digitIDs.add(Integer.valueOf(R.id.button_8));
        this.digitIDs.add(Integer.valueOf(R.id.button_9));
        this.digitIDs.add(Integer.valueOf(R.id.button_dot));

        // 아이디 값과 버튼을 연결해 주기
        for(int i=0;i<digitIDs.size();i++){
            digits.add((Button)this.findViewById(this.digitIDs.get(i)));
        }

        for(int i=0;i<digits.size();i++){
            final int index = i;
            digits.get(index).setOnClickListener((view)->{
                if(number1.isFocused()){
                    num1 = number1.getText().toString() + digits.get(index).getText().toString();
                    number1.setText(num1);

                }else if(number2.isFocused()){
                    num2 = number2.getText().toString() + digits.get(index).getText().toString();
                    number2.setText(num2);

                }else{
                    Toast.makeText(this,"숫자입력창을 눌러주세요",Toast.LENGTH_LONG).show();

                }
            });
        }

        // 리스너 연결 :: setOnTouchListener
        this.button_add.setOnTouchListener((view,event)->{
            num1 = number1.getText().toString();
            num2 = number2.getText().toString();
            if(num1.equals("") || num2.equals("")){
                Toast.makeText(this, "숫자를 넣어주세요",Toast.LENGTH_LONG).show();
                return false;
            }else{
                Double result = Double.parseDouble(num1)+Double.parseDouble(num2);
                textView_result.setText(result.toString());
//                ++count;
//                Toast.makeText(this, count.toString(),Toast.LENGTH_LONG).show();
                return true;
            }
        });
        this.button_sub.setOnTouchListener((view,event)->{
            num1 = number1.getText().toString();
            num2 = number2.getText().toString();
            if(num1.equals("") || num2.equals("")){
                Toast.makeText(this, "숫자를 넣어주세요",Toast.LENGTH_LONG).show();
                return false;
            }else{
                Double result = Double.parseDouble(num1)-Double.parseDouble(num2);
                textView_result.setText(result.toString());
                return true;
            }
        });
        this.button_mul.setOnTouchListener((view,event)->{
            num1 = number1.getText().toString();
            num2 = number2.getText().toString();
            if(num1.equals("") || num2.equals("")){
                Toast.makeText(this, "숫자를 넣어주세요",Toast.LENGTH_LONG).show();
                return false;
            }else{
                Double result = Double.parseDouble(num1)*Double.parseDouble(num2);
                textView_result.setText(result.toString());
                return true;
            }
        });
        this.button_div.setOnTouchListener((view,event)->{
            num1 = number1.getText().toString();
            num2 = number2.getText().toString();
            if(num1.equals("") || num2.equals("")) {
                Toast.makeText(this, "숫자를 넣어주세요", Toast.LENGTH_LONG).show();
                return false;
            }else if(Double.parseDouble(num2)==0.0){
                Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                return false;
            }else{
                Double result = Double.parseDouble(num1)/Double.parseDouble(num2);
                result = Math.round(result*10000)/10000.0;
                textView_result.setText(result.toString());
                return true;
            }
        });
        this.button_mod.setOnTouchListener((view,event)->{
            num1 = number1.getText().toString();
            num2 = number2.getText().toString();
            if(num1.equals("") || num2.equals("")){
                Toast.makeText(this, "숫자를 넣어주세요",Toast.LENGTH_LONG).show();
                return false;
            }else if(Double.parseDouble(num2)==0.0){
                Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                return false;
            }else{
                Double result = Double.parseDouble(num1) % Double.parseDouble(num2);
                result = Math.round(result*10000)/10000.0;
                textView_result.setText(result.toString());
                return true;
            }
        });



    }
}