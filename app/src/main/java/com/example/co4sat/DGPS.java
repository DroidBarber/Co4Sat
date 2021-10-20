package com.example.co4sat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DGPS extends AppCompatActivity {
    //variables
    Button btLocation;
    TextView textView1, textView2, textView3, textView4, textView5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dgps);

        //assign vars
        btLocation = findViewById(R.id.bt_location);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        textView5 = findViewById(R.id.text_view5);

        //init fuseLocation
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check permission
                if (ActivityCompat.checkSelfPermission(DGPS.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //permission granted
                    getLocation();
                } else {
                    //permission denied
                    ActivityCompat.requestPermissions(DGPS.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });

    }

    private void getLocation() {

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //init location
                Location location = task.getResult();
                if (location != null) {
                    try {
                        //init geocoder
                        Geocoder geocoder = new Geocoder(DGPS.this, Locale.getDefault());
                        //init address list
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        //Set Latitude on txtv1
                        textView1.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Latitude : </b><br></font>"
                                + addresses.get(0).getLatitude()
                        ));
                        //Set Longitude on txtv2
                        textView2.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Longitude : </b><br></font>"
                                        + addresses.get(0).getLongitude()
                        ));
                        // Set Country Name
                        textView3.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Country Name : </b><br></font>"
                                        + addresses.get(0).getCountryName()
                        ));
                        //Set Locality
                        textView4.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Locality : </b><br></font>"
                                        + addresses.get(0).getLocality()
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}