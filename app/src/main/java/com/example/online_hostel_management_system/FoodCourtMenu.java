package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FoodCourtMenu extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner Day;

    String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
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
    }

    private void eventHandler()
    {
        Day.setOnItemSelectedListener(this);

        ArrayAdapter aa=new ArrayAdapter(this, R.layout.days_layout,days);
        aa.setDropDownViewResource(R.layout.days_layout);
        Day.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}