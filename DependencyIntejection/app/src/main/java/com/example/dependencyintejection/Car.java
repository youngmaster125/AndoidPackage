package com.example.dependencyintejection;

public class Car  {

    Engline engline;

    public Car(Engline engline) {
        this.engline = engline;
    }

    public  void start(){
        engline.start();
    }
}
