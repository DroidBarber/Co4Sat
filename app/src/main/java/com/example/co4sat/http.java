package com.example.co4sat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class http extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();

    final String TAG = "demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        JSONObject jsonObj = new JSONObject();

        try{
            jsonObj.put("imei","0000");
            jsonObj.put("longitude", "-122.084089");
            jsonObj.put("latitude", "37.422065");
            jsonObj.put("speed", "0");
            jsonObj.put("battery", "100");
            jsonObj.put("date", "2021-09-08T16:09:33+00:00");
            jsonObj.put("error", "0");
            jsonObj.put("acceleroVal", "0");
            jsonObj.put("ble", "true");
            jsonObj.put("accelero", "false");
            jsonObj.put("freq", "0");
            jsonObj.put("sens", "02");
            jsonObj.put("veille", "false");
            jsonObj.put("apn", "www.orange.com");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObj.toString();
        RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));

        RequestBody formBody = new FormBody.Builder()
                .build();

        Request request = new Request.Builder()
                .url("https://co4sat.com:2000/api/tracers/trains/updateTrainPositions")
                .put(formBody)
                .build();


///

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    Log.d(TAG, "onResponse :" + responseBody.string());

                }
            }
        });
    }
}