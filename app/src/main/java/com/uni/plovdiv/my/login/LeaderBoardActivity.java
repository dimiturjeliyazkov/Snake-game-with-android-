package com.uni.plovdiv.my.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LeaderBoardActivity extends AppCompatActivity {

    DBHelper myDB;
    ArrayList<String> username,score;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DBHelper(this);
        username = new ArrayList<>();
        score = new ArrayList<>();
        setContentView(R.layout.activity_leader_board);
        storeDataInArrays();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,username);
        ListView listView = (ListView)findViewById(R.id.window_list);
        listView.setAdapter(adapter);
        backButton = (Button) findViewById(R.id.btnBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SnakeGameActivity.class);
                startActivity(intent);
            }
        });
    }

    void storeDataInArrays (){
        int count = 1;
        Cursor cursor = myDB.readAllData();
        while (cursor.moveToNext()){
             username.add(count++ +". PLAYER NAME: "+cursor.getString(0));
             username.add("HIGH SCORE: "+cursor.getString(1)+"\n");
        }
    }

}