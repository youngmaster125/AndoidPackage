package com.example.dependencyappwithinterface;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /**
     * In some cases, you need to pass an interface as constructor parameter (Dependency),
     * So you need to configure the interface to allow the injection
     *
     *
     * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Dependency Injection without Dagger
        // Battery battery = new Battery(100);
        // MemoryCard memoryCard = new MemoryCard(1024);
        // Processor processor = new Processor("Intel");
        // CPU cpu = new CPU(processor);

        // Mobile mobile = new Mobile(battery,memoryCard,cpu);


        // Dependency Injection With Dagger
        // Now Dagger generates the codes for DI,
        // To us Dagger generated codes for DI, we need to create an Interface annotated with
        // @Component

        Mobile mobile;
        MobileComponent mobileComponent = DaggerMobileComponent.create();



        mobile = mobileComponent.getMobile();

        mobile.ringNow();



    }
}