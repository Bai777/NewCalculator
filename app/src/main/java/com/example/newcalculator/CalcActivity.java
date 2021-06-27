package com.example.newcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String Key = "Key_values";

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
    private int first_num;
    private char operation;
    private String cast;
    private float first_num_float;
    private int first_num_int;


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

        btnAC.setOnClickListener(this);
        btnPlusMinus.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqually.setOnClickListener(this);
        btnComma.setOnClickListener(this);

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
                addNumber(first_num);
                break;
            case R.id.btnOne:
                first_num = 1;
                addNumber(first_num);
                break;
            case R.id.btnTwo:
                first_num = 2;
                addNumber(first_num);
                break;
            case R.id.btnThree:
                first_num = 3;
                addNumber(first_num);
                break;
            case R.id.btnFour:
                first_num = 4;
                addNumber(first_num);
                break;
            case R.id.btnFive:
                first_num = 5;
                addNumber(first_num);
                break;
            case R.id.btnSix:
                first_num = 6;
                addNumber(first_num);
                break;
            case R.id.btnSeven:
                first_num = 7;
                addNumber(first_num);
                break;
            case R.id.btnEight:
                first_num = 8;
                addNumber(first_num);
                break;
            case R.id.btnNine:
                first_num = 9;
                addNumber(first_num);
                break;
            case R.id.btnAC:
                clearbtnAC();
                break;
            case R.id.btnPlusMinus:
                plusMinus();
                break;
            case R.id.btnPercent:
                percent();
                break;
            case R.id.btnComma:
                comma();
                break;
            case R.id.btnDiv:
                mathAction('/');
                break;
            case R.id.btnMulti:
                mathAction('*');
                break;
            case R.id.btnMinus:
                mathAction('-');
                break;
            case R.id.btnPlus:
                mathAction('+');
                break;
            case R.id.btnEqually:
                if (this.operation == '+' || this.operation == '-'
                        || this.operation == '/' || this.operation == '*')
                    equalMethod();
                break;
            default:
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void comma() {
        if (calcDisplay.getText() == "") {
            calcDisplay.setText(this.str_num = "0.");
        } else if (!this.str_num.contains(".")) {
            this.str_num += ".";
            calcDisplay.setText(str_num);
        }
    }

    public void percent() {
        if (!this.str_num.equals("")) {
            float num = Float.parseFloat(this.str_num) * 0.01f;
            this.str_num = Float.toString(num);
            calcDisplay.setText(str_num);
        }
    }

    public void plusMinus() {
        float res = 0;
        if (!this.str_num.equals("") && !this.str_num.contains(".")) {
            int num = Integer.parseInt(this.str_num) * -1;
            this.cast = Integer.toString(num);
            calcDisplay.setText(this.cast);
        } else if (!this.str_num.equals("") && this.str_num.contains(".")) {
            res = (Float.parseFloat(this.str_num)) * -1;
            this.cast = Float.toString(res);
            calcDisplay.setText(this.cast);
        }
    }

    public void clearbtnAC() {
        calcDisplay.setText("");
        this.str_num = "";
        this.first_num = 0;
        this.operation = 'A';
        this.cast = "";
        this.first_num_float = 0.0f;
        this.first_num_int = 0;
    }


    public void addNumber(int number) {
        if (calcDisplay.getText().equals(".")) {
            str_num += Float.toString(number);
            calcDisplay.setText(str_num);
        } else {
            str_num += Integer.toString(number);
            calcDisplay.setText(str_num);
        }

    }

    public void mathAction(char operation) {
        if (this.operation != '+' && this.operation != '-'
                && this.operation != '/' && this.operation != '*' && this.str_num.contains(".")) {
            first_num_float = Float.parseFloat(this.str_num);
            calcDisplay.setText((first_num_float + "" + operation));
            this.str_num = "";
            this.operation = operation;
        } else if (this.operation != '+' && this.operation != '-'
                && this.operation != '/' && this.operation != '*' && !this.str_num.contains(".")) {

            first_num_int = Integer.parseInt(this.str_num);
            calcDisplay.setText((first_num_int + "" + operation));
            this.str_num = "";
            this.operation = operation;
        }
    }


    public void equalMethod() {

        switch (this.operation) {
            case '+':
                if (calcDisplay.getText().equals(".")) {
                    Log.d("log", first_num_float + Float.parseFloat(str_num) + "");
                    floatDisplay(Float.toString(first_num_float + Float.parseFloat(str_num)));
                }else if (!calcDisplay.getText().equals(".")){
                    Log.d("log", first_num_int + Integer.parseInt(str_num) + "");
                    intDisplay(Integer.toString(first_num_int + Integer.parseInt(str_num)));
                }

                break;
            case '-':
                if (calcDisplay.getText().equals(".") || Float.toString(first_num_float).contains(".")) {
//                    Log.d("log", first_num_float - Float.parseFloat(str_num) + "");
                    floatDisplay(Float.toString(first_num_float - Float.parseFloat(str_num)));
                }else if (!calcDisplay.getText().equals(".")){
//                    Log.d("log", first_num_int - Integer.parseInt(str_num) + "");
                    intDisplay(Integer.toString(first_num_int - Integer.parseInt(str_num)));
                }
                break;
//            case '/':
//                if (Float.parseFloat(this.str_num) != 0)
//                    res = this.first_num / Float.parseFloat(this.str_num);
//                else
//                    Toast.makeText(this, "На ноль делить нельзя!!!", Toast.LENGTH_SHORT).show();
//                ;
//                break;
//            case '*':
//                res = this.first_num * Float.parseFloat(this.str_num);
//                break;
            default:
                Toast.makeText(this, "Somting wrong", Toast.LENGTH_SHORT).show();
        }


        clear();

    }

    private void intDisplay(String s) {
        calcDisplay.setText(s);
    }

    private void floatDisplay(String s) {
        calcDisplay.setText(s);
    }

    public void clear() {
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
        this.cast = "";
        this.first_num_float = 0.0f;
        this.first_num_int = 0;
    }


    // Сохранение данных
    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putString(Key, calcDisplay.getText().toString());
        instanceState.putParcelable(Key, (Parcelable) calcDisplay);
    }

    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calcDisplay.setText(instanceState.getString(Key));

    }

}