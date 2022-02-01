package com.example.h7j2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }

    private TextView tvResult;
    private Integer firstValue, secondValue;
    private String operation;
    private Boolean isResultSuccess = false;



    public void onClickNumber(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                textNumber("1");
                break;
            case R.id.btn_two:
                textNumber("2");
                break;
            case R.id.btn_three:
                textNumber("3");
                break;
            case R.id.btn_four:
                textNumber("4");
                break;
            case R.id.btn_five:
                textNumber("5");
                break;
            case R.id.btn_six:
                textNumber("6");
                break;
            case R.id.btn_seven:
                textNumber("7");
                break;
            case R.id.btn_eight:
                textNumber("8");
                break;
            case R.id.btn_nine:
                textNumber("9");
                break;
            case R.id.btn_null:
                textNumber("0");
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                break;

        }
    }

    private void textNumber(String number){
        if (isResultSuccess){
            tvResult.setText("");
            isResultSuccess = false;
        }
        if (tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }else {
            tvResult.append(number);
        }
    }

    public void onClickOperation(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "+");
                operation = "+";
                break;
            case R.id.btn_minus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "-");
                operation = "-";
                break;
            case R.id.btn_del:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "/");
                operation = "/";
                break;
            case R.id.btn_x:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "*");
                operation = "*";
                break;
            case R.id.btn_equal:
                secondValue = Integer.parseInt(tvResult.getText().toString()
                        .replace(firstValue + operation, ""));
                switch (operation){
                    case "+":
                        tvResult.setText(firstValue + operation + secondValue +  "\n=" + (firstValue+secondValue));
                    break;
                    case "-":
                        tvResult.setText(firstValue + operation + secondValue +  "\n=" + (firstValue-secondValue));
                        break;
                    case "/":
                        tvResult.setText(firstValue + operation + secondValue +  "\n=" + (firstValue/secondValue));
                        break;
                    case "*":
                        tvResult.setText(firstValue + operation + secondValue +  "\n=" + (firstValue*secondValue));
                        break;
                }
                break;

        }
    }
}

