package com.pai.knowledge.youngget.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;
import com.pai.knowledge.youngget.IStudyService;

/**
 * Description:
 * Date: Created by liuzhao on 2019/2/1 17:02
 */
public class TestAidlService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    private int printResult(String aString){
        Logger.d(aString);
        return 1;
    }

    private class MyBinder extends IStudyService.Stub {

        @Override
        public int basicTypes(String aString) throws RemoteException {

            return printResult(aString);
        }
    }
}
