package com.example.quadraticequation;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequation.databinding.ActivityMainBinding;

public class Equation extends BaseObservable {

    private  String a;
    private String b;
    private  String c;

    ActivityMainBinding binding;

    public Equation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public Equation() {
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

   @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    public void solveEquation(View view){

        int a=Integer.parseInt(this.a);
        int b=Integer.parseInt(this.b);
        int c=Integer.parseInt(this.c);



        Double delta, x1,x2;

        delta= (double) (b*b -4*a*c);

        if(delta<0){
         binding.solution.setText("No real solution");
        } else if (delta==0) {
           x1= (double) (-b/ (2*a));
            binding.solution.setText("X ="+x1);
        }else if (delta>0){
       x1=(-b+Math.sqrt(delta))/(2*a);
            x2=(-b-Math.sqrt(delta))/(2*a);
            binding.solution.setText("X1 ="+x1+" "+"X2 ="+x2);
        }


    }
}
