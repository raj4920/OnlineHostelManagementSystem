package com.example.online_hostel_management_system;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.text.SimpleDateFormat;
import java.util.Date;


public class StaffHomePage extends AppCompatActivity implements LocationListener {

    Button btnEntryAttendance;
    Button btnExitAttendance;
    TextView txtLocation;
    String latitude, longitude;
    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home_page);
        controlIns();
        eventHandler();
    }

    private void controlIns() {
        btnEntryAttendance = findViewById(R.id.btnena);
        btnExitAttendance = findViewById(R.id.btnexa);
        txtLocation = findViewById(R.id.tvd);


    }

    private void getLocation()
    {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, StaffHomePage.this);
    }

    private void eventHandler() {
        getLocation();
        String lat="37.421998333333335";
        String lon="-122.08400000000002";

        String entryTime="08:30:00";
        String exitTime="17:00:00";

        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        String currentTime=sdf.format(new Date());
        btnEntryAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(latitude.equals(lat) && longitude.equals(lon) && entryTime.equals(currentTime))
                {
                    Toast.makeText(getApplicationContext(),"Done...",Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), currentTime, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error...",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnExitAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(latitude.equals(lat) && longitude.equals(lon) && currentTime.equals(entryTime))
                {
                    Toast.makeText(getApplicationContext(),"Done...",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error...",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //txtLocation.setText(location.getLatitude() + "-" + location.getLongitude());
        latitude=String.valueOf(location.getLatitude());
        longitude=String.valueOf(location.getLongitude());

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        Toast.makeText(getApplicationContext(),"ON",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toast.makeText(getApplicationContext(),"OFF",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }
}