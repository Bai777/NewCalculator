package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_setting_change_theme_app);

        initThemeChooser();
    }

    private void initThemeChooser()
    {

    }


}