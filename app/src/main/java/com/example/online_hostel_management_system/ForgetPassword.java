package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgetPassword extends AppCompatActivity {

    String url1="http://192.168.56.1/OHMS/ForgetPassword.php";
    EditText txtemailid;
    Button btnpassword;
    String email;
    int send=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        txtemailid=findViewById(R.id.email);
        btnpassword=findViewById(R.id.btnsp);

        btnpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=txtemailid.getText().toString();
                send=0;

                if(TextUtils.isEmpty(email))
                {
                    txtemailid.setError("Enter Email ID");
                    txtemailid.requestFocus();
                    return;
                }


                forgetPassword();
                Intent intentForget=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentForget);
                //Toast.makeText(getApplicationContext(),"Password will be send in your mail",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void forgetPassword()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("Invalid Email ID"))
                {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
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
                return  params;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }
}*/