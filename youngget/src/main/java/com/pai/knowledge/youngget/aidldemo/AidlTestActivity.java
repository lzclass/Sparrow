package com.pai.knowledge.youngget.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pai.knowledge.common.utils.ToastUtils;
import com.pai.knowledge.youngget.IStudyService;
import com.pai.knowledge.youngget.R;

public class AidlTestActivity extends AppCompatActivity implements View.OnClickListener {
    private MyConn conn;
    private IStudyService studyService;
    private Intent intentService = new Intent();
    final String BOUNDSERVICE_PACKAGE = "com.pai.knowledge.youngget";
    final String BOUNDSERVICE_CLASS = ".aidldemo.TestAidlService";

    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            studyService = IStudyService.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test);
        intentService.setClassName(BOUNDSERVICE_PACKAGE,
                BOUNDSERVICE_PACKAGE + BOUNDSERVICE_CLASS);
        conn = new MyConn();
        bindService(intentService, conn, BIND_AUTO_CREATE);
        findViewById(R.id.btn_test_aidl).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            int result = studyService.basicTypes("123");
            ToastUtils.showLongToast("接收到结果：" + result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
