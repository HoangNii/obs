package com.hoangit.obt;

import android.content.Context;
import android.content.SharedPreferences;

public class ObConfig {

    private static final String SHARED_PREFERENCES_NAME = ObConfig.class.getSimpleName();

    private static ObConfig obConfig;

    public static ObConfig get() {
        if(obConfig==null)
            obConfig = new ObConfig();
        return obConfig;
    }

    public void setIconCrashScreen(Context ctx,int i){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        preferences.edit().putInt("icon",i).apply();
    }
    public int getIconCrashScreen(Context ctx){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.getInt("icon",-1);
    }

    public void setTextCrashScreen(Context ctx,String i){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString("text",i).apply();
    }
    public String getTextCrashScreen(Context ctx){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.getString("text","Opps...Đại vương! \nCó chuyện không hay xảy ra rồi!");
    }

    public void setTextButtonCrashScreen(Context ctx,String i){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString("text_button",i).apply();
    }
    public String getTextButtonCrashScreen(Context ctx){
        SharedPreferences preferences = ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.getString("text_button","Khởi động lại");
    }
}
