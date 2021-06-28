package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingActivityChangeThemeApp extends AppCompatActivity {

    private static final String SHARED_PREF = "KEY";

    private static final String appTheme = "APP_THEME";
    private static final int MY_STYLE = 0;
    private static final int LIGHT_STYLE = 1;
    private static final int DARK_STYLE = 2;
    private static final int CUSTOM_STYLE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppTheme));
        setContentView(R.layout.activity_setting_change_theme_app);

        initThemeChooser();
    }

    private void initThemeChooser()
    {
        initRadioButton(findViewById(R.id.radioButtonMyStyle), MY_STYLE);
        initRadioButton(findViewById(R.id.radioButtonLightStyle), LIGHT_STYLE);
        initRadioButton(findViewById(R.id.radioButtonDarkStyle), DARK_STYLE);
        initRadioButton(findViewById(R.id.radioButtonCustomStyle), CUSTOM_STYLE);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(MY_STYLE))).setChecked(true);
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int myStyle) {
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        return sharedPref.getInt(appTheme, myStyle);
    }

    private void initRadioButton(View viewById, int myStyle) {
        viewById.setOnClickListener(v-> {
            setAppTheme(myStyle);
            recreate();
        });
    }

    private void setAppTheme(int myStyle) {
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, myStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle){
        switch (codeStyle){
            case LIGHT_STYLE:
                return R.style.LightStyle;
            case DARK_STYLE:
                return R.style.DarkStyle;
            case CUSTOM_STYLE:
                return R.style.CastomeStyle;
            default:
                return R.style.MyStyle;
        }
    }


}