package com.example.homeworkcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView one;
    private TextView formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formula.setText(formula.getText().toString() + "1");
            }
        });





    }

    private void setupUIViews(){
        one = (ImageView) findViewById(R.id.buttonOne);
        formula = (TextView) findViewById(R.id.CalculationFormula);
    }
}
