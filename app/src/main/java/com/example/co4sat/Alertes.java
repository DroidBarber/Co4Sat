package com.example.co4sat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Alertes extends AppCompatActivity {

    Button button_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertes);
        View button = findViewById(R.id.button);


        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    // rouge


                }
                if(event.getAction()== MotionEvent.ACTION_UP)
                {
                    // orange

                }
                if(event.getAction()== MotionEvent.ACTION_UP)
                {
                    //vert

                }
                return false;
            }
        });




    }
}