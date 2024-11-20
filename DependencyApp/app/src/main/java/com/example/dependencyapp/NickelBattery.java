package com.mastercoding.dependencyapp;

import android.util.Log;

import javax.inject.Inject;

public class NickelBattery implements Battery {

    // 1- Annotate the constructor
    // 2- Create a module class
    // 3- Add the module in the component

    @Inject
    public NickelBattery(){

    }




    @Override
    public void showType() {
        Log.v("TAGY","This is a nickel Battery");
    }
}
