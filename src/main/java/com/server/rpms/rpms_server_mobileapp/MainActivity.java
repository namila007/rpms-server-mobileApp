package com.server.rpms.rpms_server_mobileapp;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    EditText ssid,password,host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject postData = new JSONObject();
                try {
                    ssid = (EditText)findViewById(R.id.ssid);
                    password = (EditText)findViewById(R.id.password);
                    host = (EditText)findViewById(R.id.host);

                    postData.put("ssid", ssid.getText().toString());
                    postData.put("password", password.getText().toString());
                    postData.put("host", host.getText().toString());


                    //new SendDeviceDetails.execute("http://52.88.194.67:8080/IOTProjectServer/registerDevice", postData.toString());
                    new SendDeviceDetails().execute("http://192.168.4.1", postData.toString());
                   // new SendDeviceDetails.execute();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
