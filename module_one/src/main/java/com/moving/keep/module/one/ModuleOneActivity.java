package com.moving.keep.module.one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.moving.keep.baselib.RouterPath;

@Route(path=RouterPath.MODULE_ONE)
public class ModuleOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_one);
    }
}
