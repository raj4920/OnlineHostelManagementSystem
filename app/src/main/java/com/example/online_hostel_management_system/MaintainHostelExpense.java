package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MaintainHostelExpense extends AppCompatActivity {

    EditText expDesc,expCost;
    Button btnSubmitHE;

    String URL="http://192.168.56.1/OHMS/ExpenseInsert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_hostel_expense);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        expDesc=findViewById(R.id.ehe);
        expCost=findViewById(R.id.ec);
        btnSubmitHE=findViewById(R.id.btnsubmithe);
    }

    private void eventHandler()
    {
        btnSubmitHE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String eDescription=expDesc.getText().toString();
                String eCost=expCost.getText().toString();

                boolean check=validation(eDescription,eCost);

                if(check==true)
                {
                    addExpense();
                    //Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error...",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validation(String eDescription, String eCost)
    {
        if(eDescription.length()==0)
        {
            expDesc.requestFocus();
            expDesc.setError("Field cannot be empty");
            return false;
        }

        if(eCost.length()==0)
        {
            expCost.requestFocus();
            expCost.setError("Field cannot be empty");
            return false;
        }
        else
        {
            return true;
        }
    }

    private void addExpense()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String cDate=sdf.format(new Date());
        //Toast.makeText(getApplicationContext(), cDate, Toast.LENGTH_SHORT).show();
        StringRequest addRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })
        {
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params=new HashMap<String,String>();
                params.put("expDesc",expDesc.getText().toString());
                params.put("eCost",expCost.getText().toString());
                params.put("eDate",cDate);
                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(addRequest);
    }
}