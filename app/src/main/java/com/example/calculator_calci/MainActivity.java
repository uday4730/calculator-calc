package com.example.calculator_calci;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);


        display = findViewById(R.id.editText);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString()))
                { display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveBTN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }

    public void clear(View view){
       display.setText("");
       textView.setText("");
    }
    public void exponential(View view){
        updateText("^");
    }
    public void parenthesis(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for(int i=0; i< cursorPos; i++)
        {
            if(display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if(display.getText().toString().substring(i, i+1).equals(")")){
                closedPar += 1;
            }

        }

        if(openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");

        }
        else if(closedPar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");

        }
        display.setSelection(cursorPos + 1);

    }
    public void plusMinus(View view){
        updateText("-");
    }
    public void point(View view){
        updateText(".");
    }
    public void equals(View view){
        String userExp = display.getText().toString();

        textView.setText(userExp);

        userExp = userExp.replaceAll("÷", "/");
        userExp =userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void add(View view){
        updateText("+");
    }
    public void sub(View view){
        updateText("-");
    }
    public void mul(View view){
        updateText("×");
    }
    public void div(View view){
        updateText("÷");
    }
    public void backspace(View view){
        int cursorPos = display.getSelectionStart();
        int textLen =display.getText().length();

        if(cursorPos != 0 && textLen != 0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace( cursorPos -1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos -1);
        }
    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTannBTNPush(View view){
        updateText("arctan(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void squareRootBTNPush(View view){
        updateText("sqrt(");
    }

    public void eTextBTNPush(View view){
        updateText("e");
    }

    public void piTextBTNPush(View view){
        updateText("pi");
    }

    public void absoluteValueBTNPush(View view){
        updateText("abs(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }

    public void xSquareBTNPush(View view){
        updateText("^(2)");
    }

    public void xSquareYBTNPush(View view){
        updateText("^(");
    }


}