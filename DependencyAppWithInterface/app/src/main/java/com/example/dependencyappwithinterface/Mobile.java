package com.example.dependencyappwithinterface;

import javax.inject.Inject;

public class Mobile {
    Battery battery;
    MemoryCard memoryCard;
    CPU cpu;

    // Now battery is an interface !!

    // We can't pass battery interface, we need to pass a child
    @Inject
    public Mobile(Battery battery, MemoryCard memoryCard, CPU cpu) {
        this.battery = battery;
        this.memoryCard = memoryCard;
        this.cpu = cpu;
    }


    public void ringNow(){
        System.out.println("Ringing");
    }


}
