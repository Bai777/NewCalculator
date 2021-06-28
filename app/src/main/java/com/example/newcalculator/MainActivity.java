package com.example.newcalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnMainDisplay;
    private Button btnMainExit;
    private Button btnMainSettingTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialization();

        btnMainDisplay.setOnClickListener(this);
        btnMainExit.setOnClickListener(this);
        btnMainSettingTheme.setOnClickListener(this);

    }


    public void initialization() {
        btnMainDisplay = findViewById(R.id.btnMianLayout);
        btnMainExit = findViewById(R.id.btnMainExit);
        btnMainSettingTheme = findViewById(R.id.btnMainSettingTheme);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMianLayout:
                Intent intentCalcActivity = new Intent(this, CalcActivity.class);
                startActivity(intentCalcActivity);
                break;
            case R.id.btnMainSettingTheme:
                Intent intentSettingActivity = new Intent(this, SettingActivityChangeThemeApp.class);
                startActivity(intentSettingActivity);
                break;
            case R.id.btnMainExit:
                System.exit(0);
                break;
            default:
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }
    }


}
