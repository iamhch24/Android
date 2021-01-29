package com.example.edittexttest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText_id;
    private EditText editText_pw;
    private Button button_login;
    private Button button_register;
    private List<Member> memberList;    // 회원 등록시 회원 정보(id,pw) 저장할 리스트

    public MainActivity() {
        this.editText_id = null;
        this.editText_pw = null;
        this.button_login = null;
        this.button_register = null;
//        this.user_id = null;
//        this.user_pw = null;
        memberList = new ArrayList<>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText_id = (EditText) this.findViewById(R.id.editText_id);
        this.editText_pw = (EditText) this.findViewById(R.id.editText_pw);
        this.button_login = (Button) this.findViewById(R.id.button_login);
        this.button_register = (Button) this.findViewById(R.id.button_register);

        button_login.setOnClickListener(v -> {
            String str_id = editText_id.getText().toString();
            String str_pw = editText_pw.getText().toString();

            if(str_id.equals("") || str_pw.equals("")) {
                Toast.makeText(this, "ID와 Password 모두 입력되어야 합니다.", Toast.LENGTH_SHORT).show();
//            } else if(str_id.equals(user_id) && str_pw.equals(user_pw)){
//                Toast.makeText(this, user_id+"님 환영합니다.", Toast.LENGTH_SHORT).show();
            } else if (isMember(str_id,str_pw)) {
                Toast.makeText(this, str_id+"님", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "환영합니다.", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "ID와 Password가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        button_register.setOnClickListener(v -> {
            String str_id = editText_id.getText().toString();
            String str_pw = editText_pw.getText().toString();

            if(str_id.equals("") || str_pw.equals("")){ // id, pw 입력 여부 확인
                Toast.makeText(this, "ID와 Password 모두 입력되어야 합니다.", Toast.LENGTH_SHORT).show();
            }else{
//                user_id = editText_id.getText().toString();
//                user_pw = editText_pw.getText().toString();
                if(addMember(str_id, str_pw)){
                    Toast.makeText(this, "ID와 Password가 등록되었습니다.", Toast.LENGTH_SHORT).show();
                }else{ // Member 추가가 실패한 이유 :: ID 중복 --> 중복 메시지
                    Toast.makeText(this, "ID가 중복됩니다. 다른 ID를 넣어주세요", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public boolean addMember(String id, String pw){
        if(memberList.stream().anyMatch(m->m.inMember(id)))     // ID 중복 여부 체크
            return false;
        else {
            memberList.add(new Member(id, pw)); // ID 중복이 없을 때 list에 추가
            return true;
        }
    }
    public boolean isMember(String id, String pw){      // ID와 PW가 모두 맞는지 확인
        return (memberList.stream().anyMatch(m->m.isMember(id,pw)));
    }
}

class Member {
    String id;
    String pw;

    public Member(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public boolean isMember(String id, String pw){
        return id.equals(this.id) && pw.equals(this.pw);
    }

    public boolean inMember(String id){
        return id.equals(this.id);
    }
}