package com.example.mvcpattern;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btn; TextView textView;
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
        // App IDEA: We need to create a button that when the user
        // clicked it,  it will display text in textview
        // 1- Implementing MVC Pattern
        btn = findViewById(R.id.button);

        textView = findViewById(R.id.textView);

        // prettyfing the code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayAppinText();
            }
        });

    }



    public MyModel GetAppFromModel(){

        return new MyModel("Master Coding App",900000,4);
    }

    public void DisplayAppinText(){
        textView.setText(GetAppFromModel().getAppName() + " Downloads "
                + GetAppFromModel().getAppDownloads());

    }


    //     MVC Pattern
    // View: TextView
    // Model: MyModel class
    // Controller: MainActivity



}