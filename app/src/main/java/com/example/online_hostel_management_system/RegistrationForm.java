package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class RegistrationForm extends AppCompatActivity {

    Button btnNext1;
    EditText first_name,middle_name,last_name,address;
    RadioGroup rggender;
    //String URL="http://192.168.56.1/OHMS/UserInsert.php";
    RadioButton genderrb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        btnNext1=findViewById(R.id.btnnext1);
        first_name=findViewById(R.id.firstName);
        middle_name=findViewById(R.id.middleName);
        last_name=findViewById(R.id.lastName);
        rggender=findViewById(R.id.gender);
        address=findViewById(R.id.address);
    }

    private void eventHandler()
    {
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int genderid=rggender.getCheckedRadioButtonId();
                genderrb=(RadioButton)findViewById(genderid);
                String fname=first_name.getText().toString();
                String mname=middle_name.getText().toString();
                String lname=last_name.getText().toString();
                String adrs=address.getText().toString();
                String gender=genderrb.getText().toString();


                if(fname.isEmpty())
                {
                    first_name.setError("Field is required");
                }
                else if(mname.isEmpty())
                {
                    middle_name.setError("Field is required");
                }
                else if(lname.isEmpty())
                {
                    last_name.setError("Field is required");
                }
                else if (adrs.isEmpty())
                {
                    address.setError("Field is required");
                }
                else
                {
                    Intent it=new Intent(RegistrationForm.this,RegistrationForm2.class);
                    it.putExtra("firstname",fname);
                    it.putExtra("middlename",mname);
                    it.putExtra("lastname",lname);
                    it.putExtra("gender",gender);
                    it.putExtra("address",adrs);
                    startActivity(it);
                }

                //addData();
                //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
            }
        });
    }

    /*private void addData()
    {
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
                Map<String,String> params=new HashMap<String,String>();
                params.put("first_name",first_name.getText().toString());
                params.put("middle_name",middle_name.getText().toString());
                params.put("last_name",last_name.getText().toString());
                params.put("gender",genderrb.getText().toString());
                params.put("address",address.getText().toString());

                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(addRequest);
    }*/
}