package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.itis.libs.parserng.android.expressParser.MathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button equalsBtn, addBtn, timesBtn, minusBtn, divideBtn,
            btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, resetBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        equalsBtn = findViewById(R.id.equalsBtn);
        equalsBtn.setOnClickListener(this);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
        timesBtn = findViewById(R.id.timesBtn);
        timesBtn.setOnClickListener(this);
        minusBtn = findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(this);
        divideBtn = findViewById(R.id.divideBtn);
        divideBtn.setOnClickListener(this);

        resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(this);

        btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);
        btnTwo = findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);
        btnThree = findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);
        btnFour = findViewById(R.id.btnFour);
        btnFour.setOnClickListener(this);
        btnFive = findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);
        btnSix = findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);
        btnSeven = findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(this);
        btnEight = findViewById(R.id.btnEight);
        btnEight.setOnClickListener(this);
        btnNine = findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);

        resultText = findViewById(R.id.resultText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOne:
                resultText.setText(resultText.getText() + "1");
                break;
            case R.id.btnTwo:
                resultText.setText(resultText.getText() + "2");
                break;
            case R.id.btnThree:
                resultText.setText(resultText.getText() + "3");
                break;
            case R.id.btnFour:
                resultText.setText(resultText.getText() + "4");
                break;
            case R.id.btnFive:
                resultText.setText(resultText.getText() + "5");
                break;
            case R.id.btnSix:
                resultText.setText(resultText.getText() + "6");
                break;
            case R.id.btnSeven:
                resultText.setText(resultText.getText() + "7");
                break;
            case R.id.btnEight:
                resultText.setText(resultText.getText() + "8");
                break;
            case R.id.btnNine:
                resultText.setText(resultText.getText() + "9");
                break;
            case R.id.addBtn:
                if (ensureValid(resultText.getText().toString(), resultText.getText().length()))
                    resultText.setText(resultText.getText() + "+");
                break;
            case R.id.timesBtn:
                if (ensureValid(resultText.getText().toString(), resultText.getText().length()))
                    resultText.setText(resultText.getText() + "*");
                break;
            case R.id.divideBtn:
                if (ensureValid(resultText.getText().toString(), resultText.getText().length()))
                    resultText.setText(resultText.getText() + "/");
                break;
            case R.id.minusBtn:
                if (ensureValid(resultText.getText().toString(), resultText.getText().length()))
                    resultText.setText(resultText.getText() + "-");
                break;
            case R.id.equalsBtn:
                if (ensureValid(resultText.getText().toString(), resultText.getText().length()))
                    resultText.setText(calculate(resultText.getText().toString()) + "");
                break;
            case R.id.resetBtn:
                resultText.setText("");
                break;
            default:
                break;
        }

    }

    public boolean ensureValid(String str, int charPos) {
        if (charPos > 0) {
            String lastChar = str.substring(charPos - 1);
            return isNumeric(lastChar);
        }
        return isNumeric(str.substring(charPos));
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;

        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public double calculate(String calculation) {
        MathExpression expr = new MathExpression(calculation);
        double res = Double.parseDouble(expr.solve());
        return  res;
    }





}