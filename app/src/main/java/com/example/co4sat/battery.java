package com.example.co4sat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class battery extends AppCompatActivity {

    private TextView textView;
    private Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        textView = findViewById(R.id.battery_result);

        ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        BroadcastReceiver broadcastReceiverBattery = new BroadcastReceiver() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onReceive(Context context, Intent intent) {
                int integerBatteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                textView.setText(Integer.toString(integerBatteryLevel));
                if (integerBatteryLevel > 25) {
                    ringtone.play();
                }
            }
        };
        registerReceiver(broadcastReceiverBattery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    public void stopButton(View view) {
        ringtone.stop();
    }
}