package com.example.dependencyappwithconstructorparameter;

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



    // We learned how to make Dependency Injection with Empty Constructors

    /***
     * IN This lesson, we are going to learn how to make DI with states in constructors
     *  (Parameters in Constructor)
    **/


}
