package com.example.slidegame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.View;
import android.widget.Toast;

public class SlideView extends View {
    private Paint greenPaint, blackPaint;
    private float center_x, center_y, x_coord, y_coord;

    public SlideView(Context context) {
        super(context);
        this.greenPaint = new Paint();
        this.blackPaint = new Paint();
        this.greenPaint.setColor(Color.GREEN);
        this.blackPaint.setColor(Color.BLACK);
        this.center_x = 0;
        this.center_y = 0;
        this.x_coord = 0;
        this.y_coord = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.center_x = this.getWidth() /2;
        this.center_y = this.getHeight() /2;

        // 검은색 원을 그린다
        canvas.drawCircle(center_x,center_y,100.0f, blackPaint);
        // 녹색 원을 그린다
        canvas.drawCircle(center_x,center_y,100.0f, greenPaint);
        // 십자선을 하나 그린다
        canvas.drawLine(center_x-20.0f, center_y, center_x+20.0f, center_y, blackPaint);
        canvas.drawLine(center_x, center_y-20.0f, center_x, center_y+20.0f, blackPaint);

        canvas.drawCircle(center_x,center_y,100.0f, blackPaint);
        canvas.drawCircle(x_coord +center_x,y_coord + center_y,100.0f, greenPaint);
        canvas.drawLine(center_x-20.0f, center_y, center_x+20.0f, center_y, blackPaint);
        canvas.drawLine(center_x, center_y-20.0f, center_x, center_y+20.0f, blackPaint);

    }

    public void onSensorEvent(SensorEvent event){
        this.x_coord = event.values[0]*20; // x 축 값
        this.y_coord = event.values[1]*20;  // y 축 값
        this.invalidate();      // 화면 갱신 -- 에니메이션 효과를 줄 때 꼭 사용
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) { // 화면이 바뀔 때 마다 호출됨
        super.onSizeChanged(w, h, oldw, oldh);
        this.center_x = w / 2.0f;
        this.center_y = h / 2.0f;
    }
}
