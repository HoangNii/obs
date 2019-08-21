package com.hoangit.obt;

import android.app.Application;
import com.hoangit.obt.crashScreen.crashs.CrashConfig;

public class ObApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashConfig.Builder.create();
    }
}
