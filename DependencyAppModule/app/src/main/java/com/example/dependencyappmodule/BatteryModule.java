
package com.example.dependencyappmodule;

import com.example.dependencyappmodule.Battery;

import dagger.Module;
import dagger.Provides;

@Module
public class BatteryModule {

    @Provides
    Battery provideBattery(){
        return new Battery();
    }

}
