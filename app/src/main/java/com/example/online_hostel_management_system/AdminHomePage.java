package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomePage extends AppCompatActivity {

    Button btnmrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
    }

    private void controlIns()
    {
        btnmrd=findViewById(R.id.btnmrd);
    }

    private void eventHandler()
    {
        btnmrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(AdminHomePage.this,MaintainRoomDetails.class);
                startActivity(it1);
            }
        });
    }
}