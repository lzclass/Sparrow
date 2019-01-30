package debug;


import com.facebook.stetho.Stetho;
import com.pai.knowledge.common.base.BaseApplication;

import okhttp3.OkHttpClient;

public class YoungApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
