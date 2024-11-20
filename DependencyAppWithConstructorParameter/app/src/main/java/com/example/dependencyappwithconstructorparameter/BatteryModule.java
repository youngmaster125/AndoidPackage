package com.example.dependencyappwithconstructorparameter;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class BatteryModule {
    private int batteryPercentage;

    public BatteryModule(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    @Provides
    Battery provideBattery(){
        Log.v("TAGY", "The Percentage is : "+batteryPercentage);
        return new Battery();
    }
}
