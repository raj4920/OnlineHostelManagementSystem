package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class RegistrationForm2 extends AppCompatActivity {

    EditText aadhar_no,contact_no,email_id,password;
    RadioGroup rguser;
    RadioButton rbuser;
    Button btnNext2;
    RadioButton rbrole;

    String URL="http://192.168.56.1/OHMS/UserInsert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form2);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        btnNext2=findViewById(R.id.btnnext2);
        aadhar_no=findViewById(R.id.aadharNo);
        contact_no=findViewById(R.id.contactNo);
        email_id=findViewById(R.id.emailId);
        password=findViewById(R.id.password);
        rguser=findViewById(R.id.user);
    }

    private void eventHandler()
    {
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userId=rguser.getCheckedRadioButtonId();
                rbuser=(RadioButton)findViewById(userId);
                rbrole=(RadioButton)findViewById(userId);
                String userRole=rbrole.getText().toString();

                if(userRole.equals("Student"))
                {
                    Intent it=new Intent(RegistrationForm2.this,StudentDetails.class);
                    startActivity(it);
                }
                else if(userRole.equals("Staff"))
                {
                    Intent i=new Intent(RegistrationForm2.this,MainActivity.class);
                    startActivity(i);
                }
                addData();
                //Toast.makeText(getApplicationContext(), fname + mname + lname + gender + address, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addData()
    {
        String fname=getIntent().getStringExtra("firstname");
        String mname=getIntent().getStringExtra("middlename");
        String lname=getIntent().getStringExtra("lastname");
        String gender=getIntent().getStringExtra("gender");
        String address=getIntent().getStringExtra("address");
        String user=rbuser.getText().toString();
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
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("first_name",fname);
                params.put("middle_name",mname);
                params.put("last_name",lname);
                params.put("gender",gender);
                params.put("address",address);
                params.put("aadhar_no",aadhar_no.getText().toString());
                params.put("contact_no",contact_no.getText().toString());
                params.put("email_id",email_id.getText().toString());
                params.put("password",password.getText().toString());
                params.put("role",user);

                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(addRequest);
    }
}