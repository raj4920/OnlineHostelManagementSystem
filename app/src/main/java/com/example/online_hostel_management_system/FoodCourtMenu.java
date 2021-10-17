package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FoodCourtMenu extends AppCompatActivity {

    Spinner Day;
    Spinner Time;
    EditText dishName;
    Button btnSubmit;
    String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    String[] time={"Breakfast","Lunch","Dinner"};

    String day="";
    String ftime="";

    String URL="http://192.168.56.1/OHMS/AddFoodCourtMenu.php";
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
        dishName=findViewById(R.id.dn);
        btnSubmit=findViewById(R.id.btnsm);

        ArrayAdapter aa1=new ArrayAdapter(this, R.layout.days_layout,days);
        aa1.setDropDownViewResource(R.layout.days_layout);
        Day.setAdapter(aa1);

        ArrayAdapter aa2=new ArrayAdapter(this,R.layout.days_layout,time);
        aa2.setDropDownViewResource(R.layout.days_layout);
        Time.setAdapter(aa2);
    }

    private void eventHandler()
    {
        Day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                day= (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ftime= (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String DishName=dishName.getText().toString();
                String DAY=day;
                String TIME=ftime;
                boolean check=validation(DishName);

                if(check==true)
                {
                    addFoodMenu();
                    //Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error...",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean validation(String DishName)
    {
        if(DishName.length()==0)
        {
            dishName.requestFocus();
            dishName.setError("Field cannot be empty");
            return false;
        }
        else
        {
            return true;
        }
    }

    private void addFoodMenu()
    {
        StringRequest addRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })
        {
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params=new HashMap<String,String>();
                params.put("dishName",dishName.getText().toString());
                params.put("day",day);
                params.put("time",ftime);
                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(addRequest);
    }
}