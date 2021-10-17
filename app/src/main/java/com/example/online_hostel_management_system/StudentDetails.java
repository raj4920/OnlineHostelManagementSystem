package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentDetails extends AppCompatActivity {

    EditText fathercontact_no,collageenro,collagename;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        controlIns();
        eventHandler();
    }

    private void controlIns()
    {
        fathercontact_no=findViewById(R.id.fatherContactNo);
        collageenro=findViewById(R.id.collageEnro);
        collagename=findViewById(R.id.collageName);
        btnsubmit=findViewById(R.id.btnsubmit);
    }

    private void eventHandler()
    {
        String fcno=fathercontact_no.getText().toString();
        String collageEnro=collageenro.getText().toString();
        String collageName=collagename.getText().toString();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),fcno,Toast.LENGTH_LONG).show();

                boolean check=validation(fcno,collageEnro,collageName);

                if(check==true)
                {
                    Toast.makeText(getApplicationContext(),"Valid info",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid info",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validation(String fcno, String collageEnro, String collageName)
    {
        if(fcno.length()==0)
        {
            fathercontact_no.requestFocus();
            fathercontact_no.setError("Field cannot be empty");
            return false;
        }
        else if(fcno.length()<10)
        {
            fathercontact_no.requestFocus();
            fathercontact_no.setError("Enter valid contact no");
            return false;
        }

        else if(collageEnro.length()==0)
        {
            collageenro.requestFocus();
            collageenro.setError("Field cannot be empty");
            return false;
        }
        else if(collageEnro.length()<15)
        {
            collageenro.requestFocus();
            collageenro.setError("Enter valid enrollment number");
            return false;
        }
        else if(collageName.length()==0)
        {
            collagename.requestFocus();
            collagename.setError("Field cannot be empty");
            return false;
        }
        else if(!collageName.matches("[a-zA-Z]+"))
        {
            collagename.requestFocus();
            collagename.setError("Enter valid collage name");
            return false;
        }
        else
        {
            return true;
        }
    }
}