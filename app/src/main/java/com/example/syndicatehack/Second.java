package com.example.syndicatehack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;
public class Second extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Button btnDatePicker, btnTimePicker,btnservicee;
    EditText txtDate, txtTime;

    public static int mYear;
    public static int mMonth;
    public static int mDay;
    public static int mHour;
    public static int mMinute;
    public static String namee,service,phnum,emails;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

         spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> bb = ArrayAdapter.createFromResource(this, R.array.Services, android.R.layout.simple_spinner_item);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(bb);


        spinner.setOnItemSelectedListener(this);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        btnservicee=(Button) findViewById(R.id.btn_service);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        service = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onClick(View view) {

        if (view == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            mYear=year;
                            mMonth=monthOfYear;
                            mDay=dayOfMonth;
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            mHour=hourOfDay;
                            mMinute=minute;
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }



    }
    public void create(View view) {
        EditText text = (EditText) findViewById(R.id.namefield);
        namee = text.getText().toString();
        EditText text2 = (EditText) findViewById(R.id.mailfield);
        emails = text2.getText().toString();
        EditText text3= (EditText) findViewById(R.id.phnfield);
        phnum = text3.getText().toString();

        response hu =new response(this.getApplicationContext());
        hu.execute();



    }
}