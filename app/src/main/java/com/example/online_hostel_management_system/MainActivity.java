package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

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

}