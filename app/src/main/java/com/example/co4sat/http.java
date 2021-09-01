package com.example.co4sat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class http extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        mTextViewResult = findViewById(R.id.text_view_result);

        OkHttpClient client = new OkHttpClient();
        String url = "http://13.79.149.204:2000/api/tracers/trains/updateTrainPositions";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    http.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText((myResponse));
                        }
                    });
                }
            }
        });
    }
}