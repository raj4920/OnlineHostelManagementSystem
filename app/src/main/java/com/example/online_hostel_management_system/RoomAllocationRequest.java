package com.example.online_hostel_management_system;

import static android.graphics.Color.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.camera2.params.BlackLevelPattern;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Collections;

public class RoomAllocationRequest extends AppCompatActivity {
    ListView lst1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_allocation_request);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        lst1=findViewById(R.id.lst1);
    }

    private void eventHandler()
    {

    }
}