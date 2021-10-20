package com.example.co4sat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Alertes extends AppCompatActivity {

    ImageView img;
    boolean imageDisplaying = true;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertes);

        img = findViewById(R.id.img);

        img.setOnTouchListener((v, event) -> {
            if(imageDisplaying) {
                img.setImageResource(R.drawable.red);
                imageDisplaying =  false;
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(2000);

            }
            if(imageDisplaying) {
                img.setImageResource(R.drawable.orange);


            } else{
                img.setImageResource(R.drawable.green);
                imageDisplaying = true;
            }
            return false;
        });
    }
}