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

    EditText aadhar_no, contact_no, email_id, password;
    RadioGroup rguser;
    RadioButton rbuser;
    Button btnNext2;
    RadioButton rbrole;
    RadioButton Student;
    RadioButton Staff;

    String URL = "http://192.168.56.1/OHMS/UserInsert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form2);
        controlIns();
        eventHandler();
    }

    private void controlIns() {
        btnNext2 = findViewById(R.id.btnnext2);
        aadhar_no = findViewById(R.id.aadharNo);
        contact_no = findViewById(R.id.contactNo);
        email_id = findViewById(R.id.emailId);
        password = findViewById(R.id.password);
        rguser = findViewById(R.id.user);
        Student=findViewById(R.id.student);
        Staff=findViewById(R.id.staff);
    }

    private void eventHandler() {
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userId = rguser.getCheckedRadioButtonId();
                rbuser = (RadioButton) findViewById(userId);

                String aadharNo = aadhar_no.getText().toString();
                String contactNo = contact_no.getText().toString();
                String emailId = email_id.getText().toString();
                String pwd = password.getText().toString();

                boolean check=validation(aadharNo,contactNo,emailId,pwd);

                if(check==true)
                {
                    if (rbuser.getText().toString().equals("Student")) {
                        addData();
                        Intent it1 = new Intent(RegistrationForm2.this, MainActivity.class);
                        startActivity(it1);
                    } else if (rbuser.getText().toString().equals("Staff")) {
                        addData();
                        Intent it2 = new Intent(RegistrationForm2.this, MainActivity.class);
                        startActivity(it2);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter all information",Toast.LENGTH_LONG).show();
                }


                //addData();
            }
        });
    }

    private boolean validation(String aadharNo, String contactNo, String emailId, String pwd)
    {
        if(aadharNo.length()==0)
        {
            aadhar_no.requestFocus();
            aadhar_no.setError("Field cannot be empty");
            return false;
        }
        else if(aadharNo.length()<12)
        {
            aadhar_no.requestFocus();
            aadhar_no.setError("Enter valid aadhar card number");
            return false;
        }
        else if(contactNo.length()==0)
        {
            contact_no.requestFocus();
            contact_no.setError("Field cannot be empty");
            return false;
        }
        else if(contactNo.length()<10)
        {
            contact_no.requestFocus();
            contact_no.setError("Enter valid contact no");
            return false;
        }
        else if(emailId.length()==0)
        {
            email_id.requestFocus();
            email_id.setError("Field cannot be empty");
            return false;
        }
        else if(!emailId.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
        {
            email_id.requestFocus();
            email_id.setError("Enter valid email id");
            return false;
        }
        else if(pwd.length()==0)
        {
            password.requestFocus();
            password.setError("Field cannot be empty");
            return false;
        }
        else if(!pwd.matches("[a-zA-Z0-9]+"))
        {
            password.requestFocus();
            password.setError("password should be combination of small character, capital character and number");
            return false;
        }
        else if(pwd.length()<8)
        {
            password.requestFocus();
            password.setError("Minimum 8 character required");
            return false;
        }
        else if(!Student.isChecked() && !Staff.isChecked())
        {
            Toast.makeText(getApplicationContext(),"Please select user type",Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            return true;
        }
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