package com.example.homeworkcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    private TextView formula;
    private TextView result;
    private double value1;
    private double value2;


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
                compute();
                CURRENT_ACTION = ADDITION;
                formula.setText(formula.getText().toString() + "+");

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = SUBTRACTION;
                formula.setText(formula.getText().toString() + "-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = MULTIPLICATION;
                formula.setText(formula.getText().toString() + "x");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
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
            }
        });
    }

    private void compute(){

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
        multiply = (ImageView) findViewById(R.id.buttonMultiply);
        divide = (ImageView) findViewById(R.id.buttonDivide);
        clear = (ImageView) findViewById(R.id.buttonClear);
        dot = (ImageView) findViewById(R.id.buttonDot);


        formula = (TextView) findViewById(R.id.CalculationFormula);
    }
}
