package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentHomePage extends AppCompatActivity {

    Button btnRoomAllocationRequest;
    Button btnVieRoomAllocationRequestStatus;
    Button btnPayFee;
    Button btnPlaceComplaint;
    Button btnFoodCourtMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_page);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        btnRoomAllocationRequest=findViewById(R.id.btnrar);
        btnVieRoomAllocationRequestStatus=findViewById(R.id.btnvrars);
        btnPayFee=findViewById(R.id.btnphf);
        btnPlaceComplaint=findViewById(R.id.btnpc);
        btnFoodCourtMenu=findViewById(R.id.btnvfm);
    }
    private void eventHandler()
    {
        btnRoomAllocationRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(StudentHomePage.this,RoomAllocationRequest.class);
                startActivity(it1);
            }
        });

        btnVieRoomAllocationRequestStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPayFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPlaceComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4=new Intent(StudentHomePage.this,PlaceComplaint.class);
                startActivity(it4);
            }
        });

        btnFoodCourtMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5=new Intent(StudentHomePage.this,ViewFoodCourtMenu.class);
                startActivity(it5);
            }
        });
    }
}