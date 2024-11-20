package com.example.dependencyappmodule;

import dagger.Component;

@Component(modules = BatteryModule.class)
public interface MobileComponent {
    Mobile getMobile();
}
