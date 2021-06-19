package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class CalcActivity extends AppCompatActivity {

    private TextView calcDisplay;
    private Button btnAC;
    private Button btnPlusMinus;
    private Button btnPercent;
    private Button btnDiv;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnMulti;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnMinus;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnPlus;
    private Button btnZero;
    private Button btnComma;
    private Button btnEqually;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        initialization();
    }

    public void initialization(){
        calcDisplay = findViewById(R.id.calcDisplay);
        btnAC = findViewById(R.id.btnAC);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        btnPercent = findViewById(R.id.btnPercent);
        btnDiv = findViewById(R.id.btnDiv);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnMulti = findViewById(R.id.btnMulti);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnMinus = findViewById(R.id.btnMinus);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnPlus = findViewById(R.id.btnPlus);
        btnZero = findViewById(R.id.btnZero);
        btnComma = findViewById(R.id.btnComma);
        btnEqually = findViewById(R.id.btnEqually);
    }
}