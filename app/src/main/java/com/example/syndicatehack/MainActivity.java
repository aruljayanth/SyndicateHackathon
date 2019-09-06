package com.example.syndicatehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;

import android.view.View;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent al = new Intent(MainActivity.this, Alar.class);

                // Start the new activity
                startActivity(al);
            }
        });
    }

    public void visit(View view) {
        Intent log = new Intent(MainActivity.this, Second.class);
        startActivity(log);
    }
}
