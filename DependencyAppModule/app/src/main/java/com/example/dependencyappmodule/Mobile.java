package com.example.dependencyappmodule;

import javax.inject.Inject;

public class Mobile {


    Battery battery;
    MemoryCard memoryCard;
    CPU cpu;


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
