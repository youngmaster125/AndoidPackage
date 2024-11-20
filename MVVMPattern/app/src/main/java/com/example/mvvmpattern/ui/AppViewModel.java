package com.example.mvvmpattern.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmpattern.util.MyModel;


public class AppViewModel extends ViewModel {

    // 4- Live Data
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();


    // 3- Connecting ViewModel with DATABASE - (MODEL)
    private MyModel getAppFromDatabase(){

        return new MyModel("Master Coding App", 900000,4);
    }

    // 5- Connecting ViewModel with MainActivity (VIEW)
   public void getAppName(){
        String appName = getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
   }


}
