package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

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

    private String str_num = "";
    private float first_num;
    private char operation;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        initialization();

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);

    }

    public void initialization() {
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



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnZero:
                first_num = 0;
                addNumber((int) first_num);
                break;
            case R.id.btnOne:
                first_num = 1;
                addNumber((int) first_num);
                break;
            case R.id.btnTwo:
                first_num = 2;
                addNumber((int) first_num);
                break;
            case R.id.btnThree:
                first_num = 3;
                addNumber((int) first_num);
                break;
            case R.id.btnFour:
                first_num = 4;
               addNumber((int) first_num);
                break;
            case R.id.btnFive:
                first_num = 5;
                addNumber((int) first_num);
                break;
            case R.id.btnSix:
                first_num = 6;
                addNumber((int) first_num);
                break;
            case R.id.btnSeven:
                first_num = 7;
                addNumber((int) first_num);
                break;
            case R.id.btnEight:
                first_num = 8;
                addNumber((int) first_num);
                break;
            case R.id.btnNine:
                first_num = 9;
                addNumber((int) first_num);
                break;
            default:
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void addNumber(int number) {
        str_num += Integer.toString(number);
        calcDisplay.setText(str_num);
    }




}