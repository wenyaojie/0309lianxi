package com.example.asus.a0309lianxi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by asus on 2017/3/9.
 */

public class zidingyi extends View{

    private Paint paint= new Paint();
    private MyTheard mytherd;
    public zidingyi(Context context) {
        super(context);
    }

    public zidingyi(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        paint.setTextSize(30);
//        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0,30,150,180,paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("周考",0,90,paint);

        if(mytherd == null){
            mytherd=new MyTheard();
            mytherd.start();

        }

    }
    class MyTheard extends Thread{
        Random random=new Random();
        @Override
        public void run() {
            while(true){
                int r=random.nextInt(256);
                int g=random.nextInt(256);
                int b=random.nextInt(256);
                paint.setARGB(255,r,g,b);
                postInvalidate();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
