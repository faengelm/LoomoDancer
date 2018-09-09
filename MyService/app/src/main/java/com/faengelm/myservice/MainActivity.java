package com.faengelm.myservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(getString(R.string.service_demo_tag),"Main Activity, thread id: " +Thread.currentThread().getId());

        Button buttonStart = (Button) findViewById(R.id.buttonThreadStarter);
        Button buttonStop = (Button) findViewById(R.id.buttonStopthread);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startService(serviceIntent);

            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    serviceIntent = new Intent(getApplicationContext(),MyService.class);
    startService(serviceIntent);

    }





}
