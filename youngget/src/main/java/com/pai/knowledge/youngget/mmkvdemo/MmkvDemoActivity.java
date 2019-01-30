package com.pai.knowledge.youngget.mmkvdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.getkeepsafe.relinker.ReLinker;
import com.pai.knowledge.youngget.R;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;


public class MmkvDemoActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmkv_demo);
        String dir = getFilesDir().getAbsolutePath() + "/mmkv_2";
        String rootDir = MMKV.initialize(dir, new MMKV.LibLoader() {
            @Override
            public void loadLibrary(String libName) {
                ReLinker.loadLibrary(MmkvDemoActivity.this, libName);
            }
        });
        Log.i("MMKV", "mmkv root: " + rootDir);

        MMKV.setLogLevel(MMKVLogLevel.LevelInfo);
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(rootDir);

        Button button = findViewById(R.id.button_read_string);
        button.setOnClickListener(new View.OnClickListener() {
            final Baseline baseline = new Baseline(getApplicationContext(), 1000);

            public void onClick(View v) {
                baseline.mmkvBaselineTest();
                baseline.sharedPreferencesBaselineTest();
                baseline.sqliteBaselineTest();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MMKV.onExit();
    }

}
