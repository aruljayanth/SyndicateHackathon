package com.example.syndicatehack;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class Alar extends AppCompatActivity {
    TimePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alar);
        picker=(TimePicker)findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);
    }
    public void button1(View view){

        int hour, minute;
        String am_pm;
        if (Build.VERSION.SDK_INT >= 23 ){
            hour = picker.getHour();
            minute = picker.getMinute();
        }
        else{
            hour = picker.getCurrentHour();
            minute = picker.getCurrentMinute();
        }
        if(hour > 12) {
            am_pm = "PM";
            hour = hour - 12;
        }
        else
        {
            am_pm="AM";
        }
        createAlarm("visit time",hour,minute);
        //Intent al = new Intent(alar.this, alar.class);
        Toast.makeText(this,    "Alarm-Set",Toast.LENGTH_LONG).show();


    }
    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_SKIP_UI,true)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


}
