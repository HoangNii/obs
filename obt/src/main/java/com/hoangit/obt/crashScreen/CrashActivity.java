package com.hoangit.obt.crashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.hoangit.obt.ObConfig;
import com.hoangit.obt.R;
import com.hoangit.obt.crashScreen.views.DesertPlaceholder;

public class CrashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_activty);

        DesertPlaceholder desertPlaceholder = findViewById(R.id.placeholder);
        desertPlaceholder.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(ObConfig.get().getAppIdCrashScreenRestart(CrashActivity.this));
                if (launchIntent != null) {
                    startActivity(launchIntent);
                }
            }
        });
    }
}
