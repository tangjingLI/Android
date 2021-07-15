package com.example.homework3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public class TimeView extends View {

    private Paint mPaint;
    /**
     * 描边线的粗细
     */
    private int strokeWidth = 7;
    private Handler mHandler;
    private Runnable clockRunnable;


    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mHandler = new Handler();
        clockRunnable = new Runnable() {//里面做的事情就是每隔一秒，刷新一次界面
            @Override
            public void run() {
                //线程中刷新界面
                postInvalidate();
                mHandler.postDelayed(this, 1000);
            }
        };
                mHandler.postDelayed(clockRunnable, 1000);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //在这里是无需重载的，但是如果自定义的是一个ViewGroup，那么可能就需要重载这里，可以参考ViewPager的实现
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("Time", "onDraw");
        super.onDraw(canvas);
        drawTime(canvas);
    }

    private void drawTime(Canvas canvas) {
        mPaint.setColor(Color.rgb(132, 153, 215));
        mPaint.setTextSize(150);
        mPaint.setStrokeWidth(8);
        mPaint.setTextAlign(Paint.Align.CENTER);
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String h, m, s;
        if (hour < 10)
            h = "0" + hour + " : ";
        else
            h = hour + " : ";
        if (min < 10)
            m = "0" + min + " : ";
        else
            m = min + " : ";
        if (second < 10)
            s = "0" + second;
        else
            s = second + "";
        canvas.drawText(h + m + s, getWidth() / 2, getHeight() / 2, mPaint);
    }
}

