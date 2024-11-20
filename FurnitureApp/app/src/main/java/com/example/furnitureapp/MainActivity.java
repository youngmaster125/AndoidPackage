package com.example.furnitureapp;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Step 1: Designing Main Layout
    // Step 2; CardView Design (Primary Cards)
    // Step 3; CardView Design (Secondary Cards)

    //Primary Cards
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    private Context mContext;


    // Secondary Cards
    private static RecyclerView.Adapter adapter2;
    private RecyclerView.LayoutManager layoutManager2;
    private static RecyclerView recyclerView2;
    private static ArrayList<DataModel> data2;



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
        // 1- Create main Cards
        InitiateMainCards();

        // 2- Create secondary cards
        InitiateSecondaryCards();
    }
    private void InitiateMainCards() {
        // This method for primary cards

        recyclerView = findViewById(R.id.recyclerViewPrimary);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Getting Data from MyData Class
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

        // Let's Add the Adapter (Custom Adapter - we will create now)
        adapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(adapter);

    }



    private void InitiateSecondaryCards() {

        recyclerView2 = findViewById(R.id.recyclerViewSecondary);
        recyclerView2.setHasFixedSize(true);


        layoutManager2 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false);


        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());


        // Getting Data from MyData Class
        data2 = new ArrayList<DataModel>();
        for (int i = 0; i < MyData2.nameArray.length; i++) {
            data2.add(new DataModel(
                    MyData2.nameArray[i],
                    MyData2.versionArray[i],
                    MyData2.id_[i],
                    MyData2.drawableArray[i]
            ));
        }

        // Let's Add the Adapter (Custom Adapter - we will create now)
        adapter2 = new CustomAdapter2(data2, this);
        recyclerView2.setAdapter(adapter2);

    }
}