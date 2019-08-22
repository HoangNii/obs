package com.hoangit.obs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hoangit.obt.crashScreen.CrashActivity;
import com.hoangit.obt.permissions.PermissionEnum;
import com.hoangit.obt.permissions.PermissionManager;
import com.hoangit.obt.permissions.SimpleCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
