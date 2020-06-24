package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        EditText getFirstNumber = findViewById(R.id.first_number_enter);
        EditText getSecondNumber = findViewById(R.id.second_number_enter);
        if (getFirstNumber.getText().toString().equals("") || getSecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Number is missing", Toast.LENGTH_SHORT).show();
        }

       else {
            double first = Double.parseDouble(getFirstNumber.getText().toString());
            double second = Double.parseDouble(getSecondNumber.getText().toString());
            Intent intent = new Intent(MainActivity.this, outputActivity.class);
            switch (v.getId()) {
                case R.id.addition:
                    double sum = first + second;
                    intent.putExtra("num", sum);
                    startActivity(intent);
                    break;
                case R.id.subtraction:
                    double diff = first - second;
                    intent.putExtra("num", diff);
                    startActivity(intent);
                    break;
                case R.id.multiplication:
                    double mult = first * second;
                    intent.putExtra("num", mult);
                    startActivity(intent);
                    break;
                case R.id.divide:
                    if (second == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        double division = first / second;
                        intent.putExtra("num", division);
                        startActivity(intent);
                        break;
                    }
            }

        }
    }
}