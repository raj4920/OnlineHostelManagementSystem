package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class StudentDetails extends AppCompatActivity {

    EditText fathercontact_no,collageenro,collagename;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
    }

    private void controlIns()
    {
        fathercontact_no=findViewById(R.id.fatherContactNo);
        collageenro=findViewById(R.id.collageEnro);
        collagename=findViewById(R.id.collageName);
        btnsubmit=findViewById(R.id.btnsubmit);
    }
}