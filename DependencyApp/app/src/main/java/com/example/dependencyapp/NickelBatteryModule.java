package com.mastercoding.dependencyapp;

import dagger.Module;
import dagger.Provides;

@Module
public class NickelBatteryModule {

    // Dagger will recognize this dependency as a battery
    @Provides
    Battery provideNickelBattery(NickelBattery nickelBattery){
        nickelBattery.showType();
        return nickelBattery;
    }

}
