package com.example.sksmswndlsdlek.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();

    public MyView(Context context) {
        super(context);

       paint.setStrokeWidth(15f);
       paint.setColor(Color.BLUE);
       paint.setStyle(Paint.Style.STROKE);
       paint.setStrokeJoin(Paint.Join.ROUND);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}