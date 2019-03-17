package com.pai.knowledge.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.pai.knowledge.common.base.ViewManager;
import com.pai.knowledge.common.utils.ToastUtils;
import com.pai.knowledge.common.utils.Utils;
import com.pai.knowledge.main.view.MyView;
import com.pai.knowledge.main.view.ViewTwo;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewManager.getInstance().addActivity(this);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        MyView view_one = (MyView) findViewById(R.id.view_one);
        ViewTwo view_two = (ViewTwo) findViewById(R.id.view_two);
        view_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLongToast("OnClickListener view_one");

            }
        });
        view_one.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToastUtils.showLongToast("OnLongClickListener view_one");
                return false;
            }
        });
        view_two.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToastUtils.showLongToast("OnLongClickListener view_two");
                return false;
            }
        });
        view_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLongToast("OnClickListener view_two");

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
