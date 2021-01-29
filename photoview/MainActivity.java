package com.example.photoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyPhotoView myphotoview = new MyPhotoView(this);
//        setContentView(R.layout.activity_main);
        setContentView(myphotoview);
    }

    class MyPhotoView extends View {  // 내부 클래스
        public MyPhotoView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //사진설정
            Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.lenna);
            //화면설정 - 이미지크기(폭,높이), 화면의 중앙값(폭,높이),
            int center_x = this.getWidth()/2;
            int center_y = this.getHeight()/2;
            int picture_x = (this.getWidth() - picture.getWidth())/2;
            int picture_y = (this.getHeight() - picture.getHeight())/2;

            // 화면에 보이기
            Paint paint = new Paint();
            paint.setColor(Color.CYAN);
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 사진 회전
//            canvas.rotate(45.0f, center_x, center_y);
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 사진 이동
//            canvas.translate(-100.0f,-100.0f);
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 사진 확대
//            canvas.scale(3.0f,3.0f,center_x,center_y); // 3배 확대
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 사진 축소
//            canvas.scale(0.2f,0.2f,center_x,center_y); // 5배 축소
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 사진의 왜곡
//            canvas.skew(0.1f, 0.1f);
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 사진에 blur 효과 주기  :: inner
//            BlurMaskFilter blurMaskFilter = new BlurMaskFilter(40.0f, BlurMaskFilter.Blur.SOLID);
//            paint.setMaskFilter(blurMaskFilter);
//            canvas.drawBitmap(picture, picture_x, picture_y, paint);

            // 엠보싱 효과
//            EmbossMaskFilter embossMaskFilter = new EmbossMaskFilter(new float[]{10,3,3}, 1.0f, 5.0f, 40.f);
//            paint.setColor(Color.GRAY);
//            paint.setMaskFilter(embossMaskFilter);
//            canvas.drawCircle(center_x, center_y, 200.0f, paint);

            // 이미지 프로세싱 == 보정
            float[] color_array = {  // (R, B, G, alpha, 밝기)
                    3.0f, 0.0f, 0.0f, 0.0f, -50.0f, // R
                    0.0f, 1.0f, 0.0f, 0.0f, 100.0f, // B
                    0.0f, 0.0f, 1.0f, 0.0f, 0.0f, // G
                    0.0f, 0.0f, 0.0f, 1.0f, 0.0f, // alpha 투명도
            };
            ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(color_array);
            paint.setColorFilter(colorMatrixColorFilter);
            canvas.drawBitmap(picture,picture_x, picture_y, paint);



            picture.recycle(); // 메모리 해제




        }
    }
}