package com.example.viewmodelandlivedata;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;

public   class  MyViewModel extends ViewModel  {

    MutableLiveData<Integer> counter  = new MutableLiveData<>();

    public void increaseCounter(View view){

     int currentValue=counter.getValue()!=null ?counter.getValue():0;
        counter.setValue(currentValue+1);
    }

    public MutableLiveData<Integer> getCounter() {

        return counter;
    }





}
