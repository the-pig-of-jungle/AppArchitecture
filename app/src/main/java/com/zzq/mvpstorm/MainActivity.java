package com.zzq.mvpstorm;

import android.Manifest;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.mvp.XFragment;

public class MainActivity extends AppCompatActivity {
    private SMSObserver smsObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsObserver = new SMSObserver(new Handler(),this);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_SMS},1000);
        Uri uri = Uri.parse("content://sms/");
        getContentResolver().registerContentObserver(uri,true,smsObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(smsObserver);
    }
}
