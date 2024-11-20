package com.example.dependencyappwithinterface;

import javax.inject.Inject;

public class CPU {

    Processor processor;

    @Inject
    public CPU(Processor processor) {
        this.processor = processor;
    }

}
