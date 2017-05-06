package com.example.admin.smsmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pushbots.push.Pushbots;

public class EmployeeHomeActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        listview = (ListView) findViewById(R.id.employeelist_list);
        Pushbots.sharedInstance().registerForRemoteNotifications();
        String[] valuesParentHome = new String[]{"Holidays","PersonalDetails","Geolocation",  "BarCodeScanner","EmployeeSetting"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , valuesParentHome);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if(position == 0) {
                    Intent fee = new Intent(EmployeeHomeActivity.this,EmployeeHolidays.class);
                    startActivity(fee);
                }
                if(position == 1){
                    Intent personalDetails = new Intent(EmployeeHomeActivity.this,EmployeePersonalDetails.class);
                    startActivity(personalDetails);
                }
                if(position == 2){
                    Intent RouteCode = new Intent(EmployeeHomeActivity.this,Geolocation.class);
                    startActivity(RouteCode);
                }
                if(position==3){
                    Intent barcodescanner = new Intent(EmployeeHomeActivity.this,BarCodeScanner.class);
                    startActivity(barcodescanner);
                }
                if(position ==4){
                    Intent logout = new Intent(EmployeeHomeActivity.this,EmployeeSetting.class);
                    startActivity(logout);
                }
            }
        });
    }
}
