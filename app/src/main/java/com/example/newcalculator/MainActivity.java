package com.example.newcalculator;

import android.annotation.SuppressLint;
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

    private static final String SHARED_PREF = "SHARED_PREF";
    private static final String APP_THEME = "APP_THEME";
    private static final int MyStyleMainCalcNotnight = 0;
    private static final int MyStyleMainCalcNight = 1;
    private Button btnMainDisplay;
    private Button btnMainExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyStyleMainCalcNotnight));
        setContentView(R.layout.activity_main);

        initThemeChooser();

        initialization();

        btnMainDisplay.setOnClickListener(this);
        btnMainExit.setOnClickListener(this);
    }

    private void initThemeChooser() {

        initRadiobutton(findViewById(R.id.radionotnight), MyStyleMainCalcNotnight);
        initRadiobutton(findViewById(R.id.radionight), MyStyleMainCalcNight);
        RadioGroup rg = findViewById(R.id.radioGroup);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(MyStyleMainCalcNotnight))).setChecked(true);
    }

    private void initRadiobutton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }
    private int getAppTheme(int codeStyle){
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
       // Log.d("myLog", sharedPref.getInt(APP_THEME, codeStyle)+"");
        return sharedPref.getInt(APP_THEME, codeStyle);
    }

    private void setAppTheme(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(APP_THEME, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle){
        switch (codeStyle){
            case MyStyleMainCalcNight:
                return R.style.MyStyleMainCalcNight;
            default:
                return R.style.MyStyleMainCalcNotnight;
        }
    }

    public void initialization() {
        btnMainDisplay = findViewById(R.id.btnMianLayout);
        btnMainExit = findViewById(R.id.btnMainExit);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
