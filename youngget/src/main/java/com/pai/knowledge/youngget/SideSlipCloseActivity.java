package com.pai.knowledge.youngget;


import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.pai.knowledge.common.base.BaseActivity;

/**
 * @author liuzhao by 2019/1/22  16:59
 * @description 侧滑关闭页面
 */
@Route(path = "/youngget/SideSlipCloseActivity")
public class SideSlipCloseActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_slip_close);
        SwipeBackLayout swipeBackLayout = findViewById(R.id.swipe_back);
        swipeBackLayout.setCallBack(new SwipeBackLayout.CallBack() {
            @Override
            public void onFinish() {
                finish();
            }
        });
    }
}
