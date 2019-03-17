package com.pai.knowledge.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.orhanobut.logger.Logger;

public class MyView extends android.support.v7.widget.AppCompatTextView {
    private final static String TAG = MyView.class.getSimpleName();
    ;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Logger.d(TAG + "dispatchTouchEvent...", event.getAction() + "");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "MotionEvent.ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "MotionEvent.ACTION_UP...");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "MotionEvent.ACTION_MOVE...");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d(TAG + "onTouchEvent...", event.getAction() + "");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "MotionEvent.ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "MotionEvent.ACTION_UP...");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "MotionEvent.ACTION_MOVE...");
                break;
        }
        return super.onTouchEvent(event);
    }

}
