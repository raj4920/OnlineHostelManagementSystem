package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffHomePage extends AppCompatActivity {

    Button btnEntryAttendance;
    Button btnExitAttendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home_page);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        btnEntryAttendance=findViewById(R.id.btnena);
        btnExitAttendance=findViewById(R.id.btnexa);
    }

    private void eventHandler()
    {
        btnEntryAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}