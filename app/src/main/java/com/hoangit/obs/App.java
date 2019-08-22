package com.hoangit.obs;

import com.hoangit.obt.ObApp;
import com.hoangit.obt.ObConfig;

public class App extends ObApp {
    @Override
    public void onCreate() {
        super.onCreate();

        ObConfig.get().setAppIdCrashScreenRestart(this,getPackageName());
        ObConfig.get().setIconCrashScreen(this,R.mipmap.ic_launcher);
    }
}
