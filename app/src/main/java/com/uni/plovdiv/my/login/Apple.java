package com.uni.plovdiv.my.login;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.Random;

public class Apple {
    private Point positionofApple = new Point();
    private Bitmap appleBitmap;
    private int BLOCK_SIZE;
    private int NUM_BLOCK_WIDE;
    private int NUM_BLOCK_HIGH;
    Apple(Context context, int NUM_BLOCK_HIGH, int NUM_BLOCK_WIDE, int BLOCK_SIZE){
        this.BLOCK_SIZE = BLOCK_SIZE;
        this.NUM_BLOCK_HIGH = NUM_BLOCK_HIGH;
        this.NUM_BLOCK_WIDE = NUM_BLOCK_WIDE;

        appleBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);
        appleBitmap = Bitmap.createScaledBitmap(appleBitmap,BLOCK_SIZE,BLOCK_SIZE,true);


    }

    void setApplePosition(){
        Random random = new Random();
        positionofApple.x = random.nextInt(NUM_BLOCK_WIDE);
        positionofApple.y = random.nextInt(NUM_BLOCK_HIGH);
    }

    public Point getPositionofApple() {
        return positionofApple;
    }
    void drawApple(Canvas canvas, Paint paint){
        canvas.drawBitmap(appleBitmap,positionofApple.x*BLOCK_SIZE,
                positionofApple.y*BLOCK_SIZE,paint);
    }
}