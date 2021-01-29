package com.example.simpledb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private UserDBHelper userDBHelper;
    private SQLiteDatabase sqldb;
    private EditText editText_Name, editText_Numbers, editText_View_Name, editText_View_Numbers;
    private Button button_init, button_input, button_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.userDBHelper = new UserDBHelper(this, "SimpleDB", null, 1);
        this.editText_Name = findViewById(R.id.editText_Name);
        this.editText_Numbers = findViewById(R.id.editText_Numbers);
        this.editText_View_Name = findViewById(R.id.editText_View_Name);
        this.editText_View_Numbers = findViewById(R.id.editText_View_Numbers);
        button_init = findViewById(R.id.button_init);
        button_input = findViewById(R.id.button_input);
        button_search = findViewById(R.id.button_search);
        editText_View_Name.setClickable(false);
        editText_View_Numbers.setClickable(false);
        button_init.setOnClickListener(view->{
            sqldb = userDBHelper.getWritableDatabase();
            userDBHelper.onUpgrade(sqldb,1,2);
            Toast.makeText(this, "초기화", Toast.LENGTH_LONG).show();
            sqldb.close();
        });
        button_input.setOnClickListener(view->{
            sqldb = userDBHelper.getWritableDatabase();  // DB 쓰기
            sqldb.execSQL("INSERT INTO GroupTable VALUES ('" + editText_Name.getText().toString()+"',"+ editText_Numbers.getText().toString()+ ");");
            Toast.makeText(this, "입력이 잘 되었습니다.", Toast.LENGTH_LONG).show();
            sqldb.close();
        });
        button_search.setOnClickListener(view->{
            sqldb = userDBHelper.getReadableDatabase();  // DB 읽기
            Cursor cursor = sqldb.rawQuery("SELECT * FROM GroupTable;", null);
            String str_Names = "이름 : \r\n ============= \r\n";
            String str_Numbers = "인원 : \r\n ============= \r\n";
            while(cursor.moveToNext()){
                str_Names += cursor.getString(0)+"\r\n";
                str_Numbers += cursor.getString(1)+"\r\n";
            }
            editText_View_Name.setText(str_Names);
            editText_View_Numbers.setText(str_Numbers);
            cursor.close();
            sqldb.close();
        });



    }

    class UserDBHelper extends SQLiteOpenHelper{

        public UserDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version); // 기본적인 생성자 필요함
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE GroupTable(Group_Name CHAR(20) PRIMARY KEY, Group_Number INTEGER);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS GroupTable");
            this.onCreate(db);

        }
    }
}