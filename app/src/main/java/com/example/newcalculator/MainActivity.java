package com.example.newcalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMainDisplay;
    private Button btnMainExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        btnMainDisplay.setOnClickListener(this);
        btnMainExit.setOnClickListener(this);
    }

    public void initialization(){
        btnMainDisplay = findViewById(R.id.btnMianLayout);
        btnMainExit = findViewById(R.id.btnMainExit);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMianLayout:
                Intent intentCalcActivity = new Intent(this, CalcActivity.class);
                startActivity(intentCalcActivity);
                break;
            case R.id.btnMainExit:
                System.exit(0);
                break;
            default:
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }
    }



}
