package com.example.homeworkcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "123";
    private ImageView zero;
    private ImageView one;
    private ImageView two;
    private ImageView three;
    private ImageView four;
    private ImageView five;
    private ImageView six;
    private ImageView seven;
    private ImageView eight;
    private ImageView nine;
    private ImageView add;
    private ImageView minus;
    private ImageView multiply;
    private ImageView divide;
    private ImageView clear;
    private ImageView dot;
    private ImageView Equ;
    private TextView formula;
    private TextView mResult;
    private double valueResult = 0;
    private double value2;
    private int valueLength = 0;
    private boolean isFirstTime = true;
    private List<Double> savedValue = new ArrayList<Double>();
    private List<String> savedOperator = new ArrayList<String>();

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "9");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputValue("+");

                CURRENT_ACTION = ADDITION;

                formula.setText(formula.getText().toString() + "+");

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputValue("-");
                CURRENT_ACTION = SUBTRACTION;
                formula.setText(formula.getText().toString() + "-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputValue("*");

                CURRENT_ACTION = MULTIPLICATION;
                formula.setText(formula.getText().toString() + "*");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputValue("/");
                CURRENT_ACTION = DIVISION;
                formula.setText(formula.getText().toString() + "/");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + ".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText("");
                mResult.setText("");
                valueResult = 0;
                value2 =0;
                isFirstTime = true;
                savedOperator = new ArrayList<>();
                savedValue = new ArrayList<>();

            }
        });
        Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputValue("=");
                compute();

            }
        });
    }
    private void getInputValue(String operator) {
        if (isFirstTime == true){
            value2 = Double.parseDouble(formula.getText().toString());
            isFirstTime = false;
            valueLength = formula.getText().toString().length();
        }
        else {
            value2 = Double.parseDouble(formula.getText().toString().substring(valueLength + 1));
            valueLength = formula.getText().toString().length();
        }
        savedValue.add(value2);
        if (!operator.equals("=")){
            savedOperator.add(operator);
        }
    }

    private void compute(){
        for (int i = 0; i<savedOperator.size(); i++){
            if (savedOperator.get(i).equals("*")){
                double result = savedValue.get(i) * savedValue.get(i+1);
                List<Double> temp = new ArrayList<Double>();
                temp.addAll(savedValue.subList(0, i));
                temp.add(result);
                temp.addAll(savedValue.subList(i+2, savedValue.size()));
                savedValue = temp;
                List<String> tempOpt = new ArrayList<>();

                tempOpt = savedOperator.subList(0, i);

                tempOpt.addAll(savedOperator.subList(i+1, savedOperator.size()));
                savedOperator = tempOpt;
                compute();
                break;
            }
            else if ("/".equals(savedOperator.get(i))){
                double result = savedValue.get(i) / savedValue.get(i+1);
                List<Double> temp = new ArrayList<Double>();
                temp.addAll(savedValue.subList(0, i));
                temp.add(result);
                temp.addAll(savedValue.subList(i+2, savedValue.size()));
                savedValue = temp;
                List<String> tempOpt = new ArrayList<>();

                tempOpt = savedOperator.subList(0, i);

                tempOpt.addAll(savedOperator.subList(i+1, savedOperator.size()));
                savedOperator = tempOpt;
                compute();
                break;
            }
        }
        for (int i = 0; i<savedOperator.size(); i++){
            if ("+".equals(savedOperator.get(i))){
                double result = savedValue.get(i) + savedValue.get(i+1);
                List<Double> temp = new ArrayList<Double>();
                temp.addAll(savedValue.subList(0, i));
                temp.add(result);
                temp.addAll(savedValue.subList(i+2, savedValue.size()));
                savedValue = temp;
                List<String> tempOpt = new ArrayList<>();

                tempOpt = savedOperator.subList(0, i);

                tempOpt.addAll(savedOperator.subList(i+1, savedOperator.size()));
                savedOperator = tempOpt;
                compute();
                break;
            }
            else if ("-".equals(savedOperator.get(i))){
                double result = savedValue.get(i) - savedValue.get(i+1);
                List<Double> temp = new ArrayList<Double>();
                temp.addAll(savedValue.subList(0, i));
                temp.add(result);
                temp.addAll(savedValue.subList(i+2, savedValue.size()));
                savedValue = temp;
                List<String> tempOpt = new ArrayList<>();

                tempOpt = savedOperator.subList(0, i);

                tempOpt.addAll(savedOperator.subList(i+1, savedOperator.size()));
                savedOperator = tempOpt;
                compute();
                break;
            }
        }
        mResult.setText(savedValue.get(0).toString());

    }

    private void setupUIViews(){
        zero = (ImageView) findViewById(R.id.buttonZero);
        one = (ImageView) findViewById(R.id.buttonOne);
        two = (ImageView) findViewById(R.id.buttonTwo);
        three = (ImageView) findViewById(R.id.buttonThree);
        four = (ImageView) findViewById(R.id.buttonFour);
        five = (ImageView) findViewById(R.id.buttonFive);
        six = (ImageView) findViewById(R.id.buttonSix);
        seven = (ImageView) findViewById(R.id.buttonSeven);
        eight = (ImageView) findViewById(R.id.buttonEight);
        nine = (ImageView) findViewById(R.id.buttonNine);
        add = (ImageView) findViewById(R.id.buttonPlus);
        minus = (ImageView) findViewById(R.id.buttonMinus);
        mResult = (TextView) findViewById(R.id.Result);
        multiply = (ImageView) findViewById(R.id.buttonMultiply);
        divide = (ImageView) findViewById(R.id.buttonDivide);
        clear = (ImageView) findViewById(R.id.buttonClear);
        dot = (ImageView) findViewById(R.id.buttonDot);
        Equ = (ImageView) findViewById(R.id.buttonEqual);
        formula = (TextView) findViewById(R.id.CalculationFormula);
    }
}
