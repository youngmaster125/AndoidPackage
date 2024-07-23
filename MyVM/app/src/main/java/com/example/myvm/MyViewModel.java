package com.example.myvm;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    int a=0;

    public MyViewModel() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
