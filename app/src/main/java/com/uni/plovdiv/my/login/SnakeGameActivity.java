package com.uni.plovdiv.my.login;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class SnakeGameActivity extends Activity {

    SnakeGameLoop snakeGameLoop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display =getWindowManager().getDefaultDisplay();


        Point size = new Point();


        display.getSize(size);

        snakeGameLoop = new SnakeGameLoop(this, size);

        setContentView(snakeGameLoop);
        Button leaderBoard= new Button (this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 0;
        params.gravity = Gravity.BOTTOM | Gravity.LEFT;

        leaderBoard.setText("Leader Board");
        addContentView(leaderBoard, params);
        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeaderBoardActivity.class);
                startActivity(intent);
            }
        });

        Button logout= new Button (this);
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        params1.topMargin = 0;
        params1.gravity = Gravity.BOTTOM | Gravity.RIGHT;

        logout.setText("LOG OUT");
        addContentView(logout, params1);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause(){
        snakeGameLoop.onPause();
        super.onPause();
    }
    protected void onResume(){
        snakeGameLoop.onResume();
        super.onResume();
    }
}