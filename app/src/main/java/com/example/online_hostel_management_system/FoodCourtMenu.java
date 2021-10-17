package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FoodCourtMenu extends AppCompatActivity{

    Spinner Day;
    Spinner Time;

    String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    String[] time={"Breakfast","Lunch","Dinner"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_court_menu);
        controlIns();
        eventHandler();
    }
    private void controlIns()
    {
        Day=findViewById(R.id.day);
        Time=findViewById(R.id.time);
    }

    private void eventHandler()
    {
        ArrayAdapter aa1=new ArrayAdapter(this, R.layout.days_layout,days);
        aa1.setDropDownViewResource(R.layout.days_layout);
        Day.setAdapter(aa1);

        ArrayAdapter aa2=new ArrayAdapter(this,R.layout.days_layout,time);
        aa2.setDropDownViewResource(R.layout.days_layout);
        Time.setAdapter(aa2);

    }
}