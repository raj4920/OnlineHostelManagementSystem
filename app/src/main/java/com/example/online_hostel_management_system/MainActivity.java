package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView forgetpassword,signup;
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
    }

    private void eventdHandler()
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
    }

}