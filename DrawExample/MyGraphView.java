package com.example.drawexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyGraphView extends View {

    public MyGraphView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);

//        canvas.drawLine(10,10,300,10,paint);
//        paint.setStrokeWidth(10);
//        canvas.drawLine(30,30,500,30,paint);
//        paint.setColor(Color.RED);
//        canvas.drawLine(60,60,500,60,paint);
//        paint.setColor(Color.GRAY);
//        Rect rect = new Rect(10,50,110,150);
//        canvas.drawRect(rect,paint);
//        paint.setColor(Color.CYAN);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(100,100,50,paint);
        paint.setStrokeWidth(1);
        paint.setTextSize(20.0f);
        canvas.drawText("일본 올림픽 열어봐라",150.0f, 300.0f,paint);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100,100,50,paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(220,100,50,paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(340,100,50,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(160,160,50,paint);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(280,160,50,paint);

    }
}
