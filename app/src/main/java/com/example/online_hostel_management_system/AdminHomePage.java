package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomePage extends AppCompatActivity {

    Button btnViewRoomAllocationRequest;
    Button btnMaintainRoomDetails;
    Button btnViewStudentComplaint;
    Button btnSetFoodCourtMenu;
    Button btnViewStudentFeeStatus;
    Button btnMaintainHostelExpence;
    Button btnGenerateReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        btnViewRoomAllocationRequest=findViewById(R.id.btnvsrar);
        btnMaintainRoomDetails=findViewById(R.id.btnmrd);
        btnViewStudentComplaint=findViewById(R.id.btnvscm);
        btnSetFoodCourtMenu=findViewById(R.id.btnufcm);
        btnViewStudentFeeStatus=findViewById(R.id.btnvsfs);
        btnMaintainHostelExpence=findViewById(R.id.btnmhe);
        btnGenerateReport=findViewById(R.id.btngr);
    }

    private void eventHandler()
    {
        btnViewRoomAllocationRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent();
                startActivity(it1);
            }
        });

        btnMaintainRoomDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent(AdminHomePage.this,MaintainRoomDetails.class);
                startActivity(it2);
            }
        });

        btnViewStudentComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3=new Intent();
                startActivity(it3);
            }
        });

        btnSetFoodCourtMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4=new Intent(AdminHomePage.this,FoodCourtMenu.class);
                startActivity(it4);
            }
        });

        btnViewStudentFeeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5=new Intent();
                startActivity(it5);
            }
        });

        btnMaintainHostelExpence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it6=new Intent(AdminHomePage.this,MaintainHostelExpense.class);
                startActivity(it6);
            }
        });

        btnGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it7=new Intent();
                startActivity(it7);
            }
        });
    }
}