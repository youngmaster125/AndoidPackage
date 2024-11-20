package com.example.normalrecyleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.normalrecyleview.cardviewy.CardViewActivity;

import com.example.normalrecyleview.multiselect.MultiSelection;
import com.example.normalrecyleview.multiviewtype.MultiTypeViewActivity;
import com.example.normalrecyleview.normalrecycler.NormalRecyclerView;
import com.example.normalrecyleview.singles.SingleSelectionRV;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
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

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NormalRecyclerView.class);
                startActivity(i);
            }
        });

        btn2 = findViewById(R.id.button_cardview);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(i);
            }
        });

          btn3 = findViewById(R.id.button_single_selection);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SingleSelectionRV.class);
                startActivity(i);
            }
        });



        btn6 = findViewById(R.id.button_multiview);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MultiTypeViewActivity.class);
                startActivity(i);
            }
        });

        btn4 = findViewById(R.id.button_multi_selction);
         btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MultiSelection.class);
                startActivity(i);
            }
        });
         /*
        btn5 = findViewById(R.id.button_swipe);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SwipeSelectionActivity.class);
                startActivity(i);
            }
        });


         */
    }
}