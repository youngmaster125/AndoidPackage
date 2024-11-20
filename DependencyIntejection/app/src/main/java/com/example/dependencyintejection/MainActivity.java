package com.example.dependencyintejection;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Dependency Injection without Dagger

//        Battery battery = new Battery(100);
//        MemoryCard memoryCard = new MemoryCard(1024);
//        Processor processor = new Processor("Intel");
//        CPU cpu = new CPU(processor);
//
//        Mobile mobile = new Mobile(battery,memoryCard,cpu);


    // Dependency Injection With Dagger
    // We Need to annotate with @Inject all the constructors of these classes:
    // Mobile, Battery, CPU, Processor, MemoryCard

    // Use @Inject to annotate the constructor that Dagger should use
    // to create instances of a class. When a new instance is requested,
    // Dagger will obtain the required parameters values and invoke this constructor.



    // Now Dagger generates the codes for DI,
    // To us Dagger generated codes for DI, we need to create an Interface annotated with
    // @Component

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

        Engline engline=new Engline();
        Car car=new Car(engline);

        car.start();

    }
}