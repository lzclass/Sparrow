package com.pai.knowledge.main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.pai.knowledge.common.base.BaseActivity;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:多线程学习
 * Date: Created by liuzhao on 2019/3/19 16:43
 */
public class MultiThreadActivity extends BaseActivity {
    private String TAG = MultiThreadActivity.class.getSimpleName();
    private StringBuffer stringBuffer = new StringBuffer();
    private Button btn_start;
    public TextView txt_log;
    public final Handler handler = new MyHandler(MultiThreadActivity.this);

    private final static class MyHandler extends Handler {
        private WeakReference<MultiThreadActivity> mWeakReference;

        public MyHandler(MultiThreadActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MultiThreadActivity multiThreadActivity = mWeakReference.get();
            multiThreadActivity.txt_log.setText(msg.obj + "");
        }

        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
        }

        @Override
        public String getMessageName(Message message) {
            return super.getMessageName(message);
        }

        @Override
        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            return super.sendMessageAtTime(msg, uptimeMillis);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_multi_thread);
        btn_start = findViewById(R.id.btn_start);
        txt_log = findViewById(R.id.txt_log);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createThreadPoolExecutor();
            }
        });
    }

    private void createThreadPoolExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    stringBuffer.append(Thread.currentThread().getName() + "\n");
                    Logger.d(TAG, Thread.currentThread().getName() + "");
                    Message message = handler.obtainMessage();
                    message.obj = stringBuffer;
                    handler.sendMessage(message);
                }
            });
        }
        executorService.shutdown();
    }
}
