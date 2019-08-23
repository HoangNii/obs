package com.hoangit.obs;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(!checkForPermission(this)){
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }else {
            check();
        }

    }

    private void check() {
        UsageStatsManager usageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        UsageEvents events = usageStatsManager.queryEvents(System.currentTimeMillis()-3600000,System.currentTimeMillis());
        StringBuilder builder = new StringBuilder();
        ArrayList<UsageEvents.Event> es = new ArrayList<>();
        while (events.hasNextEvent()){
            UsageEvents.Event event = new UsageEvents.Event();
            events.getNextEvent(event);
            es.add(event);
        }
        Collections.reverse(es);
        for (UsageEvents.Event event:es){
            builder.append("Package Name:")
                    .append(event.getPackageName())
                    .append("\n")
                    .append("App Name:")
                    .append(getAppNameFromPkgName(this,event.getPackageName()))
                    .append("\n")
                    .append("Event Type:")
                    .append(event.getEventType())
                    .append("\n")
                    .append("Date:")
                    .append(new Date(event.getTimeStamp()).toString());
            builder.append("\n-------------\n");
        }
        ((TextView)findViewById(R.id.tv_test)).setText(builder.toString());

    }

    public static String getAppNameFromPkgName(Context context, String packAgeName) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo info = packageManager.getApplicationInfo(packAgeName, PackageManager.GET_META_DATA);
            return (String) packageManager.getApplicationLabel(info);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return packAgeName;
        }
    }

    private Boolean checkForPermission(Context context){
        AppOpsManager appOps = (AppOpsManager) context
                .getSystemService(Context.APP_OPS_SERVICE);
        int mode = 0;
        if (appOps != null) {
            mode = appOps.unsafeCheckOpRaw(AppOpsManager.OPSTR_GET_USAGE_STATS,
                    android.os.Process.myUid(), context.getPackageName());
        }
        return mode == AppOpsManager.MODE_ALLOWED;
    }

}
