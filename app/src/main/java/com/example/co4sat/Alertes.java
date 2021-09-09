package com.example.co4sat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
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

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(imageDisplaying) {
                    img.setImageResource(R.drawable.red);
                    imageDisplaying =  false;
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(1000);
                    //code
                }
                if(imageDisplaying) {
                    img.setImageResource(R.drawable.orange);
                    imageDisplaying = true;
                    //code
                }
                if(imageDisplaying){
                    img.setImageResource(R.drawable.green);
                    imageDisplaying = true;
                }

                return false;
            }
        });
    }
}