package com.example.online_hostel_management_system;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView forgetpassword,signup;
    EditText txtemail,txtpass;
    Button btnLogin;
    String email,pass;
    int role;
    String status;
    // String url="http://localhost/OnlineHostelManagementSystem/index.php";
    String url="http://192.168.56.1/OHMS/Login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        controlIns();
        eventdHandler();
        // loginRequest();

    }

    private void controlIns()
    {
        forgetpassword=findViewById(R.id.forgotPassword);
        signup=findViewById(R.id.textViewSignUp);
        btnLogin=findViewById(R.id.btnlogin);
        txtpass=findViewById(R.id.inputPassword);
        txtemail=findViewById(R.id.inputEmail);


    }

    public void eventdHandler()
    {
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(getApplicationContext(),ForgetPassword.class);
                startActivity(it1);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent(getApplicationContext(),RegistrationForm.class);
                startActivity(it2);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRequest();
            }
        });
    }

    public void loginRequest()
    {
        //Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
        email=txtemail.getText().toString();
        pass=txtpass.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            txtemail.setError("Please Enter Username");
            txtemail.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            txtpass.setError("Please Enter Password");
            txtpass.requestFocus();
            return;
        }

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("data");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        role=ob.getInt("Role");
                        if (role == 1) {
                            Intent intentAdmin = new Intent(MainActivity.this, AdminHomePage.class);
                            startActivity(intentAdmin);
                        } else if (role == 2) {
                            Intent intentStaff = new Intent(MainActivity.this, StaffHomePage.class);
                            startActivity(intentStaff);
                        } else if (role == 3) {
                            Intent intentStudent = new Intent(MainActivity.this, StudentHomePage.class);
                            startActivity(intentStudent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("emailid",email);
                params.put("password",pass);
                return  params;
            }

        };
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

        //  Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }
}
/*import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView forgetpassword,signup;
    EditText edtEmail,edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlIns();
        eventdHandler();
    }

    private void controlIns()
    {
        forgetpassword=findViewById(R.id.forgotPassword);
        signup=findViewById(R.id.textViewSignUp);
        edtEmail=findViewById(R.id.inputEmail);
        edtPassword=findViewById(R.id.inputPassword);
        btnLogin=findViewById(R.id.btnlogin);
    }

    private void eventdHandler()
    {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edtEmail.getText().toString();
                String password=edtPassword.getText().toString();

                 if(email.length()==0)
                {
                    edtEmail.requestFocus();
                    edtEmail.setError("Field cannot be empty");
                }
                else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                {
                    edtEmail.requestFocus();
                    edtEmail.setError("Enter valid email id");
                }
                 else if(password.length()==0)
                 {
                     edtPassword.requestFocus();
                     edtPassword.setError("Field cannot be empty");
                 }
                 else if(password.length()<8)
                 {
                     edtPassword.requestFocus();
                     edtPassword.setError("Password must be minimum 8 characters");
                 }
                 else if(!password.matches("[a-zA-Z0-9]+"))
                 {
                     edtPassword.requestFocus();
                     edtPassword.setError("password should be combination of small character, capital character and number");
                 }
            }
        });

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(getApplicationContext(),ForgetPassword.class);
                startActivity(it1);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent(getApplicationContext(),RegistrationForm.class);
                startActivity(it2);
            }
        });
    }
}*/