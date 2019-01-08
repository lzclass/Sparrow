package com.moving.keep.sparrow;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.LOG_DEBUG) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
