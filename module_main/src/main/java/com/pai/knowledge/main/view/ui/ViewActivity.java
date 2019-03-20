package com.pai.knowledge.main.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import com.pai.knowledge.common.base.ViewManager;
import com.pai.knowledge.common.utils.ToastUtils;
import com.pai.knowledge.main.view.widget.loadingview.LoadingIndicatorView;
import com.pai.knowledge.main.R;
import com.pai.knowledge.main.view.widget.ViewOne;
import com.pai.knowledge.main.view.widget.ViewTwo;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ViewManager.getInstance().addActivity(this);
        ViewOne view_one = (ViewOne) findViewById(R.id.view_one);
        ViewTwo view_two = (ViewTwo) findViewById(R.id.view_two);
        LoadingIndicatorView loading = (LoadingIndicatorView) findViewById(R.id.loading);
        loading.show();
        view_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLongToast("点击按钮1");
                startActivity(new Intent(ViewActivity.this, MultiThreadActivity.class));
            }
        });
        view_one.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToastUtils.showLongToast("长按按钮1");
                return false;
            }
        });
        view_one.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ToastUtils.showLongToast("触摸按钮1");
                return false;
            }
        });
        view_two.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToastUtils.showLongToast("长按按钮2");
                return false;
            }
        });
        view_two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ToastUtils.showLongToast("触摸按钮2");
                return false;
            }
        });
        view_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLongToast("点击按钮2");

            }
        });
    }

    private long mExitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(getString(R.string.app_exit_hint));
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
