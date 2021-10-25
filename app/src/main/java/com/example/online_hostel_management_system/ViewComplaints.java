package com.example.online_hostel_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewComplaints extends AppCompatActivity {

    String URL="http://192.168.56.1/OHMS/ViewComplaints.php";

    ListView lstComplaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        controlIns();
    }

    private void controlIns()
    {
        lstComplaint=findViewById(R.id.vsc);
        viewComplaint();
    }

    private void viewComplaint()
    {
        StringRequest request=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject object=new JSONObject(response);
                    ArrayList<String> foodList=new ArrayList<String>();


                        JSONArray dataarray=object.getJSONArray("complaint");
                        for(int i=0;i<dataarray.length();i++)
                        {
                            JSONObject dataobject=dataarray.getJSONObject(i);
                            foodList.add(dataobject.getString("Complaint_Id") + "      " +
                                    dataobject.getString("Complaint_Date") + "     " +
                                    dataobject.getString("Complaint_Description"));
                        }
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),
                                android.R.layout.simple_list_item_1,foodList);
                        lstComplaint.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }
}