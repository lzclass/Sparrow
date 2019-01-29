package com.pai.knowledge.common.base;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.pai.knowledge.common.utils.Utils;

import java.util.List;

/**
 * description  要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 *  组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 *  组件的Application需置于java/debug文件夹中，不得放于主代码；
 *  组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * author liuzhao by 2019/1/29  17:28
 */
public class BaseApplication extends Application {

    public static final String ROOT_PACKAGE = "com.guiying.module";

    private static BaseApplication sInstance;

    private List<IApplicationDelegate> mAppDelegateList;


    public static BaseApplication getIns() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Logger.init("myapp").logLevel(LogLevel.FULL);
        Utils.init(this);
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, ROOT_PACKAGE);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
