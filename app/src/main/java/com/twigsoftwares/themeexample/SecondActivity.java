package com.twigsoftwares.themeexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String EmployeeName = getIntent().getStringExtra("EXTRA_INFO");

        Toast.makeText(SecondActivity.this,EmployeeName,Toast.LENGTH_LONG).show();
    }
}
