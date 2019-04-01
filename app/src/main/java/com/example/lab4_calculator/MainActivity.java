package com.example.lab4_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math.*;

public class MainActivity extends AppCompatActivity {
    boolean isEmpty = true;
    double a=0.0;
    double b=0.0;
    char sign = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isEmpty",isEmpty);
        outState.putDouble("a",a);
        outState.putDouble("b",b);
        outState.putChar("sign",sign);
        TextView textView = findViewById(R.id.textView);
        outState.putString("textView",textView.getText()+"");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isEmpty = savedInstanceState.getBoolean("isEmpty");
        a = savedInstanceState.getDouble("a");
        b = savedInstanceState.getDouble("b");
        sign = savedInstanceState.getChar("sign");
        TextView textView = findViewById(R.id.textView);
        textView.setText(savedInstanceState.getString("textView"));
    }

    public void pressButton(View view) {
        TextView textView = findViewById(R.id.textView);
        Button button = (Button)view;
        String s = button.getText()+"";
        String temp = textView.getText()+"";
        try {
            switch (s) {
                case "0":
                    if (isEmpty) {
                        textView.setText("0");
                    } else
                        textView.setText(temp + "0");
                    break;
                case "1":
                    if (isEmpty) {
                        textView.setText("1");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "1");
                    break;
                case "2":
                    if (isEmpty) {
                        textView.setText("2");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "2");
                    break;
                case "3":
                    if (isEmpty) {
                        textView.setText("3");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "3");
                    break;
                case "4":
                    if (isEmpty) {
                        textView.setText("4");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "4");
                    break;
                case "5":
                    if (isEmpty) {
                        textView.setText("5");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "5");
                    break;
                case "6":
                    if (isEmpty) {
                        textView.setText("6");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "6");
                    break;
                case "7":
                    if (isEmpty) {
                        textView.setText("7");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "7");
                    break;
                case "8":
                    if (isEmpty) {
                        textView.setText("8");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "8");
                    break;
                case "9":
                    if (isEmpty) {
                        textView.setText("9");
                        isEmpty = false;
                    } else
                        textView.setText(temp + "9");
                    break;
                case ",":
                    if (isEmpty)
                        isEmpty = false;
                    textView.setText(temp + '.');
                    break;
                case "x":
                    if (sign != '0') {
                        b = Double.parseDouble(temp);
                        a = count(a, b, sign);
                        b = 0.0;
                        sign = 'x';
                        isEmpty = true;
                        textView.setText(a + "");
                    } else {
                        sign = 'x';
                        a = Double.parseDouble(textView.getText() + "");
                        isEmpty = true;
                    }
                    break;
                case "/":
                    if (sign != '0') {
                        b = Double.parseDouble(temp);
                        a = count(a, b, sign);
                        b = 0.0;
                        sign = '/';
                        isEmpty = true;
                        textView.setText(a + "");
                    } else {
                        sign = '/';
                        a = Double.parseDouble(textView.getText() + "");
                        isEmpty = true;
                    }
                    break;
                case "+":
                    if (sign != '0') {
                        b = Double.parseDouble(temp);
                        a = count(a, b, sign);
                        b = 0.0;
                        sign = '+';
                        isEmpty = true;
                        textView.setText(a + "");
                    } else {
                        sign = '+';
                        a = Double.parseDouble(textView.getText() + "");
                        isEmpty = true;
                    }
                    break;
                case "-":
                    if (sign != '0') {
                        b = Double.parseDouble(temp);
                        a = count(a, b, sign);
                        b = 0.0;
                        sign = '-';
                        isEmpty = true;
                        textView.setText(a + "");
                    } else {
                        sign = '-';
                        a = Double.parseDouble(textView.getText() + "");
                        isEmpty = true;
                    }
                    break;
                case "=":
                    if (sign != '0') {
                        b = Double.parseDouble(textView.getText() + "");
                        a = count(a, b, sign);
                        textView.setText(a + "");
                        isEmpty = true;
                        sign = '0';
                        b = 0.0;
                    }
                    break;
                case "AC":
                    a = 0.0;
                    b = 0.0;
                    sign = '0';
                    isEmpty = true;
                    textView.setText("0");
                    break;
                case "+/-":
                    if (!temp.equals("0") && !temp.equals("0.0")) {
                        String s1 = textView.getText() + "";
                        double d1 = Double.parseDouble(s1);
                        d1 *= -1;
                        textView.setText(d1 + "");
                    }
                    break;
                case "%":
                    if (sign == 'x') {
                        b = Double.parseDouble(temp);
                        a =a/100*b;
                        b = 0.0;
                        sign = '0';
                        isEmpty = true;
                        textView.setText(a + "");
                        a=0.0;
                    }
                    break;
                case "log10":
                    if (sign != '0') {
                        b = Double.parseDouble(textView.getText() + "");
                        a = count(a, b, sign);
                        a = Math.log10(a);
                        textView.setText(a + "");
                        isEmpty = true;
                        sign = '0';
                        b = 0.0;
                    } else {
                        a = Double.parseDouble(textView.getText() + "");
                        a = Math.log10(a);
                        textView.setText(a+"");
                        isEmpty = true;
                    }
                    break;
                case "x!":
                    if (sign != '0') {
                        b = Double.parseDouble(textView.getText() + "");
                        a = count(a, b, sign);
                        a = factorial(a);
                        textView.setText(a + "");
                        isEmpty = true;
                        sign = '0';
                        b = 0.0;
                    } else {
                        a = Double.parseDouble(textView.getText() + "");
                        a = factorial(a);
                        textView.setText(a+"");
                        isEmpty = true;
                    }
                    break;
                case "SQRT(X)":
                    if (sign != '0') {
                        b = Double.parseDouble(textView.getText() + "");
                        a = count(a, b, sign);
                        a = Math.sqrt(a);
                        textView.setText(a + "");
                        isEmpty = true;
                        sign = '0';
                        b = 0.0;
                    } else {
                        a = Double.parseDouble(textView.getText() + "");
                        a = Math.sqrt(a);
                        textView.setText(a+"");
                        isEmpty = true;
                    }
                    break;
                case "x^3":
                    if (sign != '0') {
                        b = Double.parseDouble(textView.getText() + "");
                        a = count(a, b, sign);
                        a = a * a * a;
                        textView.setText(a + "");
                        isEmpty = true;
                        sign = '0';
                        b = 0.0;
                    } else {
                        a = Double.parseDouble(textView.getText() + "");
                        a = a * a * a;
                        textView.setText(a+"");
                        isEmpty = true;
                    }
                    break;
                case "x^2":
                    if (sign != '0') {
                        b = Double.parseDouble(textView.getText() + "");
                        a = count(a, b, sign);
                        a = a * a;
                        textView.setText(a + "");
                        isEmpty = true;
                        sign = '0';
                        b = 0.0;
                    } else {
                        a = Double.parseDouble(textView.getText() + "");
                        a = a * a;
                        textView.setText(a+"");
                        isEmpty = true;
                    }
                    break;
                default:
                    textView.setText("Error");
                    break;

            }

        }
        catch (Exception e) {
            textView.setText("0");
            a = 0.0;
            b = 0.0;
            sign = '0';
            isEmpty = true;
            openMyPopup();
        }
    }

    private double count(double a,double b,char sign){
        double temp = 0.0;
        switch (sign){
            case '+':
                temp=a+b;
                break;
            case '-':
                temp=a-b;
                break;
            case 'x':
                temp=a*b;
                break;
            case  '/':
                temp=a/b;
                break;
            case  '%':
                temp=a/b*100;
                break;
        }
        return temp;
    }

    private double factorial(double a){
        if (a<0)
            throw new IllegalArgumentException("asd");
        double fact =1;
        for (int i =(int)a;i>1;i--)
            fact*=i;
        return fact;
    }

    private void openMyPopup(){
        ErrorPopup errorPopup = new ErrorPopup();
        errorPopup.show(getSupportFragmentManager(),"asd");
    }


}




